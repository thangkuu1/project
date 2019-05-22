package project.thangnd.controllers;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.mail.internet.MimeMessage;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import project.thangnd.daos.ProgressDao;
import project.thangnd.dtos.Food_Dto;
import project.thangnd.dtos.Food_Order_Dto;
import project.thangnd.dtos.OrderDetailDto;
import project.thangnd.dtos.TransactionDetailDto;
import project.thangnd.dtos.TransactionDto;
import project.thangnd.models.Food;
import project.thangnd.models.MessageChat;
import project.thangnd.models.Progress;
import project.thangnd.models.Restaurant;
import project.thangnd.models.Trans;
import project.thangnd.models.Transaction_detail;
import project.thangnd.models.User;
import project.thangnd.services.ChatMessageService;
import project.thangnd.services.FoodService;
import project.thangnd.services.ProgressService;
import project.thangnd.services.RestaurantService;
import project.thangnd.services.TransactionDetailService;
import project.thangnd.services.TransactionService;
import project.thangnd.services.UserService;
import project.thangnd.utils.CompareMessChat;
import project.thangnd.utils.ExportExcelDashBoard;
import project.thangnd.utils.SendEmail;

@Controller
public class TransactionController {
	
	Logger logger = Logger.getLogger(TransactionController.class);
	StringBuffer sb = new StringBuffer();
	@Autowired
	private TransactionService transService;
	
	private String emailToRecipient;
//	private String emailFromRecipient = "dinhthangms96@gmail.com";
//	
	@Autowired
	private JavaMailSender mailSenderObj;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private RestaurantService restService;
	
	@Autowired
	private TransactionDetailService transDetailService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private ProgressService progressService;
	
	@Autowired
	private ChatMessageService chatMessService;
	
	@RequestMapping(value="admin/error")
	public ModelAndView errorAdmin(){
		
		return new ModelAndView("admin/error");
	}
	
	@RequestMapping(value="error")
	public ModelAndView error(){
		return new ModelAndView("error");
	}
	
	@RequestMapping(value = "transaction")
	@ResponseBody Map<String, Object> insertTransaction(@RequestParam("address") String address
			, @RequestParam("data_progress") String data_progress , HttpSession session){
		System.out.println("address:  " + address);
		List<Food_Order_Dto> list = (List<Food_Order_Dto>) session.getAttribute("order");

		List<ArrayList<Food_Order_Dto>> listByRestaurants = getListOfFoodByRestaurant(list); 
		//list all food by restaurant
		User user = (User) session.getAttribute("user");
		for(int k = 0; k < listByRestaurants.size(); k++){
			//get transaction by food;
			Double total = 0.0;
			//1.1 insert in table transaction by restaurant
			Trans trans = new Trans();
			for(int i = 0; i < listByRestaurants.get(k).size(); i++){
				total += Double.parseDouble(listByRestaurants.get(k).get(i).getPrice())*(listByRestaurants.get(k).get(i).getCount_food());
//				total += Double.parseDouble(listByRestaurants.get(k).get(i).getPrice() - listByRestaurants.get(k).get(i).get)*(listByRestaurants.get(k).get(i).getCount_food());
			}
			trans.setId_user(String.valueOf(user.getUser_id()));
			trans.setTran_stat("Đặt hàng");
			trans.setId_rest(listByRestaurants.get(k).get(0).getId_rest());
			//1.2 set date in table transaction
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			trans.setDate(dateFormat.format(date));
			trans.setPrice(String.valueOf(total));
			trans.setAddress(address);
			transService.inserTransaction(trans);
			//1.3 insert in table transaction detail
			for(int n = 0; n < listByRestaurants.get(k).size(); n ++){
				Transaction_detail trans_detail = new Transaction_detail();
				trans_detail.setId_food(listByRestaurants.get(k).get(n).getId_food());
				trans_detail.setQuantum(String.valueOf(listByRestaurants.get(k).get(n).getCount_food()));
				trans_detail.setTransaction_id(trans.getId_transaction());
				trans_detail.setPrice_food(String.valueOf(listByRestaurants.get(k).get(n).getPrice()));
				trans_detail.setTrans_stat("0");
				transDetailService.insertTransactionDetail(trans_detail);
			}
			//1.4 insert in table progress
			logger.info("data progress: " + data_progress);
			Gson gson = new Gson();
			Progress progress = gson.fromJson(data_progress, Progress.class);
			progress.setId_progress(trans.getId_transaction());
			logger.info(progress);
			logger.info(progress.toString());
			progressService.insertProgress(progress);
			//1.5 send email to restaurant

			User user_send = userService.getUserById(listByRestaurants.get(k).get(0).getId_rest());
			logger.info("send email: " + listByRestaurants.get(k).get(0).getId_rest());
			SendEmailTo(user_send.getEmail(), listByRestaurants.get(k), trans.getId_transaction(), trans.getPrice());
		}
		session.removeAttribute("order");
//		//code add restaurant
//		Food f = new Food();
//		int id_food = list.get(0).getId_food();
//		f = foodService.getFoodById(id_food);
//		User user = (User) session.getAttribute("user");
//		Trans trans = new Trans();
//		if(user != null){
//			trans.setId_user(String.valueOf(user.getUser_id()));
//		}
//		trans.setTran_stat("Đặt hàng");
//		
//		trans.setId_rest(f.getId_rest());
//		trans.setPrice(String.valueOf(total));
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		trans.setDate(dateFormat.format(date));
//		trans.setAddress(address);
//		//transService.inserTransaction(trans); comment test
//		Transaction_detail trans_detail = new Transaction_detail();
//		for(int j = 0 ; j < list.size(); j++){
//			trans_detail.setId_food(list.get(j).getId_food());
//			trans_detail.setQuantum(String.valueOf(list.get(j).getCount_food()));
//			trans_detail.setTransaction_id(trans.getId_transaction());
//			//transDetailService.insertTransactionDetail(trans_detail); comment test
//		}
//		//insert progress value 'Đang chờ'
//		logger.info("data progress: " + data_progress);
//		Gson gson = new Gson();
//		Progress progress = gson.fromJson(data_progress, Progress.class);
//		progress.setId_progress(trans.getId_transaction());
//		logger.info(progress);
//		logger.info(progress.toString());
//		progressService.insertProgress(progress);
//		// user restaurant send email
//		Restaurant rest_user = restService.getRestaurantById(f.getId_rest());
//		User user_send = userService.getUserById(rest_user.getId_user());
//		//SendEmailTo(user_send.getEmail(), list, trans.getId_transaction(), trans.getPrice()); cmt test
//		session.removeAttribute("order");
//		System.out.println(trans.getId_transaction());
		return null;
	}
	
	private List<ArrayList<Food_Order_Dto>> getListOfFoodByRestaurant(List<Food_Order_Dto> foodOrders){
	
		//01. get list of distance rest_id
		ArrayList<Integer> restIds = new ArrayList<Integer>();
		for(int i =0; i < foodOrders.size(); i++)
		{
			int restId = foodOrders.get(i).getId_rest();
			if (!restIds.contains(restId)){
				restIds.add(restId);
			}
		}
		System.out.println("restaurant id: " + restIds);
		
		//02. get each list of order food by rest_id
		List<ArrayList<Food_Order_Dto>> allListFoodOrderByRest = new ArrayList<ArrayList<Food_Order_Dto>>();
		for(int i = 0; i < restIds.size(); i++){
			//02.01. get curent restaurant id
			int restId = restIds.get(i);
			
			//02.02 get all food orders belong to this restaurant
			ArrayList<Food_Order_Dto> listFoodOrderByRest = new ArrayList<Food_Order_Dto>();
			for(int j = 0; j < foodOrders.size(); j++){
				Food_Order_Dto foodOrder = foodOrders.get(j);
				if (foodOrder.getId_rest() == restId){
					listFoodOrderByRest.add(foodOrder);
				}
			}
			allListFoodOrderByRest.add(listFoodOrderByRest);		
		}
		for(int k = 0; k < allListFoodOrderByRest.size(); k++){
			System.out.println("list all order: " +allListFoodOrderByRest.get(k).toString());
		}
		System.out.println("list size: " +allListFoodOrderByRest);
		
		return allListFoodOrderByRest;
	}
	
	@RequestMapping(value="success_order")
	public String successOrder(){
		return "success_order";
	}
	
	
	//admin load transaction by id_rest
	/*
	 * get id_rest by id_user.
	 */
	
	@RequestMapping(value="admin/transaction")
	public ModelAndView getTransactionByIdUserAndRest(HttpSession session){
		StringBuffer sb = new StringBuffer();
		ModelAndView mav = new ModelAndView("admin/tableTransaction");
		User user = (User) session.getAttribute("user_admin");
		int id_user = user.getUser_id();
		
		Restaurant rest = new Restaurant();
		rest = restService.getRestaurantByIdUser(id_user);
		if(rest==null){
			sb.append("\t restaurant not value");
		}else{
			sb.append("\t restraurant is value");
		}
		int id_rest = rest.getId_rest();
		
		//load transaction id_rest
		List<Trans> list_Trans = new ArrayList<>();
		list_Trans = transService.listTransByIdRest(id_rest);
		if(list_Trans.size() == 0){
			return new ModelAndView("redirect:/admin/error");
		}
		List<TransactionDto> list_TransDto = new ArrayList<>();
		for(int i = 0; i < list_Trans.size(); i++){
			TransactionDto trans_dto = new TransactionDto();
			trans_dto.setAddress(list_Trans.get(i).getAddress());
			trans_dto.setDate(list_Trans.get(i).getDate());
			trans_dto.setId_transaction(list_Trans.get(i).getId_transaction());
			trans_dto.setId_user(list_Trans.get(i).getId_user());
			trans_dto.setTran_stat(list_Trans.get(i).getTran_stat());
			logger.info("id_user: " + list_Trans.get(i).getId_user());
			User user_trans = userService.getUserById(Integer.parseInt(list_Trans.get(i).getId_user()));
//			logger.info("list transaction by id_rest: " + list_Trans.get(i).getId_transaction());
			trans_dto.setName_user(user_trans.getUsername());
			trans_dto.setPrice(list_Trans.get(i).getPrice());
			list_TransDto.add(trans_dto);
		}
		//1.1 list data with trans_stat = Hoan thanh
		List<TransactionDto> list_transaction_success = new ArrayList<>();
		List<TransactionDto> list_transaction_doing = new ArrayList<>();
		for(TransactionDto tran_dto: list_TransDto){
			if(tran_dto.getTran_stat().contains("Hoàn thành")){
				list_transaction_success.add(tran_dto);
			}else{
				list_transaction_doing.add(tran_dto);
			}
		}
//		logger.info("list transaction by id_rest: " + list_TransDto.get(0).getId_transaction());
		mav.addObject("LIST_TRANSACTION_SUCCESS", list_transaction_success);
		mav.addObject("LIST_TRANSACTION", list_transaction_doing);
		return mav;
	}
	
	@RequestMapping(value="admin/transaction/{id_transaction}")
	public ModelAndView listDetailTransaction(@PathVariable("id_transaction") int id_transaction, HttpSession session){
		ModelAndView mav = new ModelAndView("admin/transactionDetail");
		//get id_user by transaction_id
		Trans trans = transService.getTransById(id_transaction);
		String id_user = trans.getId_user();
		String id_receive = id_user + "C";
		session.setAttribute("id_receive", id_receive);
		mav.addObject("status_trans", trans.getTran_stat());
		//get address restaurant
		int id_rest = trans.getId_rest();
		Restaurant restaurant = restService.getRestaurantById(id_rest);
		mav.addObject("address_rest", restaurant.getAddres_rest());
		//get information user 
		User user_trans = userService.getUserById(Integer.parseInt(id_user));
		mav.addObject("user_trans", user_trans);
		mav.addObject("address_trans", trans.getAddress());
		//get bill pdf
		session.setAttribute("user_bill", user_trans);
		session.setAttribute("address_bill", trans.getAddress());
		session.setAttribute("price_bill", trans.getPrice());
		//List transaction detail
		List<Transaction_detail> list_transaction_detail = new ArrayList<>();
		List<TransactionDetailDto> list_transaction_detail_dto = new ArrayList<>();
		list_transaction_detail = transDetailService.listTransactionDetail(id_transaction);
		
		if(list_transaction_detail.size() > 0){
			sb.append("\t list transaction detail success" );
			for(int i = 0; i < list_transaction_detail.size(); i++){
				TransactionDetailDto transaction_detail_dto = new TransactionDetailDto();
				transaction_detail_dto.setId_food(list_transaction_detail.get(i).getId_food());
				transaction_detail_dto.setQuantum(list_transaction_detail.get(i).getQuantum());
				transaction_detail_dto.setTransaction_id(list_transaction_detail.get(i).getTransaction_id());
				Food food = foodService.getFoodById(list_transaction_detail.get(i).getId_food());
				transaction_detail_dto.setName_food(food.getName_food());
				transaction_detail_dto.setTrans_stat(list_transaction_detail.get(i).getTrans_stat());
				list_transaction_detail_dto.add(transaction_detail_dto);
			}
			session.setAttribute("trans_detail_bill", list_transaction_detail_dto);
			mav.addObject("LIST_TRANSACTION_DETAIL", list_transaction_detail_dto);
		}else{
			sb.append("\t list transaction detail fail");
		}
		
		//1.4 get data in table chat_progress
		List<MessageChat> listMess = chatMessService.listMessageChatById(trans.getId_transaction());
		java.util.Collections.sort(listMess, new CompareMessChat());
		mav.addObject("list_mess", listMess);
		logger.info("mess size: " + listMess.size());
		for(MessageChat mess: listMess){
			logger.info("mess: " + mess.toString());
		}
		return mav;
	}
	
	//update trans_stat in table transaction_detail
	@RequestMapping(value="admin/Transaction/updateTransactionDetail")
	@ResponseBody Map<String , Object> updateTran_Stat(@RequestParam("transaction_id") int transaction_id, @RequestParam("id_food") int id_food,
														@RequestParam("name_food") String name_food){
		//1.1 update trans_stat in table transaction_detail 
		transDetailService.updateTransactionByTransStat(transaction_id, id_food);
		//1.2 select transaction detail in table transaction_detail by transaction_id
		List<Transaction_detail> list = transDetailService.listTransactionDetail(transaction_id);
		//1.3 update notes in table progress 
		List<Progress> list_pro = progressService.listProgress(transaction_id);
		String note = "";
		for(Progress progress: list_pro){
			if(progress.getProgress().equals("progress-bar-info")){
				note = progress.getNotes();
			}
		}
		if(note == null){
			note = name_food + " Đang làm";
		}else{
			note +="</br>" + name_food + " Đang làm";
		}
		progressService.updateNoteProgress(transaction_id, null, note);
		logger.info("value note: " + note);
		//1.4 check trans_stat equals 1 if true update trans_stat in table transaction 
		int count_tran = 0;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getTrans_stat().equals("1")){
				count_tran += 1;
			}
		}
		if(count_tran == list.size()){
			transService.updateTrans(transaction_id, "Đang làm món ăn");
		}else{
			logger.info("chua update transaction");
		}
		return null;
	}
	
	// ham show progress cho customer
	@RequestMapping(value="/hoa-don")
	public ModelAndView orderDetailUser(HttpSession session){
		ModelAndView mav = new ModelAndView("order_detail");
		List<Trans> list_tran = new ArrayList<>();
		List<Trans> list_tran_success = new ArrayList<>();
		List<OrderDetailDto> list_trans_Dto = new ArrayList<>();
		List<OrderDetailDto> list_trans_Dto_success = new ArrayList<>();
		User user = (User) session.getAttribute("user");
		list_tran = transService.listTransByIdUser(user.getUser_id(), "Đặt hàng");
		list_tran_success = transService.listTransByIdUser(user.getUser_id(), "Hoàn thành");
		logger.info("list hoa don: " + list_tran.size());
		if(list_tran.size() == 0 && list_tran_success.size() == 0){
			return new ModelAndView("redirect:/error");
		}else{
			for(int i = 0 ; i < list_tran.size(); i++){
				OrderDetailDto order_dto = new OrderDetailDto();
				order_dto.setId_rest(list_tran.get(i).getId_rest());
				order_dto.setId_transaction(list_tran.get(i).getId_transaction());
				order_dto.setPrice(list_tran.get(i).getPrice());
				Restaurant rest = new Restaurant();
				rest = restService.getRestaurantById(list_tran.get(i).getId_rest());
				order_dto.setName_rest(rest.getName_rest());
				order_dto.setTran_stat(list_tran.get(i).getTran_stat());
	//			List<Progress> listProgress = progressService.listProgress(list_tran.get(i).getId_transaction());
	//			order_dto.setListProgress(listProgress);
				list_trans_Dto.add(order_dto);
			}
			for(int i = 0 ; i < list_tran_success.size(); i++){
				OrderDetailDto order_dto_success = new OrderDetailDto();
				order_dto_success.setId_rest(list_tran_success.get(i).getId_rest());
				order_dto_success.setId_transaction(list_tran_success.get(i).getId_transaction());
				order_dto_success.setPrice(list_tran_success.get(i).getPrice());
				Restaurant rest = new Restaurant();
				rest = restService.getRestaurantById(list_tran_success.get(i).getId_rest());
				order_dto_success.setName_rest(rest.getName_rest());
				order_dto_success.setTran_stat(list_tran_success.get(i).getTran_stat());
	//			List<Progress> listProgress = progressService.listProgress(list_tran.get(i).getId_transaction());
	//			order_dto.setListProgress(listProgress);
				list_trans_Dto_success.add(order_dto_success);
			}
		}
//		list_tran_success = transService.listTransByIdUser(user.getUser_id(), "Hoàn thành");
//		List<OrderDetailDto> list_trans_Dto_success = new ArrayList<>();
//		if(list_tran_success.size() == 0 && list_tran.size() == 0){
			//return new ModelAndView("redirect:/error");
//		}else{
			
//			for(int i = 0 ; i < list_tran_success.size(); i++){
//				OrderDetailDto order_dto_success = new OrderDetailDto();
//				order_dto_success.setId_rest(list_tran_success.get(i).getId_rest());
//				order_dto_success.setId_transaction(list_tran_success.get(i).getId_transaction());
//				order_dto_success.setPrice(list_tran_success.get(i).getPrice());
//				Restaurant rest = new Restaurant();
//				rest = restService.getRestaurantById(list_tran_success.get(i).getId_rest());
//				order_dto_success.setName_rest(rest.getName_rest());
//				order_dto_success.setTran_stat(list_tran_success.get(i).getTran_stat());
//	//			List<Progress> listProgress = progressService.listProgress(list_tran.get(i).getId_transaction());
//	//			order_dto.setListProgress(listProgress);
//				list_trans_Dto_success.add(order_dto_success);
//			}
//		}
		mav.addObject("LIST_TRANS", list_trans_Dto);
		mav.addObject("LIST_TRANS_SUCCESS", list_trans_Dto_success);
		return mav;
	}
	
	@RequestMapping(value="/hoa-don/{id_trans}")
	public ModelAndView OrderDetailId(@PathVariable("id_trans") int id, HttpSession session){
		ModelAndView mav = new ModelAndView("order_detail_id");
		//1.1 list data in table progress by id transaction
		List<Progress> listProgress = progressService.listProgress(id);
		logger.info(listProgress.size());
		for(int i = 0; i < listProgress.size(); i++ ){
			logger.info("test progress: " + listProgress.get(i).getName_progress());
		}
		mav.addObject("listprogress", listProgress);
		//1.2 list data transaction detail in table transaction by id transaction
		List<Transaction_detail> listTrans = transDetailService.listTransactionDetail(id);
		List<TransactionDetailDto> listTrans_Dto = new ArrayList<>();
		for(int i = 0; i < listTrans.size(); i++){
			TransactionDetailDto transDetDto = new TransactionDetailDto();
			transDetDto.setId_food(listTrans.get(i).getId_food());
			transDetDto.setQuantum(listTrans.get(i).getQuantum());
			transDetDto.setTransaction_id(listTrans.get(i).getTransaction_id());
			transDetDto.setPrice_food(listTrans.get(i).getPrice_food());
			Food f = foodService.getFoodById(listTrans.get(i).getId_food());
			transDetDto.setName_food(f.getName_food());
			listTrans_Dto.add(transDetDto);
		}
		mav.addObject("listtrans", listTrans_Dto);
		//1.3 list data in table transaction by id transaction
		Trans trans = transService.getTransById(id);
		mav.addObject("transaction", trans);
		//1.4 get data in table restaurant by id restaurant
		Restaurant rest = restService.getRestaurantById(trans.getId_rest());
		mav.addObject("restaurant", rest);
		
		//1.5 get data information restaurant send message chat in websocket 
		//   1.5.1 get information id_user_rest
		StringBuffer information_rest = new StringBuffer();
		information_rest.append(rest.getId_rest() + ";" + rest.getName_rest() + ";");
		mav.addObject("information_rest", information_rest);
		// 1.5.2 get information id_user_send (user connecting)
		StringBuffer information_user = new StringBuffer();
		User user = (User) session.getAttribute("user");
		information_user.append(user.getUser_id() + ";" + user.getUsername() + ";");
		mav.addObject("information_user", information_user);
		
		//1.6 get data chat message in table chat_progress
		List<MessageChat> listMess = chatMessService.listMessageChatById(trans.getId_transaction());
		java.util.Collections.sort(listMess, new CompareMessChat());
		mav.addObject("list_mess", listMess);
		return mav;
	}
	
	@RequestMapping(value="saveProgress")
	@ResponseBody Map<String , Object> saveProgress(@RequestParam("data") String json){
		logger.info(json);
		Gson gson = new Gson();
		Progress progress = gson.fromJson(	json, Progress.class);
		logger.info(progress.toString());
		try {
//			String date = progress.getTime();
//			logger.info(date);
//			String[] array = new String[3];
//			array = date.split(" ");
//			Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(array[0]);
//			logger.info("date1: " + date1);
//			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
//			String data1 = DATE_FORMAT.format(date)
			String progress_name = "progress-bar-warning";
			String progress_name_info = "progress-bar-info";
			if((progress.getProgress().trim()).equals(progress_name_info.trim())){
				logger.info("vao day roi");
				progressService.insertProgress(progress);
				transService.updateTrans(progress.getId_progress(), progress.getName_progress());
			}else if((progress.getProgress().trim()).equals(progress_name.trim())){
				String time_info = progressService.timeProgress(progress.getId_progress());
				logger.info(time_info);
				BigInteger count_time  = progressService.countTimeProgress(time_info, progress.getTime());
				logger.info("count time: " + count_time);
				Trans trans = transService.getTransById(progress.getId_progress());
				progress.setId_rest(trans.getId_rest());
				progress.setTime_space(count_time);
				progressService.insertProgress(progress);
				transService.updateTrans(progress.getId_progress(), progress.getName_progress());
			}else{
				logger.info("loi o day roai");
				progressService.insertProgress(progress);
				transService.updateTrans(progress.getId_progress(), progress.getName_progress());
			}
//			progressService.insertProgress(progress);
//			transService.updateTrans(progress.getId_progress(), progress.getName_progress());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception insert Progress");
		}
		return null;	}
	
	@RequestMapping(value="admin/cancelBill")
	@ResponseBody Map<String, Object> cancelBill(@RequestParam("data") int data){
		Map<String, Object> map = new HashMap<>();
		transService.updateTrans(data, "Hủy đơn");
		return map;
	}

	@RequestMapping(value="admin/exportBill")
	public ModelAndView getPdfBill(HttpSession session){
		ModelAndView mav = new ModelAndView("viewPdf");
		mav.addObject("user_bill", session.getAttribute("user_bill"));	
		mav.addObject("address_bill", session.getAttribute("address_bill"));
		mav.addObject("trans_detail_bill", session.getAttribute("trans_detail_bill"));
		mav.addObject("price_bill", session.getAttribute("price_bill"));
//		List<Transaction_detail> list = (List<Transaction_detail>) session.getAttribute("list_excel");
		ExportExcelDashBoard exportExcelDashBoard = new ExportExcelDashBoard();
		return mav;
	}
	
	
	public void SendEmailTo(String mailTo, List<Food_Order_Dto> list, int transaction_id, String price){
//		private String emailToRecipient, emailSubject, emailMessage;
//		private String emailFromRecipient = "dinhthangms96@gmail.com";
		StringBuffer sb =new StringBuffer();
		for(int i = 0; i < list.size(); i++){
			sb.append(list.get(i).getName_food() + "\nsố lượng: " + list.get(i).getCount_food());
		}
		sb.append("\t Tổng tiền: " + price);
		emailToRecipient = mailTo;
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("dinhthangms96@gmail.com");
		message.setTo(mailTo);
		message.setSubject("Đơn hàng mới - Mã đơn hàng: " + transaction_id);
		message.setText("Bạn có đơn hàng mới \n"
						+ sb.toString());
		mailSenderObj.send(message);
		
	}
}


