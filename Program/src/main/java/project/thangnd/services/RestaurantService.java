package project.thangnd.services;

import java.util.List;

import project.thangnd.models.Food;
import project.thangnd.models.Restaurant;

public interface RestaurantService {

	public int insertRestaurant(Restaurant rest);
	public int updateRestaurant(Restaurant rest);
	public Restaurant getRestaurantByIdUser(int id_user);
	public List<Restaurant> listRestaurant();
	public Restaurant getRestaurantById(int id_rest);
	public List<Restaurant> listRestaurantByName(String name);
}
