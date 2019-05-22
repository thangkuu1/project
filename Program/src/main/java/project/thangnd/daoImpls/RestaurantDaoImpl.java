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

import project.thangnd.daos.RestaurantDao;
import project.thangnd.models.Restaurant;

@Repository
@Transactional
public class RestaurantDaoImpl implements RestaurantDao{

	Logger logger = Logger.getLogger(RestaurantDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insertRestaurant(Restaurant rest) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("RestaurantDaoImpl #insertRestaurant ");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(rest);
			transaction.commit();
			sb.append("success");
			result = 1;
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
//			System.out.println("#RestaurantDaoImpl #insertRestaurant error");
			logger.error("error exception");
		}
//		System.out.println(sb);
		logger.info(sb);
		return result;
	}

	@Override
	public Restaurant getRestaurantByIdUser(int id_user) {
		StringBuffer sb = new StringBuffer();
		sb.append("RestaurantDaoImpl #getRestaurantByIdUser ");
		List<Restaurant> list_rest = new ArrayList<>();
		Restaurant rest = new Restaurant();
		String sql = "select * from restaurant where restaurant.status_rest = 'I' and restaurant.id_user = '" + id_user +"'";
		sb.append("\t " +sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);
			list_rest = query.list();
			transaction.commit();
			if(list_rest.size()> 0){
				rest = list_rest.get(0);
				sb.append("\t getRestaurantByIdUser success");
			}else{
				rest = null;
				sb.append("\t getRestaurantByIdUser failed");
			}
		} catch (Exception e) {
//			System.out.println("RestaurantDaoImpl #getRestaurantByIdUser error");
			logger.error("error exception");
			e.printStackTrace();
			rest = null;
		}
		
//		System.out.println(sb);
		logger.info(sb);
		return rest;
	}

	@Override
	public List<Restaurant> listRestaurant() {
		StringBuffer sb = new StringBuffer();
		sb.append("RestaurantDaoImpl #listRestaurant");
		List<Restaurant> listRestaurant = new ArrayList<>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			listRestaurant = session.createQuery("from Restaurant").list();
			transaction.commit();
			if(listRestaurant.size() > 0){
				sb.append("\t listRestaurant success");
			}else{
				sb.append("\t list Restaurant not value");
			}
			
		} catch (Exception e) {
//			System.out.println("RestaurantDaoImpl #listRestaurant error");
			logger.error("error exception");
			e.printStackTrace();
			listRestaurant = null;
		}
		
//		System.out.println(sb);
		logger.info(sb);
		return listRestaurant;
	}

	@Override
	public Restaurant getRestaurantById(int id_rest) {
		StringBuffer sb = new StringBuffer();
		sb.append("RestaurantDaoImpl #getRestaurantById ");
		Restaurant rest = new Restaurant();
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			rest = (Restaurant) session.load(Restaurant.class, id_rest);
			transaction.commit();
			sb.append("\t " + rest.toString());
		} catch (Exception e) {
//			System.out.println("RestaurantDaoImpl #getRestaurantById ");
			logger.error("error exception");
			e.printStackTrace();
			rest = null;
		}
//		System.out.println(sb);
		logger.info(sb);
		return rest;
	}

	@Override
	public int updateRestaurant(Restaurant rest) {
		int result = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.update(rest);
			transaction.commit();
			result = 1;
			logger.info("update restaurant success");
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
			logger.error("update restaurant exception");
		}
		return result;
	}

	@Override
	public List<Restaurant> listRestaurantByName(String name) {
		List<Restaurant> list_rest = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		String sql = "select * from restaurant where name_rest like '%" + name +"%'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);
			list_rest = query.list();
			sb.append("\t list restaurant by name restaurant success");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			list_rest = null;
			logger.error("exception");
			
		}
		return list_rest;
	}
}
