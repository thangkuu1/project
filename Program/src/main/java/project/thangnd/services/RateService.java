package project.thangnd.services;

import java.util.List;

import project.thangnd.models.Rate;

public interface RateService {
	public int insertRate(Rate rate);
	public int updateRate(Rate rate);
	public Rate getRateByIdRestUser(int id_rest, int id_user);
	public int updateRateByIdRestUser(int id_rest, int id_user);
	public List<Rate> countRateByRate(int number_rate, int id_rest);
}
