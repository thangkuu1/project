package project.thangnd.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.FoodDao;
import project.thangnd.models.Food;
import project.thangnd.services.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired 
	private FoodDao foodDao;

	@Override
	public int insertFood(Food food) {
		// TODO Auto-generated method stub
		return foodDao.insertFood(food);
	}

	@Override
	public int updateFood(Food food) {
		// TODO Auto-generated method stub
		return foodDao.updateFood(food);
	}

	@Override
	public int deleteFood(int id_food) {
		// TODO Auto-generated method stub
		return foodDao.deleteFood(id_food);
	}

	@Override
	public List<Food> listFood() {
		// TODO Auto-generated method stub
		return foodDao.listFood();
	}

	@Override
	public Food getFoodByImageUser(int id_user, String image) {
		// TODO Auto-generated method stub
		return foodDao.getFoodByImageUser(id_user, image);
	}

	@Override
	public List<Food> listFoodByIdUser(int id_user) {
		// TODO Auto-generated method stub
		return foodDao.listFoodByIdUser(id_user);
	}

	@Override
	public Food getFoodById(int id_food) {
		// TODO Auto-generated method stub
		return foodDao.getFoodById(id_food);
	}

	@Override
	public int updateFoodByPriceAndDiscount(String id_discount, String id_price, int id_food) {
		// TODO Auto-generated method stub
		return foodDao.updateFoodByPriceAndDiscount(id_discount, id_price, id_food);
	}

	@Override
	public List<Food> listFoodByIdRest(int id_rest) {
		// TODO Auto-generated method stub
		return foodDao.listFoodByIdRest(id_rest);
	}
	

}
