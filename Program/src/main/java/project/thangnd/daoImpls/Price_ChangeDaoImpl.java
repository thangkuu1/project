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

import project.thangnd.daos.Price_ChangeDao;
import project.thangnd.models.Price_Change;

@Repository
@Transactional
public class Price_ChangeDaoImpl implements Price_ChangeDao{
	Logger logger = Logger.getLogger(Price_Change.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insertPriceChange(Price_Change price_change) {
		StringBuffer sb = new StringBuffer();
		int result = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(price_change);
			transaction.commit();
			result = 1;
			sb.append("success. Price change: " + price_change.toString());
		} catch (Exception e) {
//			System.out.println("erro insert change pricce");
			logger.error("error exception");
			e.printStackTrace();
			result = 0;
		}
		logger.info(sb);
		return result;
	}

	@Override
	public Price_Change getPriceChangeById(String price_id) {
		Price_Change price = null;
		List<Price_Change> price_list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		sb.append("Price_ChangeDaoImpl #getPriceChangeById ");
		String sql = "select * from change_price where id_price = '" + price_id + "' and change_price.price_status = 'I'";
		sb.append("\t sql: "+sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Price_Change.class);
			price_list = query.list();
			if(price_list.size() < 1 ){
				sb.append(" Price List not value");
			}else{
				price = price_list.get(0);
				sb.append("Price is value Price value: " + price.toString());
			}
//			price = (Price_Change) session.load(Price_Change.class, price_id);
//			sb.append(price.toString());
			transaction.commit();
		} catch (Exception e) {
//			System.out.println("Price_ChangeDaoImpl #getPriceChangeById error");
			logger.error("error exception");
			price = null;
			e.printStackTrace();
		}
//		System.out.println(sb);
		logger.info(sb);
		return price;
	}

	@Override
	public int updatePriceStatus(String price_id) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("Price_ChangDaoImpl #updatePriceStatus ");
		String sql = "update change_price set change_price.price_status ='C' where change_price.price_status = 'I' and change_price.id_price = '" + price_id + "'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			transaction.commit(); 
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("Price_ChangeDaoImpl #updatePriceStatus error");
			logger.error("error exception");
			result = 0;
		}
//		System.out.println(sb);
		logger.info(sb);
		return result;
	}

	@Override
	public Price_Change getPriceChangeByUserAndFood(int id_user, int id_food) {
		StringBuffer sb = new StringBuffer();
		sb.append("Price_ChangeDaoImpl #getPriceChangeByUserAndFood ");
		Price_Change price = new Price_Change();
		List<Price_Change> list_price = new ArrayList<>();
		String sql = "select * from change_price where change_price.price_status = 'I' and change_price.id_food = '" + id_food + "' and change_price.id_user = '" 
					+ id_user + "'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Price_Change.class);
			list_price = query.list();
			if(list_price.size() < 1 ){
				sb.append("list price not value" );
			}else{
				price = list_price.get(0);
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println"Price_ChangeDaoImpl #getPriceChangeByUserAndFood error");
			logger.error("error exception");
			price = null;
		}
//		System.out.println(sb);
		logger.info(sb);
		return price;
	}

	@Override
	public Price_Change getPriceChangeByIdFood(int id_food) {
		Price_Change price_change = new Price_Change();
		List<Price_Change> list_price_change = new ArrayList<>();
		String sql = "Select * from change_price where price_status = 'I' and id_food = '"+ id_food +"'";
		StringBuffer sb = new StringBuffer();
		sb.append("Price_ChangeDaoImpl #getPriceChangeByIdFood ");
		sb.append("\t sql: " + sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Price_Change.class);
			list_price_change = query.list();
			transaction.commit();
			if(list_price_change.size() > 0){
				sb.append("Price Change is value");
				price_change = list_price_change.get(0);
			}else{
				sb.append("Price Change not value");
			}
		} catch (Exception e) {
			e.printStackTrace();
			price_change = null;
//			System.out.println("Price_ChangeDaoImpl #getPriceChangeByIdFood error");
			logger.error("error exception");
		}
//		System.out.println(sb);
		logger.info(sb);
		return price_change;
	}

}
