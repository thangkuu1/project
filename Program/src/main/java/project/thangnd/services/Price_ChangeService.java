package project.thangnd.services;

import project.thangnd.models.Price_Change;

public interface Price_ChangeService {

	public int insertPriceChange(Price_Change price_change);
	public Price_Change getPriceChangeById(String price_id);
	public int updatePriceStatus(String price_id);
	public Price_Change getPriceChangeByUserAndFood(int id_user, int id_food);
	public Price_Change getPriceChangeByIdFood(int id_food);
}
