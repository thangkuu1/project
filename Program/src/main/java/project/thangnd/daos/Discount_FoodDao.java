package project.thangnd.daos;

import project.thangnd.models.Discount_Food;

public interface Discount_FoodDao {

	public int insertDiscount(Discount_Food dis_food);
	public int updateDiscount(Discount_Food dis_food);
	public int deleteDiscount(String dis_id);
	public Discount_Food getDiscountFoodById(String dis_id);
	public int updateStatusDiscount(String id_discount);
	public Discount_Food getDiscountFoodByUserAndFood(int id_user, int id_food);
	public Discount_Food getDiscountFoodByIdFood(int id_food);
	public Double sumDiscount(int id_rest);
}
