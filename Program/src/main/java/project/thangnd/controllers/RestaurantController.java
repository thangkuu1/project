package project.thangnd.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import project.thangnd.dtos.Food_Dto;
import project.thangnd.dtos.Food_Order_Dto;
import project.thangnd.dtos.RestaurantDto;
import project.thangnd.dtos.Restaurant_Info;
import project.thangnd.models.Discount_Food;
import project.thangnd.models.Food;
import project.thangnd.models.Price_Change;
import project.thangnd.models.Rate;
import project.thangnd.models.Restaurant;
import project.thangnd.models.User;
import project.thangnd.services.CommentService;
import project.thangnd.services.Discount_FoodService;
import project.thangnd.services.FoodService;
import project.thangnd.services.Price_ChangeService;
import project.thangnd.services.ProgressService;
import project.thangnd.services.RateService;
import project.thangnd.services.RestaurantService;
import project.thangnd.utils.CompareRestByRate;
import project.thangnd.utils.UpLoad;

@Controller
public class RestaurantController {

	Logger logger = Logger.getLogger(Restaurant.class);
	
	private FoodController foodController = new FoodController();
	UpLoad upload = new UpLoad();
	@Autowired 
	private RestaurantService restService;
	
	@Autowired
	private Discount_FoodService discount_Food_Service;
	
	@Autowired 
	private FoodService foodService;
	
	@Autowired
	private Price_ChangeService price_change_Serivice;
	
	@Autowired
	private RateService rateService;
	
	@Autowired
	private CommentService cmtService;
	
	@Autowired
	private Discount_FoodService dis_foodService;
	
	@Autowired
	private ProgressService progressService;
	
	@RequestMapping(value="load-restaurant")
	public ModelAndView loadRestaurant(){
		
		return new ModelAndView("admin/formRestaurant", "command", new Restaurant());
	}
	
	@RequestMapping(value="trang-chu.html")
	public ModelAndView listRestaurant(){
		ModelAndView mav = new ModelAndView("trangchu");
		List<Restaurant> LIST_RESTAURANT = new ArrayList<>();
		LIST_RESTAURANT = restService.listRestaurant();
		//1.1 set value restaurant to restaurant_info
		List<Restaurant_Info> list_restaurant_info = new ArrayList<>();
		for(int i = 0; i < LIST_RESTAURANT.size(); i++){
			Restaurant_Info rest_info = new Restaurant_Info();
			rest_info.setId_rest(LIST_RESTAURANT.get(i).getId_rest());
			rest_info.setAddress_rest(LIST_RESTAURANT.get(i).getAddres_rest());
			rest_info.setName_rest(LIST_RESTAURANT.get(i).getName_rest());
			rest_info.setImage_rest(LIST_RESTAURANT.get(i).getImage_rest());
			rest_info.setKind_rest(LIST_RESTAURANT.get(i).getKind_rest());
			//1.1.0 set key discount in restaurant
			Double sum = dis_foodService.sumDiscount(LIST_RESTAURANT.get(i).getId_rest());
			List<BigInteger> listTime = progressService.listTimeSpaceById_rest(LIST_RESTAURANT.get(i).getId_rest());
			BigInteger countTime = new BigInteger("0");
			
			
			int avg_sum_time = 0;
			int sumTime = 0;
			if(listTime== null){
				logger.info("voa dau");
				rest_info.setTime_space(0);
				
			}else{
				
				for(int m = 0; m < listTime.size(); m++){
					sumTime += listTime.get(m).intValue();
					logger.info("list time: " +listTime.get(m).toString());
				}
				int sumtime = countTime.intValue();
				avg_sum_time = sumTime/(listTime.size());
				logger.info("time count sss: " + avg_sum_time);
				rest_info.setTime_space(avg_sum_time);
			}
			
			
			logger.info("sum value: " + sum);
			rest_info.setSum_discount(sum);
			//1.1.1 count rate in each restaurant
			List<Rate> list_rate_one = rateService.countRateByRate(1, LIST_RESTAURANT.get(i).getId_rest());
			List<Rate> list_rate_two = rateService.countRateByRate(2, LIST_RESTAURANT.get(i).getId_rest());
			List<Rate> list_rate_three = rateService.countRateByRate(3,LIST_RESTAURANT.get(i).getId_rest());
			List<Rate> list_rate_four = rateService.countRateByRate(4, LIST_RESTAURANT.get(i).getId_rest());
			List<Rate> list_rate_five = rateService.countRateByRate(5, LIST_RESTAURANT.get(i).getId_rest());
			float total = list_rate_one.size() + list_rate_two.size() + list_rate_three.size() + list_rate_four.size() + list_rate_five.size();
			logger.info("total rate: " + total);
			
			int rate_avg = (int)((list_rate_one.size())*1 + (list_rate_two.size())*2 + (list_rate_three.size())*3 + (list_rate_four.size())*4 + (list_rate_five.size())*5) / 5;
			rest_info.setRate_rest(rate_avg);
			//1.1.2 get count comment in each restaurant
			BigInteger count = cmtService.countComment(LIST_RESTAURANT.get(i).getId_rest());
			rest_info.setCount_cmt(count);
			list_restaurant_info.add(rest_info);
		}
		List<Restaurant_Info> list_restaurant_top = new ArrayList<>();
		for(int i = 0 ; i < 8; i++){
			list_restaurant_top.add(list_restaurant_info.get(i));
		}
		mav.addObject("LIST_RESTAURANT", list_restaurant_top);
		
		//1.2 sort restaurant by rate
		List<Restaurant_Info> list_restaurant_info_rate = new ArrayList<>();
		for(int i = 0; i < list_restaurant_info.size(); i++){
			Restaurant_Info rest_info = new Restaurant_Info();
			rest_info.setId_rest(list_restaurant_info.get(i).getId_rest());
			rest_info.setAddress_rest(list_restaurant_info.get(i).getAddress_rest());
			rest_info.setName_rest(list_restaurant_info.get(i).getName_rest());
			rest_info.setImage_rest(list_restaurant_info.get(i).getImage_rest());
			rest_info.setRate_rest(list_restaurant_info.get(i).getRate_rest());
			rest_info.setCount_cmt(list_restaurant_info.get(i).getCount_cmt());
			rest_info.setSum_discount(list_restaurant_info.get(i).getSum_discount());
			list_restaurant_info_rate.add(rest_info);
		}
		// =  list_restaurant_info;
		java.util.Collections.sort(list_restaurant_info_rate, new CompareRestByRate());
		mav.addObject("list_rest_by_rate", list_restaurant_info_rate);
		//1.3 list restaurant by kind restaurant
		List<Restaurant_Info> list_restaurant_by_drink = new ArrayList<>();
		List<Restaurant_Info> list_restaurant_by_food = new ArrayList<>();
		List<Restaurant_Info> list_restaurant_by_snacks = new ArrayList<>();
		List<Restaurant_Info> list_restaurant_by_discount = new ArrayList<>();
		List<Restaurant_Info> list_restaurant_by_time_ten = new ArrayList<>();
		List<Restaurant_Info> list_restaurant_by_time_ten_twenty = new ArrayList<>();
		List<Restaurant_Info> list_restaurant_by_time_twenty_thirty = new ArrayList<>();
		List<Restaurant_Info> list_restaurant_by_time_thirty_large = new ArrayList<>();
		for(Restaurant_Info rest_info: list_restaurant_info){
			if(rest_info.getKind_rest().contains("Trà Sữa" )){
				list_restaurant_by_drink.add(rest_info);
			}
			if(rest_info.getKind_rest().contains("Cơm") || rest_info.getKind_rest().contains("Gà")){
				list_restaurant_by_food.add(rest_info);
			}
			if(rest_info.getKind_rest().contains("Ăn vặt")){
				list_restaurant_by_snacks.add(rest_info);
				//logger.info("discount show: " +rest_info.getSum_discount());
			}
			if(rest_info.getTime_space() > 0 && rest_info.getTime_space() < 10){
				list_restaurant_by_time_ten.add(rest_info);
				logger.info("list restaurant 10: " + list_restaurant_by_time_ten.size());
				logger.info("restaurant ten: " + list_restaurant_by_time_ten.get(0).toString());
			}
			if(rest_info.getTime_space() > 10 && rest_info.getTime_space() < 20){
				list_restaurant_by_time_ten_twenty.add(rest_info);
				logger.info("list restaurant 20: " + list_restaurant_by_time_ten_twenty.size());
				logger.info("restaurant ten: " + list_restaurant_by_time_ten_twenty.get(0).toString());
			}
			if(rest_info.getTime_space() > 20 && rest_info.getTime_space() < 30){
				list_restaurant_by_time_twenty_thirty.add(rest_info);
				logger.info("list restaurant 30: " + list_restaurant_by_time_twenty_thirty.size());
				logger.info("restaurant ten: " + list_restaurant_by_time_twenty_thirty.get(0).toString());
			}
			if(rest_info.getTime_space() > 30){
				list_restaurant_by_time_thirty_large.add(rest_info);
				logger.info("list restaurant 40: " + list_restaurant_by_time_thirty_large.size());
				logger.info("restaurant ten: " + list_restaurant_by_time_thirty_large.get(0).toString());
			}
			
			
			//logger.info("discount show: " +Double.compare(rest_info.getSum_discount(), 0.0));
			/*if(Double.compare(rest_info.getSum_discount(), 0.0) > 0){
				list_restaurant_by_discount.add(rest_info);
			}*/
		}
		mav.addObject("list_restaurant_by_drink", list_restaurant_by_drink);
		mav.addObject("list_restaurant_by_food", list_restaurant_by_food);
		mav.addObject("list_restaurant_by_snacks", list_restaurant_by_snacks);
		mav.addObject("list_restaurant_by_discount", list_restaurant_by_discount);
		mav.addObject("list_restaurant_by_time_ten", list_restaurant_by_time_ten);
		mav.addObject("list_restaurant_by_time_ten_twenty", list_restaurant_by_time_ten_twenty);
		mav.addObject("list_restaurant_by_time_twenty_thirty", list_restaurant_by_time_twenty_thirty);
		mav.addObject("list_restaurant_by_time_thirty_large", list_restaurant_by_time_thirty_large);
		return mav;
	}
	
	@RequestMapping(value="nha-hang/{id}")
	public ModelAndView detailRestaurant(@PathVariable("id") String id_rest, HttpSession session){
		StringBuffer sb = new StringBuffer();
		sb.append("RestaurantController #detailRestaurant");
		ModelAndView mav = new ModelAndView("restaurant_detail");
		//session.setAttribute("order", null);
		User user = (User) session.getAttribute("user");
		if(user == null){
			mav = new ModelAndView("redirect:/check-login");
			sb.append("\t check login loading");
		}else{
			Restaurant rest = new Restaurant();
			rest = restService.getRestaurantById(Integer.parseInt(id_rest));
			if(rest == null){
				sb.append("\t Restaurant is not value");
			}else{
				// if load page diffirent -> remove session order
//				List<Food_Order_Dto> list = (List<Food_Order_Dto>) session.getAttribute("order");
//				if(list.size() == 0){
//					logger.info("list order failed");
//				}
//				logger.info("list order: " + list.size());
//				int id_food = list.get(0).getId_food();
//				Food f = foodService.getFoodById(id_food);
//				if(list.size() > 0 && (Integer.parseInt(id_rest) != f.getId_food())){
//						session.removeAttribute("order");
//				}
				RestaurantDto restDto = new RestaurantDto();
				restDto = getRestaurantDto(Integer.parseInt(id_rest));
				sb.append("\t " + restDto);
				mav.addObject("restaurant", restDto);
				List<Food> LIST_FOOD = new ArrayList<>();
				LIST_FOOD = listFoodByIdRest(Integer.parseInt(id_rest));
				if(LIST_FOOD.size() < 1){
					sb.append("\t LIST_FOOD is not value");
				}else{
					sb.append("\t LIST_FOOD is value");
					mav.addObject("LIST_FOOD", LIST_FOOD);
				}
				
				// list rate by count rate 
				
				List<Rate> list_rate_one = rateService.countRateByRate(1, Integer.parseInt(id_rest));
				List<Rate> list_rate_two = rateService.countRateByRate(2, Integer.parseInt(id_rest));
				List<Rate> list_rate_three = rateService.countRateByRate(3, Integer.parseInt(id_rest));
				List<Rate> list_rate_four = rateService.countRateByRate(4, Integer.parseInt(id_rest));
				List<Rate> list_rate_five = rateService.countRateByRate(5, Integer.parseInt(id_rest));
				float total = list_rate_one.size() + list_rate_two.size() + list_rate_three.size() + list_rate_four.size() + list_rate_five.size();
				logger.info("total rate: " + total);
				float per_rate_one = (float)((list_rate_one.size())/total)*100;
				float per_rate_two = (float)((list_rate_two.size())/total)*100;
				float per_rate_three =(float)((list_rate_three.size())/total)*100;
				float per_rate_four = (float)((list_rate_four.size())/total)*100;
				float per_rate_five = (float)((list_rate_five.size())/total)*100;
				float rate_avg = (float)((list_rate_one.size())*1 + (list_rate_two.size())*2 + (list_rate_three.size())*3 + (list_rate_four.size())*4 + (list_rate_five.size())*5) / 5;
				mav.addObject("per_rate_one",  per_rate_one);
				mav.addObject("per_rate_two", per_rate_two );
				mav.addObject("per_rate_three",  per_rate_three);
				mav.addObject("per_rate_four",  per_rate_four);
				mav.addObject("per_rate_five", per_rate_five );
				mav.addObject("rate_avg", rate_avg);
				logger.info("test loi nay: " + per_rate_four);
				logger.info("test loi nay: " + per_rate_three);
				//1.3 count comment restaurant
				BigInteger count = cmtService.countComment(Integer.parseInt(id_rest));
				mav.addObject("count_cmt", count);
			}
		}
		
		System.out.println(sb);
		logger.info(sb);
		return mav;
	}
	
	@RequestMapping(value="admin/restaurant/edit")
	public ModelAndView EditRestaurant( HttpSession session){
		User user = (User) session.getAttribute("user_admin");
		Restaurant rest = restService.getRestaurantByIdUser(user.getUser_id());
		session.setAttribute("image_rest", rest.getImage_rest());
		
		
		return new ModelAndView("admin/formEditRestaurant", "command", rest);
	}

	
	@RequestMapping(value="admin/restaurant/saveRestaurant")
	public ModelAndView saveRestaurantEdit(@ModelAttribute("restaurant") Restaurant restaurant){
		restService.updateRestaurant(restaurant);
		return new ModelAndView("redirect:/admin/restaurant/list");
	}
	
	@RequestMapping(value="admin/restaurant/list")
	public ModelAndView listRestaurantAd(HttpSession session){
		ModelAndView mav = new ModelAndView("admin/inforRestaurant");
		User user = (User) session.getAttribute("user_admin");
		Restaurant rest = restService.getRestaurantByIdUser(user.getUser_id());
		mav.addObject("restaurant", rest);
		return mav;
	}
	
	@RequestMapping(value="admin/save-restaurant")
	public ModelAndView saveRestaurant(@ModelAttribute("restaurant") Restaurant rest,
										@RequestParam("file") MultipartFile file,
										@RequestParam("time_open") String time_open,
										@RequestParam("time_close") String time_close,
										@RequestParam("cost_max") String cost_max ,
										@RequestParam("cost_min") String cost_min,
										HttpSession session){
		StringBuffer sb = new StringBuffer();
		sb.append("RestaurentController #saveRestaurant ");
		String namefile = upload.uploadFile(file);
		rest.setImage_rest(namefile);
		String time = time_open + " : " + time_close;
		rest.setTime_open(time);
		rest.setStatus_rest("I");
		String cost_rest = cost_min + " - " + cost_max;
		rest.setCost_rest(cost_rest);
		User user = (User) session.getAttribute("user_admin");
		if(user == null){
			sb.append("\t user insert restaurant null ");
			
		}else{
			rest.setId_user(user.getUser_id());
		}
		try {
			sb.append("\t restaurant value: " + rest.toString());
			int result = restService.insertRestaurant(rest);
			if(result == 0){
				sb.append("\t insert Restaurant error " );
			}else{
				sb.append("\t insert Restaurant success " );
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("RestaurantController #saveRestaurant error");
		}
		System.out.println(sb);
		return new ModelAndView("redirect:/admin/food");
	}
	
	public List<Food_Dto> listFood_DtoByIdRest(int id_rest){
		List<Food_Dto> list_dto_food = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		try {
			List<Food> list_Food = new ArrayList<>();
			list_Food = foodService.listFoodByIdRest(id_rest);
			if(list_Food.size() < 1){
				sb.append("no list food ");
			}else{
				for(int i = 0; i < list_Food.size(); i++){
					Food_Dto food_Dto = new Food_Dto();
					food_Dto.setId_food(list_Food.get(i).getId_food());
					food_Dto.setId_discount(list_Food.get(i).getId_discount());
					food_Dto.setId_price(list_Food.get(i).getId_price());
					food_Dto.setId_user(list_Food.get(i).getId_user());
					food_Dto.setName_food(list_Food.get(i).getName_food());
					food_Dto.setImage_food(list_Food.get(i).getImage_food());
					Discount_Food discount = new Discount_Food();
					//mai phai fix loi nay, set Price in id_user, id_food
					discount = discount_Food_Service.getDiscountFoodByUserAndFood(Integer.parseInt(food_Dto.getId_user()), food_Dto.getId_food());
					if(discount != null){
						food_Dto.setDiscount_per(discount.getPer_discount());
					}else{
						System.out.println("discount food not value");
					}

					Price_Change price = new Price_Change();
					price = price_change_Serivice.getPriceChangeByUserAndFood(Integer.parseInt(food_Dto.getId_user()), food_Dto.getId_food());
					if(price != null){
						food_Dto.setPrice(price.getPrice_new());
					}else{
						System.out.println("price not value");
					}
					System.out.println(food_Dto.toString());
					list_dto_food.add(food_Dto);
					System.out.println("thangnd +++++  per Discount: " + food_Dto.getDiscount_per());
				}
				System.out.println("LIST_DTO_FOOD: " + list_dto_food.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
			list_dto_food = null;
			System.out.println("FoodController #listFood_Dto error");
		}
		return list_dto_food;
		
	}
	
	
	public RestaurantDto getRestaurantDto(int id_rest){
		Restaurant rest = new Restaurant();
		rest = restService.getRestaurantById(id_rest);
		RestaurantDto restDto = new RestaurantDto();
		if(rest == null){
//			sb.append("\t Restaurant is not value");
			System.out.println("\t Restaurant is not value");
		}else{
			restDto.setName_rest(rest.getName_rest());
			restDto.setId_rest(rest.getId_rest());
			restDto.setAddres_rest(rest.getAddres_rest());
			restDto.setId_user(rest.getId_user());
			restDto.setImage_rest(rest.getImage_rest());
			String cost_rest = rest.getCost_rest();
			String[] cost = cost_rest.split("-");
			String cost_max = cost[1];
			String cost_min = cost[0];
			restDto.setCost_max(cost_max);
			restDto.setCost_min(cost_min);
			restDto.setTime_open(rest.getTime_open());
//			String
		}
		return restDto;
	}
	
	public List<Food> listFoodByIdRest(int id_rest){
		List<Food> listFood =  new ArrayList<>();
		try {
			listFood = foodService.listFoodByIdRest(id_rest);
			if(listFood.size() <  1){
				System.out.println("List food in restaurantController failed");
			}else{
				System.out.println("List food in restaurantController success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("restaurantController #listFoodByIdRest error");
			listFood = null;
		}
		return listFood; 
	}
	
}
