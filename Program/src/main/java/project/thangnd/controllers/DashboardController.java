package project.thangnd.controllers;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Array;

import project.thangnd.dtos.TransactionDetailDto;
import project.thangnd.models.Food;
import project.thangnd.models.Restaurant;
import project.thangnd.models.Transaction_detail;
import project.thangnd.models.User;
import project.thangnd.services.FoodService;
import project.thangnd.services.RestaurantService;
import project.thangnd.services.TransactionService;
import project.thangnd.utils.ExportExcelDashBoard;

@Controller
public class DashboardController {

	Logger logger = Logger.getLogger(DashboardController.class);
	@Autowired 
	private TransactionService transService;
	
	@Autowired
	private RestaurantService restService;
	
	@Autowired 
	private FoodService foodService;
	
	@RequestMapping(value = "/admin/dashboard")
	public ModelAndView dashBoard(HttpSession session){
		ModelAndView mav = new ModelAndView("admin/dashboard");
		User user = (User) session.getAttribute("user_admin");
		Restaurant rest = restService.getRestaurantByIdUser(user.getUser_id());
		//sum price in table transaction
		Double price_total = transService.sumPriceTrans(rest.getId_rest());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String date_ = dateFormat.format(date);
		//sum price in table transaction by date 
		Double price_total_by_date = transService.sumPriceTransByDate(date_, rest.getId_rest());
		//count transaction by date in table transaction
		
		BigInteger countTransDate = transService.countTransactionByDate(date_, rest.getId_rest());
		//count transaction in gable transaction
		BigInteger countTrans = transService.countTransaction(rest.getId_rest());
		mav.addObject("count_trans", countTrans);
		mav.addObject("count_trans_date", countTransDate);
		mav.addObject("price_trans", price_total);
		mav.addObject("sum_trans_date", price_total_by_date);
		return mav;
	}
	
	@RequestMapping(value = "/admin/dashboardByDate")
	public ModelAndView DashBoardByDate(@RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date, HttpSession session){
		ModelAndView mav = new ModelAndView("admin/dashboard");
		System.out.println("thangnd date start: " + start_date);
		String start_date_convert = start_date.replace("-", "/") + " 00:00:00";
		String end_date_convert = end_date.replace("-", "/") + " 23:59:59";		
		User user = (User) session.getAttribute("user_admin");
		Restaurant rest = restService.getRestaurantByIdUser(user.getUser_id());
		//sum price in table transaction
		Double price_total = transService.sumPriceTrans(rest.getId_rest());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String date_ = dateFormat.format(date);
		//sum price in table transaction by date 
		Double price_total_by_date = transService.sumPriceTransByDate(date_, rest.getId_rest());
		//count transaction by date in table transaction
		
		BigInteger countTransDate = transService.countTransactionByDate(date_, rest.getId_rest());
		//count transaction in gable transaction
		BigInteger countTrans = transService.countTransaction(rest.getId_rest());
		mav.addObject("count_trans", countTrans);
		mav.addObject("count_trans_date", countTransDate);
		mav.addObject("price_trans", price_total);
		mav.addObject("sum_trans_date", price_total_by_date);
		List<Transaction_detail> list_trans = transService.listTrans(start_date_convert, end_date_convert, rest.getId_rest());
		session.setAttribute("list_excel", list_trans);
		List<TransactionDetailDto> list_trans_dto = new ArrayList<>();
		for(int i = 0; i < list_trans.size(); i++){
			TransactionDetailDto trans_dto = new TransactionDetailDto();
			trans_dto.setId_food(list_trans.get(i).getId_food());
			Food f = foodService.getFoodById(list_trans.get(i).getId_food());
			trans_dto.setName_food(f.getName_food());
			trans_dto.setQuantum(list_trans.get(i).getQuantum());
			list_trans_dto.add(trans_dto);
		}
		session.setAttribute("list_excel", list_trans_dto);
		mav.addObject("list_trans_1", list_trans_dto);
		System.out.println("thangnd: " + list_trans.size() );
//		return new ModelAndView("redirect:/admin/dashboard");
		return mav;
	}
	
	@RequestMapping(value="admin/exportExcel")
	public ModelAndView getExcel(HttpSession session){
		List<Transaction_detail> list = (List<Transaction_detail>) session.getAttribute("list_excel");
		ExportExcelDashBoard exportExcelDashBoard = new ExportExcelDashBoard();
		return new ModelAndView("viewExcels", "list_trans", list);
	}

}
