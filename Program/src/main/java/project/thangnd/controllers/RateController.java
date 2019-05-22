package project.thangnd.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.thangnd.models.Rate;
import project.thangnd.models.User;
import project.thangnd.services.RateService;

@Controller
public class RateController {

	Logger logger = Logger.getLogger(RateController.class);
	@Autowired
	private RateService rateService;
	
	@RequestMapping(value="insertrate")
	@ResponseBody Map<String, Object> insertRate(@RequestParam("count_rate") String count_rate ,
												@RequestParam("id_rest_rate") String id_rest,
												HttpSession session){
		Map<String, Object> map = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append("RateController #insertrate ");
		sb.append("\t count_rate: " + count_rate + "id_food: " + id_rest);
		User user = (User) session.getAttribute("user");
		Rate rate = rateService.getRateByIdRestUser(Integer.parseInt(id_rest), user.getUser_id());
		System.out.println(count_rate);
		if(rate == null){
			sb.append("\t rate not is value ");
			System.out.println("insert value rate in data table rate");
			Rate rate_ins = new Rate();
			rate_ins.setCount_rate(Integer.parseInt(count_rate));
			rate_ins.setId_rest(Integer.parseInt(id_rest));;
			rate_ins.setId_user(user.getUser_id());
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			rate_ins.setDate(format.format(date));
			rate_ins.setStatus_rate("I"); // setStatus luon luon la I, khi nao update thi chuyen thanh C
			sb.append("rate value: " + rate_ins.toString());
			rateService.insertRate(rate_ins);
		}else{
			System.out.println("update value rate in datatable rate");
			rateService.updateRateByIdRestUser(Integer.parseInt(id_rest), user.getUser_id());
			Rate rate1 = new Rate();
			rate1.setCount_rate(Integer.parseInt(count_rate));
			rate1.setId_rest(Integer.parseInt(id_rest));
			rate1.setId_user(user.getUser_id());
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			rate1.setDate(format.format(date));
			rate1.setStatus_rate("I");
			sb.append("Update rate to table rate");
			rateService.insertRate(rate1);
			sb.append(rate1.toString());
		}
		

		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error exception");
		}
//		System.out.println(sb);
		logger.info(sb);
		return map;
	}
	
//	@RequestMapping(value="vote-rate")
//	public ModelAndView voteRate(){
//		ModelAndView mav = new ModelAndView("restaurant_detail");
//		int 
//		return mav;
//	}
}
