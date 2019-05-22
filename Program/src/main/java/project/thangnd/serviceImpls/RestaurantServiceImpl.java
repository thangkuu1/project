package project.thangnd.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.RestaurantDao;
import project.thangnd.models.Restaurant;
import project.thangnd.services.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDao restDao;
	
	@Override
	public int insertRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		return restDao.insertRestaurant(rest);
	}

	@Override
	public Restaurant getRestaurantByIdUser(int id_user) {
		// TODO Auto-generated method stub
		return restDao.getRestaurantByIdUser(id_user);
	}

	@Override
	public List<Restaurant> listRestaurant() {
		// TODO Auto-generated method stub
		return restDao.listRestaurant();
	}

	@Override
	public Restaurant getRestaurantById(int id_rest) {
		// TODO Auto-generated method stub
		return restDao.getRestaurantById(id_rest);
	}

	@Override
	public int updateRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		return restDao.updateRestaurant(rest);
	}

	@Override
	public List<Restaurant> listRestaurantByName(String name) {
		// TODO Auto-generated method stub
		return restDao.listRestaurantByName(name);
	}

	
}
