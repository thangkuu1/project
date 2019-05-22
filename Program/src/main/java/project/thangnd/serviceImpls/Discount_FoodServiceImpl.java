package project.thangnd.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.Discount_FoodDao;
import project.thangnd.models.Discount_Food;
import project.thangnd.services.Discount_FoodService;

@Service
public class Discount_FoodServiceImpl implements Discount_FoodService {
	
	@Autowired
	private Discount_FoodDao dis_food_Dao;
	

	@Override
	public int insertDiscount(Discount_Food dis_food) {
		// TODO Auto-generated method stub
		return dis_food_Dao.insertDiscount(dis_food);
	}


	@Override
	public int updateDiscount(Discount_Food dis_food) {
		// TODO Auto-generated method stub
		return dis_food_Dao.updateDiscount(dis_food);
	}


	@Override
	public int deleteDiscount(String dis_id) {
		// TODO Auto-generated method stub
		return dis_food_Dao.deleteDiscount(dis_id);
	}


	@Override
	public Discount_Food getDiscountFoodById(String dis_id) {
		// TODO Auto-generated method stub
		return dis_food_Dao.getDiscountFoodById(dis_id);
	}


	@Override
	public int updateStatusDiscount(String id_discount) {
		// TODO Auto-generated method stub
		return dis_food_Dao.updateStatusDiscount(id_discount);
	}


	@Override
	public Discount_Food getDiscountFoodByUserAndFood(int id_user, int id_food) {
		// TODO Auto-generated method stub
		return dis_food_Dao.getDiscountFoodByUserAndFood(id_user, id_food);
	}


	@Override
	public Discount_Food getDiscountFoodByIdFood(int id_food) {
		// TODO Auto-generated method stub
		return dis_food_Dao.getDiscountFoodByIdFood(id_food);
	}


	@Override
	public Double sumDiscount(int id_rest) {
		// TODO Auto-generated method stub
		return dis_food_Dao.sumDiscount(id_rest);
	}

}
