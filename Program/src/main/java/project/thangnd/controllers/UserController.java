package project.thangnd.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import project.thangnd.models.User;
import project.thangnd.services.UserService;
import project.thangnd.utils.ConvertPassword;
import project.thangnd.utils.UpLoad;

@Controller
public class UserController {
	Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	private UpLoad upload = new UpLoad();
	
	private ConvertPassword convertPass = new ConvertPassword();
	
	@RequestMapping(value="/saveUser")
	private ModelAndView saveUser(@ModelAttribute("user") User user,@RequestParam("file") MultipartFile file){
		StringBuffer sb = new StringBuffer();
		sb.append("Result: function: saveUser. User ");
		String pass = user.getPassword();
		String new_pass = convertPass.convertPassword(pass);
		user.setPassword(new_pass);
		String date = java.time.LocalDate.now().toString();
		user.setDate(date);
		user.setUser_status("I"); // 3 trang thai I: khoi tao, O: dang su dụng, C: ko su dung
		user.setImage_user(upload.uploadFile(file));
		user.setRole("C");
		sb.append(" Username: " + user.getUsername() + " password: " + user.getPassword() + " email: " + user.getEmail() + 
					" phone: " + user.getPhone() + " date: " + user.getDate() + " status: " + user.getUser_status()  + " Image User: " + user.getImage_user());
//		System.out.println(sb.toString());
		logger.info(sb);
		userService.insertUser(user);
		
		return new ModelAndView("redirect:/trang-chu.html");
	}
	
	@RequestMapping(value="/signup")
	private ModelAndView signup(){
		System.out.println("thanh cong o day");
		return new ModelAndView("signup", "command", new User());
	}
	
	@RequestMapping(value="admin/signup")
	private ModelAndView restSignup(){
		
		return new ModelAndView("admin/signup", "command", new User());
	}
	
	@RequestMapping(value="admin/saveUser")
	private ModelAndView adminSaveUser(@ModelAttribute("user") User user,@RequestParam("file") MultipartFile file){
		StringBuffer sb = new StringBuffer();
		sb.append("Result: function: saveUser. User ");
		String pass = user.getPassword();
		String new_pass = convertPass.convertPassword(pass);
		user.setPassword(new_pass);
		String date = java.time.LocalDate.now().toString();
		user.setDate(date);
		user.setUser_status("I"); // 3 trang thai I: khoi tao, O: dang su dụng, C: ko su dung
		user.setImage_user(upload.uploadFile(file));
		user.setRole("R");
		sb.append(" Username: " + user.getUsername() + " password: " + user.getPassword() + " email: " + user.getEmail() + 
					" phone: " + user.getPhone() + " date: " + user.getDate() + " status: " + user.getUser_status()  + " Image User: " + user.getImage_user());
//		System.out.println(sb.toString());
		logger.info(sb);
		userService.insertUser(user);
		
		return new ModelAndView("redirect:/trang-chu.html");
	}
	
	
	

}
