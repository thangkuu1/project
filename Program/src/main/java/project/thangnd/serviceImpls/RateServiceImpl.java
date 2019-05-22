package project.thangnd.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.RateDao;
import project.thangnd.models.Rate;
import project.thangnd.services.RateService;

@Service
public class RateServiceImpl implements RateService {

	@Autowired
	private RateDao rateDao;
	
	@Override
	public int insertRate(Rate rate) {
		// TODO Auto-generated method stub
		return rateDao.insertRate(rate);
	}

	@Override
	public int updateRate(Rate rate) {
		// TODO Auto-generated method stub
		return rateDao.updateRate(rate);
	}

	@Override
	public Rate getRateByIdRestUser(int id_rest, int id_user) {
		// TODO Auto-generated method stub
		return rateDao.getRateByIdRestUser(id_rest, id_user);
	}

	@Override
	public int updateRateByIdRestUser(int id_rest, int id_user) {
		// TODO Auto-generated method stub
		return rateDao.updateRateByIdRestUser(id_rest, id_user);
	}

	@Override
	public List<Rate> countRateByRate(int number_rate, int id_rest) {
		// TODO Auto-generated method stub
		return rateDao.countRateByRate(number_rate, id_rest);
	}

}
