package project.thangnd.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.thangnd.daos.ProgressDao;
import project.thangnd.dtos.Food_Dto;
import project.thangnd.dtos.Food_Order_Dto;
import project.thangnd.models.Food;
import project.thangnd.services.FoodService;

@Controller
public class OrderController {
	Logger logger = Logger.getLogger(OrderController.class);
	
	boolean checkFood = false;
	@Autowired
	private FoodService foodService;
	
	

	@RequestMapping(value="nha-hang/order")
	@ResponseBody Map<String, Object> orderFood(@RequestParam(name = "id_food_order", required=false) String id_food
			, HttpServletResponse response, HttpSession session){
		StringBuffer sb = new StringBuffer();
		sb.append("OrderController #orderFood");
		 Map<String, Object> map = new HashMap<>();
		 Food_Order_Dto food_dto = new Food_Order_Dto();
		 List<Food_Order_Dto> list_food = (List<Food_Order_Dto>) session.getAttribute("order");
		 if(list_food == null){
			 list_food = new ArrayList<>();
		 }
		 
		 Food food = new Food();
		 try {
			food = foodService.getFoodById(Integer.parseInt(id_food));
			if(food != null){
				food_dto.toFood(food);
				int result = addToCart(list_food, food_dto);
				session.setAttribute("order", list_food);
				sb.append("\t size list food: " + list_food.size());
			}
			map.put("data", session.getAttribute("order"));
//			System.out.println(sb);
			logger.info(sb);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}
	
	@RequestMapping(value="order-update")
	@ResponseBody Map<String, Object> updateOrder(@RequestParam("id_food") String id_food, HttpSession session){
		Map<String, Object> map = new HashMap<>();
		List<Food_Order_Dto> list =  (List<Food_Order_Dto>) session.getAttribute("order");
		updateOrder(list, Integer.parseInt(id_food));
		session.setAttribute("order", list);
		map.put("data1", session.getAttribute("order"));
		logger.info("order-update : " + list.size() + "count_food: " + list.get(0).getCount_food());
		return map;
		
	}
	
	@RequestMapping(value="order-update-sub")
	@ResponseBody Map<String, Object> updateOrderSub(@RequestParam("id_food") String id_food, HttpSession session){
		Map<String, Object> map = new HashMap<>();
		List<Food_Order_Dto> list = (List<Food_Order_Dto>) session.getAttribute("order");
		updateOrderSub(list, Integer.parseInt(id_food));
		session.setAttribute("order", list);
		map.put("data1", session.getAttribute("order"));
		logger.info("count_food: " + list.size());
		return map;
	}
	
	@RequestMapping(value="nha-hang/load-order")
	@ResponseBody Map<String, Object> loadOrder(HttpSession session){
		Map<String, Object> map = new HashMap<>();
		map.put("data", session.getAttribute("order"));
		return map;
	}

	
	
	
	public int addToCart(List<Food_Order_Dto> list, Food_Order_Dto food){
		boolean isExit = false;
		for(Food_Order_Dto f : list){
			if(f.getId_food() == (food.getId_food())){
				System.out.println("f: " + f.toString());
				System.out.println("food: " + food.toString());
				f.setCount_food(f.getCount_food() + 1);
				isExit = true;
			}
			
			
		}
		if(isExit == false){
			list.add(food);
		}
		return 1;
	}
	
	public void updateOrder(List<Food_Order_Dto> list, int id_food){
		for(Food_Order_Dto f: list){
//			int count = f.getCount_food();
			if(f.getId_food() == id_food){
				f.setCount_food(f.getCount_food() + 1);
			}
		}
	}
	public void updateOrderSub(List<Food_Order_Dto> list, int id_food){
		Food_Order_Dto temp = null;
		for(Food_Order_Dto f : list){
			if(f.getId_food() == id_food){
				if(f.getCount_food() == 1){
//					f.setCount_food(1);
					temp = f;
					continue;
				}else if(f.getCount_food() > 1 ){
					f.setCount_food(f.getCount_food() - 1);
				}
				
			}
			
		}
		if(temp != null){
			list.remove(temp);
		}
	}

}
