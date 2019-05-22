package project.thangnd.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import project.thangnd.dtos.Food_Dto;
import project.thangnd.models.Food;
import project.thangnd.models.Restaurant;
import project.thangnd.models.User;
import project.thangnd.models.UserHistory;
import project.thangnd.services.LoginService;
import project.thangnd.services.RestaurantService;
import project.thangnd.utils.ConvertPassword;
//import project.thangnd.utils.LoadFood;

@Controller
public class LoginController {
	Logger logger = Logger.getLogger(LoginController.class);
	List<Food_Dto> LIST_DTO_FOOD = new ArrayList<>();
//	LoadFood loadFood = new LoadFood();
	ConvertPassword convertPass = new ConvertPassword();
	@Autowired
	private LoginService loginService;
	
	@Autowired 
	private RestaurantService restService;
	
	public  User USER_INFO = new User();
	
	/*
	 * load form login admin
	 */
	@RequestMapping(value="loadlogin")
	public ModelAndView loadLogin(){
		return new ModelAndView("admin/login");
	}
	
	/*
	 * load form login customer
	 */
	@RequestMapping(value="load-login")
	public String loadLoginCustomer(){
		return "login";
	}
	
	/*
	 * Logout focous
	 */
	@RequestMapping(value="logout-username/{username}")
	public ModelAndView logoutUsername(@PathVariable String username, HttpSession session){
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("loginController #logout-username");
			int i = loginService.logoutUserByName(username);
			if(i == 1 ){
				sb.append("logout success");
				session.removeAttribute("user");
			}else{
				sb.append("logout failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("LoginController #logout-user error");
		}
//		System.out.println(sb);
		logger.info(sb);
		return null;
	}
	
	@RequestMapping(value="admin/loginform")
	public ModelAndView loginform(){
		
		return new ModelAndView("admin/login");
	}
	
	@RequestMapping(value="admin/loadadmin")
	public ModelAndView loadadmin(){
		
		return new ModelAndView("admin/admin");
	}
	
	@RequestMapping(value="admin/login")
	public ModelAndView loginAdmin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session){
		ModelAndView mav = new ModelAndView("admin/login");
		StringBuffer sb = new StringBuffer();
		sb.append("LoginController: #Admin Login: Username: " + username + " Password: " + password );
		String pass_new = convertPass.convertPassword(password);
		User user = new User();
		try {
			user = loginService.getUserByUsePass(username, pass_new);
			
			if(user == null){// check khac nha hang role: R, ca nha: I, Manager: M
				mav.addObject("status", "Tài khoản hoặc mật khẩu không đúng");
				System.out.println("Khong co user nao hoac khong dung vai tro");
			}
			if(user !=null){
				if(user.getRole() == null){
					mav.addObject("status", "Tài khoản không xác thực");
				}
				else if(!user.getRole().equals("R")){
					mav.addObject("status", "Tài khoản không có quyền đăng nhập");
				}else if(user.getUser_status().equals("O") ){
					mav.addObject("status", "Tài khoản đang đăng nhập");
				}else{
					this.setUSER_INFO(user);
					session.setAttribute("user_admin", user);
					String user_name = user.getUsername();
					int user_id = user.getUser_id();
					String user_role = user.getRole();
					String id_send = String.valueOf(user_id) + user_role;
					session.setAttribute("user_id_rest", id_send);
					session.setAttribute("user_name", user_name);
					System.out.println("UserId: " + USER_INFO.getUser_id());
					sb.append(" " +user.toString());
					insertHistoryUser(user.getUser_id());
					updateUserStatus(user.getUser_id());
					Restaurant rest = new Restaurant();
					rest = restService.getRestaurantByIdUser(user.getUser_id());
					if(rest == null){
						mav = new ModelAndView("redirect:/load-restaurant");
					}
					else{
						mav = new ModelAndView("redirect:/admin/food");
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("error login controller #loginAdmin");
			logger.error("error exception");
		}
//		System.out.println(sb);
		logger.info(sb);
		return mav ;
	}
	
	@RequestMapping(value="/check-login")
	public ModelAndView checkLogin(HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user == null){
			return new ModelAndView("redirect:/load-login");
		}else{
			return new ModelAndView("redirect:/trang-chu.html");
		}
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView  login(
			@RequestParam("usename") String usename,
			@RequestParam("password") String password,
			HttpSession session,
			HttpServletResponse response){
		ModelAndView mav = new ModelAndView("login");
		StringBuffer sb = new StringBuffer();
		int result = 0;
		User user = new User();
		try {
			String pass_new = convertPass.convertPassword(password);
			user =  loginService.getUserByUsePass(usename, pass_new);
			if(user == null){
				result = 0;
				System.out.println("Loi roi");
				mav.addObject("status", "Tài khoản hoặc mật khẩu không đúng");
				System.out.println("Khong co user nao hoac khong dung vai tro");
			}else{
				if(user.getRole() == null){
					mav.addObject("status", "Tài khoản không xác thực");
				}
				else if(!user.getRole().equals("C") ){
					mav.addObject("status", "Tài khoản không có quyền đăng nhập");
				}else if(user.getUser_status().equals("O")){
					mav.addObject("status", "Tài khoản đang đăng nhập");
				}else{
					this.setUSER_INFO(user);
					session.setAttribute("user", user);
					String user_name = user.getUsername();
					session.setAttribute("user_name", user_name);
					//add param in websocket 2 value id_send and id_receive
					int user_id = user.getUser_id();
					String user_role = user.getRole();
					String id_receive = String.valueOf(user_id) + user_role;
					
					session.setAttribute("user_id", id_receive);
					//end param in websocket
					System.out.println("UserId: " + USER_INFO.getUser_id());
					sb.append(" " +user.toString());
					insertHistoryUser(user.getUser_id());
					updateUserStatus(user.getUser_id());
//					mav = new ModelAndView("redirect:trangchu");
//					mav = new ModelAndView("redirect:trang-chu.html");
					response.sendRedirect("/Project/trang-chu.html");
					//add information into userhistory
					UserHistory userHis = new UserHistory();
					sb.append("LoginController. Login_ UserHistory: ");
					String session_id = RequestContextHolder.currentRequestAttributes().getSessionId();
					HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
					String pc_ip = request.getLocalName();
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					
					userHis.setSession_id(session_id);
					userHis.setDate(dateFormat.format(date));
					userHis.setPc_ip(pc_ip);
					userHis.setUser_id(user.getUser_id());
					sb.append(" Session_id: " + userHis.getSession_id() + " date: " + userHis.getDate() + " PC_IP: " + userHis.getPc_ip()
								+ " User_id: " + userHis.getUser_id());
					loginService.insertUserHistory(userHis);
					System.out.println(sb.toString());
				}
				System.out.println("Thanhcong ");
			}
			if(user != null){
//				UserHistory userHis = new UserHistory();
//				sb.append("LoginController. Login_ UserHistory: ");
//				String session_id = RequestContextHolder.currentRequestAttributes().getSessionId();
//				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//				String pc_ip = request.getLocalName();
//				String date = java.time.LocalDate.now().toString();
//				userHis.setSession_id(session_id);
//				userHis.setDate(date);
//				userHis.setPc_ip(pc_ip);
//				userHis.setUser_id(user.getUser_id());
//				sb.append(" Session_id: " + userHis.getSession_id() + " date: " + userHis.getDate() + " PC_IP: " + userHis.getPc_ip()
//							+ " User_id: " + userHis.getUser_id());
//				loginService.insertUserHistory(userHis);
//				System.out.println(sb.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = 0;
		}
		
		return mav;
		
	}
	
	@RequestMapping(value="/admin/logout")
	public String logout(HttpSession session){
		User user = (User) session.getAttribute("user_admin");
		if(user == null){
			System.out.println("Error logout");
		}else{
			System.out.println("thangnd +++ user_id: " + user.getUser_id());
			loginService.logoutUser(user.getUser_id());
			session.removeAttribute("user");
			session.removeAttribute("user_name");
		}
		
		
		return "redirect:/admin/loginform";
	}
	
	@RequestMapping(value="/logout")
	public String logoutUser(HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user == null){
			System.out.println("Error logout");
		}else{
			System.out.println("thangnd +++ user_id: " + user.getUser_id());
			loginService.logoutUser(user.getUser_id());
			session.removeAttribute("user");
			session.removeAttribute("user_name");
			session.removeAttribute("order");
		}
		
		
		return "redirect:/trang-chu.html";
	}
	
	/*
	 * insert data into historyUser
	 */
	public void insertHistoryUser(int user_id){
		UserHistory userHis = new UserHistory();
		StringBuffer sb = new StringBuffer();
		sb.append("LoginController. Login_ UserHistory: ");
		String session_id = RequestContextHolder.currentRequestAttributes().getSessionId();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String pc_ip = request.getLocalName();
		String date = java.time.LocalDate.now().toString();
		userHis.setSession_id(session_id);
		userHis.setDate(date);
		userHis.setPc_ip(pc_ip);
		userHis.setUser_id(user_id);
		sb.append(" Session_id: " + userHis.getSession_id() + " date: " + userHis.getDate() + " PC_IP: " + userHis.getPc_ip()
					+ " User_id: " + userHis.getUser_id());
		loginService.insertUserHistory(userHis);
//		System.out.println(sb.toString());
		logger.info(sb);
	}
	
	public void updateUserStatus(int user_id){
		loginService.updateStatusLogin(user_id);
	}

	public User getUSER_INFO() {
		return USER_INFO;
	}

	public void setUSER_INFO(User uSER_INFO) {
		USER_INFO = uSER_INFO;
	}
	
	

}
