package project.thangnd.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.Price_ChangeDao;
import project.thangnd.models.Price_Change;
import project.thangnd.services.Price_ChangeService;

@Service
public class Price_ChangeServiceImpl implements Price_ChangeService{

	@Autowired
	private Price_ChangeDao price_ChangeDao;

	@Override
	public int insertPriceChange(Price_Change price_change) {
		// TODO Auto-generated method stub
		return price_ChangeDao.insertPriceChange(price_change);
		
	}

	@Override
	public Price_Change getPriceChangeById(String price_id) {
		// TODO Auto-generated method stub
		return price_ChangeDao.getPriceChangeById(price_id);
	}

	@Override
	public int updatePriceStatus(String price_id) {
		// TODO Auto-generated method stub
		return price_ChangeDao.updatePriceStatus(price_id);
	}

	@Override
	public Price_Change getPriceChangeByUserAndFood(int id_user, int id_food) {
		// TODO Auto-generated method stub
		return price_ChangeDao.getPriceChangeByUserAndFood(id_user, id_food);
	}

	@Override
	public Price_Change getPriceChangeByIdFood(int id_food) {
		// TODO Auto-generated method stub
		return price_ChangeDao.getPriceChangeByIdFood(id_food);
	}
	
	

	
}
