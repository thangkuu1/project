package project.thangnd.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
//import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import project.thangnd.services.Discount_FoodService;
import project.thangnd.services.FoodService;
import project.thangnd.services.Price_ChangeService;
import project.thangnd.services.RestaurantService;
import project.thangnd.utils.UpLoad;
import project.thangnd.dtos.Food_Dto;
import project.thangnd.models.Discount_Food;
import project.thangnd.models.Food;
import project.thangnd.models.Price_Change;
import project.thangnd.models.Restaurant;
import project.thangnd.models.User;

@Controller
public class FoodController {
	Logger logger = Logger.getLogger(FoodController.class);
//	LoadFood loadFood = new LoadFood();
	String price_id; // gia tri price_id
	String id_discount; // gia tri id_discount
	List<Food_Dto> LIST_DTO_FOOD = new ArrayList<>();
	List<Food_Dto> LIST_DTO_FOOD_BY_ID = new ArrayList<>();
	@Autowired
	private FoodService foodService;
	@Autowired
	private Discount_FoodService discount_Food_Service;
	@Autowired
	private Price_ChangeService price_change_Serivice;
	
	@Autowired
	private RestaurantService restaurantService;
	private UpLoad upload = new UpLoad();
	
	//code customer
//	@RequestMapping(value="trangchu")
//	public ModelAndView loadAllFood(){
//		    List<Food_Dto> LIST_FOOD = new ArrayList<>();
//		    LIST_FOOD = listFood_Dto();
//		return new ModelAndView("trangchu", "LIST_FOOD", LIST_FOOD);
//	}
//	thangnd comment temp because code update
	//load information food
	@RequestMapping(value="detail-load-food")
	@ResponseBody Map<String, Object> detailLoadFood(){
		Map<String, Object> map = new HashMap<>();
		List<Food_Dto> LIST_FOOD = new ArrayList<>();
	    LIST_FOOD = listFood_Dto();
	    map.put("data", LIST_FOOD);
		return map;
	}
	
	@RequestMapping(value="chi-tiet/{id_food}")
	public ModelAndView loadDetailFood(@PathVariable int id_food, HttpSession session){
		StringBuffer sb = new StringBuffer();
		sb.append("FoodController #loadDetailFood ");
		ModelAndView mav = new ModelAndView("food_detail");
		User user = (User) session.getAttribute("user");
		if(user == null){
			mav = new ModelAndView("redirect:/check-login");
		}else{
			Food_Dto food = loadFoodById(id_food);
			mav.addObject("food", food);
		}
		
//		System.out.println(sb);
		logger.info(sb);
		return mav;
	}
	
	
	//end code customer
	
	//code admin restaurent
	@RequestMapping(value="admin/loadFood")
	public ModelAndView loadFood(){
		return new ModelAndView("admin/formFood", "command", new Food());
	}
	
	@RequestMapping(value="admin/saveEditFood")
	public ModelAndView saveEditFood(@ModelAttribute("food") Food food, HttpSession session){
		User user = new User();
		user = (User) session.getAttribute("user_admin");
		int id_user = user.getUser_id();
		StringBuffer sb = new StringBuffer();
		sb.append("FoodController #saveEditFood ");
		String discount_per = food.getId_discount();
		String price_food = food.getId_price();
		Discount_Food discount = new Discount_Food();
//		id_discount = food.getId_discount();
//		discount = discount_Food_Service.getDiscountFoodById(id_discount);
		discount = discount_Food_Service.getDiscountFoodByUserAndFood(id_user, food.getId_food());
		if(discount == null){
			sb.append(" Discount food not value ");
		}else{
			sb.append("thangnd -------- discount value: " + discount.getPer_discount());
			if(!(discount.getPer_discount()).equals(discount_per)){
				discount_Food_Service.updateStatusDiscount(String.valueOf(discount.getId_discount()));
				Discount_Food discount_Food = new Discount_Food();
				discount_Food.setContent_discount(discount.getContent_discount());
//				discount_Food.setId_discount(id_discount);
				discount_Food.setDiscount_status("I");
				discount_Food.setId_food(discount.getId_food());
				discount_Food.setId_user(discount.getId_user());
				discount_Food.setPer_discount(discount_per);
				System.out.println(discount_Food.toString());
				discount_Food_Service.insertDiscount(discount_Food);
				
			}
		}
		
		Price_Change price = new Price_Change();
		price = price_change_Serivice.getPriceChangeByUserAndFood(id_user, food.getId_food());
		if(price == null){
			sb.append("price not value");
		}else{
			sb.append("thangnd -------- price value: " + price.getPrice_new());
			if(!(price.getPrice_new()).equals(price_food)){
				price_change_Serivice.updatePriceStatus(String.valueOf(price.getId_price()));
				Price_Change price_change = new Price_Change();
				price_change.setDate(price.getDate());
				price_change.setDetail(price.getDetail());
				price_change.setId_food(price.getId_food());
				price_change.setId_user(price.getId_user());
				price_change.setPrice_new(price_food);
				price_change.setPrice_status("I");
				System.out.println(price_change.toString());
				price_change_Serivice.insertPriceChange(price_change);
			}
		}
		foodService.updateFood(food);
		sb.append(food.toString());
		System.out.println(sb);
		return new ModelAndView("redirect:/admin/food");
//		return null;
	}
	
	@RequestMapping(value="admin/food/{id}")
	public ModelAndView editFood(@PathVariable int id, HttpSession session){
		User user = (User) session.getAttribute("user_admin");
		StringBuffer sb = new StringBuffer();
		sb.append("FoodController #editFood: " );
		Food FOOD = new Food();
		FOOD = foodService.getFoodById(id);
		if(FOOD == null){
			sb.append(" Food not value" );
		}else{
			Price_Change price = new Price_Change();
			price = price_change_Serivice.getPriceChangeByUserAndFood(user.getUser_id(), id);
			if(price == null){
				sb.append(" Price not value " );
			}else{
				FOOD.setId_price(price.getPrice_new());
				System.out.println("thangnd ------ Price: " + FOOD.getId_price());
			}
			Discount_Food dis_food = new Discount_Food();
			id_discount = FOOD.getId_discount();
			dis_food = discount_Food_Service.getDiscountFoodByUserAndFood(user.getUser_id(), id);
			if(dis_food == null){
				sb.append("Discount Food not value ");
			}else{
				FOOD.setId_discount(dis_food.getPer_discount());
				System.out.println("thangnd ----- discount food: " + FOOD.getId_discount());
			}
			session.setAttribute("image_edit", FOOD.getImage_food());
			sb.append(FOOD.toString());
			System.out.println(sb);
		}
		return new ModelAndView("admin/formEditFood", "command", FOOD);
	}
	
	@RequestMapping(value="admin/deletefood/{id}")
	public ModelAndView deleteFood(@PathVariable int id, HttpSession session){
		StringBuffer sb = new StringBuffer();
		sb.append("FoodController #deleteFood ");
		try {
			foodService.deleteFood(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FoodController #deleteFood EXCEPTION");
		}
		System.out.println(sb);
		return new ModelAndView("redirect:/admin/food");
	}
	
	/*
	 * List food by id_user
	 */
	@RequestMapping(value="/admin/food")
	public ModelAndView loadFoodByUser(HttpSession session){
		StringBuffer sb = new StringBuffer();
		sb.append("FoodController #loadFoodByUser");
		User user = (User) session.getAttribute("user_admin");
		int id_user = user.getUser_id();
		sb.append("\t id_user: " + id_user);
		LIST_DTO_FOOD_BY_ID = listFoodById(id_user);
		if(LIST_DTO_FOOD_BY_ID.size() > 0){
			sb.append("\t LIST_DTO_FOOD_BY_ID is value");
		}else{
			sb.append("\t LIST_DTO_FOOD_BY_ID is not value");
		}
		System.out.println(sb);
		return new ModelAndView("admin/tableFood", "LIST_DTO_FOOD_BY_ID", LIST_DTO_FOOD_BY_ID);
	}
	/*
	 * List all Food in db
	 */
	@RequestMapping(value="admin/listFood")
	public ModelAndView listFood(){
		List<Food_Dto> list_Dto_Food = new ArrayList<>();
		list_Dto_Food = listFood_Dto();
		System.out.println("thangnd list food: " + list_Dto_Food.size());
//		Discount_Food dis = new Discount_Food();
//		dis = discount_Food_Service.getDiscountFoodById("D1553691748502");
//		System.out.println(dis.toString());
		return null;
	}
	
	/*
	 * Save info Food in database
	 */
	@RequestMapping(value="admin/saveFood", method = RequestMethod.POST)
	public ModelAndView  saveFood(@ModelAttribute("food") Food food, @RequestParam("file") MultipartFile files,
			HttpSession session){
		try {
		StringBuffer sb = new StringBuffer();
		StringBuffer sb_discount = new StringBuffer();
		sb.append("FoodControler #saveFood ");
		String file = upload.uploadFile(files);
		food.setImage_food(file);
		sb.append("\t " +food);
		System.out.println(sb);		
		String discount = food.getId_discount();
		String price = food.getId_price();
		
//		discount_Food_Service.insertDiscount(setDiscount(food.getId_price(), id_discount));// insert vao bang discount_food
		
		food.setStatus_food("I");
		
		food.setId_discount(" ");// lay gia tri discount_id
		food.setId_price(" ");// lay gia tri price_id
		User user = (User) session.getAttribute("user_admin");
		System.out.println("User id: " + user.getUser_id());
		food.setId_user(String.valueOf(user.getUser_id()));// lay gia tri user_id
		food.setStatus_food("I");// khi them vao bang change_price mac dinh la I. khi co update thi chuyen thanh C
		sb.append("\t " + food);
		//code function setIdRestaurant in table Food
		Restaurant rest = new Restaurant();
		rest = restaurantService.getRestaurantByIdUser(user.getUser_id());
		if(rest == null){
			sb.append("\t restaurant is not value " );
		}else{
			food.setId_rest(rest.getId_rest());
		}
		
		foodService.insertFood(food);
		
		try {
			Food food_load_by_UserImage = new Food();
			int user_id = user.getUser_id();
			food_load_by_UserImage = foodService.getFoodByImageUser(user_id, file);
			System.out.println("thangnd ++++ :" + food_load_by_UserImage.toString());
			int id_food = food_load_by_UserImage.getId_food();
			System.out.println("thangnd ++++ id_food: " + id_food);
			Discount_Food dis_food = new Discount_Food();
			dis_food = setDiscount(discount, user_id, id_food);
			discount_Food_Service.insertDiscount(dis_food);
			Price_Change price_food = new Price_Change();
			price_food = setPrice(price, user_id, id_food);
			price_change_Serivice.insertPriceChange(price_food);
			//Lay gia tri discount tu bang discount_food
			Discount_Food discount_food = discount_Food_Service.getDiscountFoodByUserAndFood(user_id, id_food);//gan vao bang food
			Price_Change food_price = price_change_Serivice.getPriceChangeByUserAndFood(user_id, id_food);
			System.out.println("thangnd =========---====== discount: " + discount_food.getPer_discount());
			System.out.println("thangnd =========---====== price: " + food_price.getPrice_new());
			foodService.updateFoodByPriceAndDiscount(discount_food.getPer_discount(), food_price.getPrice_new(), id_food);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FoodCOntroller #saveFood error insert Discount_Food and Change_Price");
		}
		System.out.println(sb_discount);
		
		} catch (Exception e) {
			System.out.println("error saveFood");
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/food");
		
	}
	
	
	//set thong tin can thiet de insert vao bang discount_food
	public Discount_Food setDiscount(String price_discount, int id_user, int id_food){
		Discount_Food discount = new Discount_Food();
		StringBuffer sb = new StringBuffer();
		sb.append("Discount Food: " );
		discount.setContent_discount("Khuyễn mãi");
		discount.setPer_discount(price_discount);
		discount.setId_user(id_user);
		discount.setId_food(id_food);
//		discount.set
		discount.setDiscount_status("I"); // khi them vao bang change_price mac dinh la I. khi co update thi chuyen thanh C
		sb.append(" Discount id: " + discount.getId_discount() + " User Id: " + discount.getId_user() + " Food Id: " + discount.getId_food()
					+ " content_discount: " + discount.getContent_discount() + " per_discount: " + discount.getPer_discount() +" discount status: " + discount.getDiscount_status());
		System.out.println(sb);
		
		return discount;
		
	}
	
	//Set thong tin de luu vao bang price_change
	public Price_Change setPrice(String price, int id_user,int id_food){
		Price_Change price_change = new Price_Change();
		StringBuffer sb = new StringBuffer();
		sb.append("Price Change #Price: ");
		price_change.setDate(java.time.LocalDate.now().toString());
		price_change.setPrice_new(price);
		price_change.setId_user(id_user);
		price_change.setId_food(id_food);
		price_change.setPrice_status("I");// khi them vao bang change_price mac dinh la I. khi co update thi chuyen thanh C
		sb.append(" ID Price: "+ price_change.getId_price() + " ID Food: " + price_change.getId_food() + " Id User: " + price_change.getId_user()
					+ " Date: " + price_change.getDate() + " Price: " + price_change.getPrice_new() + " Price Status: " + price_change.getPrice_status());
		System.out.println(sb);
		return price_change;
	}
	
	/*
	 * List all food and set value in Food_Dto
	 */
	public List<Food_Dto> listFood_Dto(){
		List<Food_Dto> list_dto_food = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		try {
			List<Food> list_Food = new ArrayList<>();
			list_Food = foodService.listFood();
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
	
	public List<Food_Dto> listFoodById(int id_user){
		List<Food_Dto> list_Dto_food = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		sb.append("FoodController #listFoodById");
		try {
			List<Food> list_Food = new ArrayList<>();
			list_Food = foodService.listFoodByIdUser(id_user);
			sb.append(" size listfoodbyID: " + list_Food.size());
			if(list_Food.size() < 1 ){
				sb.append(" List Food not value");
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
					discount = discount_Food_Service.getDiscountFoodByUserAndFood(Integer.parseInt(list_Food.get(i).getId_user()), list_Food.get(i).getId_food());
					if(discount != null){
						food_Dto.setDiscount_per(discount.getPer_discount());
					}else{
						sb.append("discount not value");
					}

					Price_Change price = new Price_Change();
					price = price_change_Serivice.getPriceChangeByUserAndFood(Integer.parseInt(list_Food.get(i).getId_user()), list_Food.get(i).getId_food());
					if(price != null){
						food_Dto.setPrice(price.getPrice_new());
					}else{
						sb.append("price not value");
					}
					list_Dto_food.add(food_Dto);
					System.out.println("thangnd +++++  per Discount: " + food_Dto.getDiscount_per());
				}
			}
			sb.append("List_dto_food size: " + list_Dto_food.size());
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
			list_Dto_food = null;
			System.out.println("FoodController #listFoodById error");
		}
		return list_Dto_food;
	}
	
	public Food_Dto loadFoodById(int id_food){
		Food_Dto food_dto = new Food_Dto();
		StringBuffer sb = new StringBuffer();
		sb.append("FoodController #loadFoodById ");
		Price_Change price = price_change_Serivice.getPriceChangeByIdFood(id_food); //get value price in table price_change
		if(price == null){
			sb.append("price not value");
		}else{
			food_dto.setId_price(String.valueOf(price.getId_price()));
			food_dto.setPrice(price.getPrice_new());
		}
		Discount_Food discount = discount_Food_Service.getDiscountFoodByIdFood(id_food);//get value discoutn in table discount_food
		if(discount == null){
			sb.append("Discount not value ");
		}else{
			food_dto.setId_discount(String.valueOf(discount.getId_discount()));
			food_dto.setDiscount_per(discount.getPer_discount());
		}
		Food food = foodService.getFoodById(id_food);
		if(food == null){
			sb.append("Food not value");
		}else{
			food_dto.setName_food(food.getName_food());
			food_dto.setImage_food(food.getImage_food());
			food_dto.setId_food(id_food);
		}
		sb.append(food_dto.toString());
		System.out.println(sb);
		return food_dto;
	}

}
