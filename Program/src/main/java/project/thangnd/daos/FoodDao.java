package project.thangnd.daos;

import java.util.List;

import project.thangnd.models.Food;

public interface FoodDao {
	
	public int insertFood(Food food);
	public int updateFood(Food food);
	public int deleteFood(int id_food);
	public List<Food> listFood();
	public Food getFoodByImageUser(int id_user, String image);
	public List<Food> listFoodByIdUser(int id_user);
	public Food getFoodById(int id_food);
	public int updateFoodByPriceAndDiscount(String id_discount, String id_price, int id_food);
	public List<Food> listFoodByIdRest(int id_rest);

}
