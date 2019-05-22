//package project.thangnd.utils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import project.thangnd.daoImpls.FoodDaoImpl;
//import project.thangnd.dtos.Food_Dto;
//import project.thangnd.models.Discount_Food;
//import project.thangnd.models.Food;
//import project.thangnd.models.Price_Change;
//import project.thangnd.services.Discount_FoodService;
//import project.thangnd.services.FoodService;
//import project.thangnd.services.Price_ChangeService;
//
//public class LoadFood {
//	
//	List<Food_Dto> LIST_DTO_FOOD = new ArrayList<>();
//	@Autowired
//	private FoodService  foodService;
//	private Price_ChangeService price_ChangeService;
//	private Discount_FoodService discount_FoodService;
//	
//	public List<Food_Dto> getListFood(){
//		StringBuffer sb = new StringBuffer();
//		sb.append("FoodLoad #getListFood: ");
//		List<Food> list_Food = new ArrayList<>();
//		list_Food = foodService.listFood();
//		System.out.println(list_Food.size());
//		try {
//			
////			list_Food = foodDao.listFood();
//			if(list_Food.size() < 1){
//				sb.append("Food not found");
//			}else{
//				for(int i = 0; i < list_Food.size(); i++){
//					Food_Dto food_Dto = new Food_Dto();
//					food_Dto.setId_food(list_Food.get(i).getId_food());
//					food_Dto.setCity_food(list_Food.get(i).getCity_food());
//					food_Dto.setId_discount(list_Food.get(i).getId_discount());
//					food_Dto.setId_price(list_Food.get(i).getId_price());
//					food_Dto.setId_user(list_Food.get(i).getId_user());
//					food_Dto.setDistrict_food(list_Food.get(i).getDistrict_food());
//					food_Dto.setNo_street(list_Food.get(i).getNo_street_food());
//					food_Dto.setOpen_time_food(list_Food.get(i).getOpen_time_food());
//					Price_Change price = new Price_Change();
//					Discount_Food discount = new Discount_Food();
////					discount = discount_FoodService.getDiscountFoodById(list_Food.get(i).getId_discount());
//					if(discount != null){
//						food_Dto.setDiscount_per(discount.getPer_discount());
//					}
//					LIST_DTO_FOOD.add(food_Dto);
//					System.out.println("thangnd +++++  per Discount: " + food_Dto.getDiscount_per());
//				}
//			}
//			System.out.println(sb);
//		} catch (Exception e) {
//			System.out.println("LoadFood #getListFood error");
//			e.printStackTrace();
//		}
//		return LIST_DTO_FOOD;
//	}
//	
//	
//}
