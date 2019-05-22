package project.thangnd.daoImpls;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.thangnd.daos.RateDao;
import project.thangnd.models.Rate;

@Repository
@Transactional
public class RateDaoImpl implements RateDao {
	Logger logger = Logger.getLogger(RateDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public int insertRate(Rate rate) {
		StringBuffer sb = new StringBuffer();
		sb.append("RateDaoImpl #insertRate ");
		int result = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(rate);
			transaction.commit();
			result = 1;
			sb.append(rate.toString());
			sb.append(" success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("RateDaoImpl #insertRate error");
			result = 0;
		}
		System.out.println(sb);
		return result;
	}
	@Override
	public int updateRate(Rate rate) {
		StringBuffer sb = new StringBuffer();
		sb.append("RateDaoImpl #updateRate ");
		int result = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.update(rate);
			transaction.commit();
			sb.append(rate.toString());
			sb.append("updaterate success");
			result = 1;
		} catch (Exception e) {
			result = 0;
			System.out.println("RateDaoImpl #updateRate error");
		}
		System.out.println(sb);
		return result;
	}
	@Override
	public Rate getRateByIdRestUser(int id_rest, int id_user) {
		Rate rate = new Rate();
		List<Rate> list_rate = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		sb.append("RateDaoImpl #getRateByIdRestUser ");
		String sql = " select * from rate where id_rest = '" + id_rest + "' and id_user = '" + id_user + "' and status_rate = 'I'" ;
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Rate.class);
			list_rate = query.list();
			transaction.commit();
			if(list_rate.size() < 1){
				sb.append("rate not value ");
				rate = null;
			}else{
				rate = list_rate.get(0);
				sb.append("rate is value ");
				sb.append(rate.toString());
			}
		} catch (Exception e) {
			System.out.println("RateDaoImpl #getRateByIdRestUser error");
			e.printStackTrace();
			rate = null;
		}
		System.out.println(sb);
		return rate;
	}
	@Override
	public int updateRateByIdRestUser(int id_rest, int id_user) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("RateDaoImpl #updateRateByIdRestdUser ");
		String sql ="update rate set rate.status_rate = 'C' where rate.id_user = ' " + id_user + "' and rate.id_rest = '" + id_rest + "'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			transaction.commit();
			result = 1;
			sb.append(" Update Rate By Id Food User success " );
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
			System.out.println("RateDaoImpl #updateRateByIdRestUser error ");
		}
		return result;
	}
	@Override
	public List<Rate> countRateByRate(int number_rate, int id_rest) {
		StringBuffer sb = new StringBuffer();
		sb.append("number rate: " + number_rate);
		List<Rate> list_rate = new ArrayList<>();
		String sql = "select * from rate where status_rate = 'I' and count_rate = '" + number_rate + "' and id_rest = '" + id_rest + "'";
		sb.append("\t sql: " + sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Rate.class);
			list_rate = query.list();
			transaction.commit();
			sb.append("\t Success. result: " + list_rate.size());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error exception");
		}
		logger.info(sb);
		return list_rate;
	}

}
