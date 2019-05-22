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

import com.mysql.fabric.xmlrpc.base.Array;

import project.thangnd.daos.Discount_FoodDao;
import project.thangnd.models.Discount_Food;

@Repository
@Transactional
public class Discount_FoodImpl implements Discount_FoodDao {
	Logger logger = Logger.getLogger(Discount_FoodImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insertDiscount(Discount_Food dis_food) {
		StringBuffer sb = new StringBuffer();
		int result = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(dis_food);
			transaction.commit();
			result = 1;
			sb.append("success. Discount Food: " + dis_food);
		} catch (Exception e) {
			result = 0;
//			System.out.println("error insert discount food");
			logger.error("error exception");
			e.printStackTrace();
		}
		logger.info(sb);
		return result;
	}

	@Override
	public int updateDiscount(Discount_Food dis_food) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.update(dis_food);
			transaction.commit();
			result = 1;
			sb.append("success. discount food: " + dis_food); 
		} catch (Exception e) {
			System.out.println("Error Discount_Food #updateDiscount");
			logger.error("error exception");
			e.printStackTrace();
			result = 0;
		}
		logger.info(sb);
		return result;
	}

	@Override
	public int deleteDiscount(String dis_id) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		String sql = "update discount_food set discount_food.discount_status = 'C' where id_discount = ' " + dis_id + "'";
		try {
			sb.append("SQL Result: " + sql);
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			transaction.commit();
			result = 1;
			sb.append("\t success");
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
			System.out.println("Error Discount_Food #deleteDiscount");
			logger.error("error exception");
		}
		logger.info(sb);
		return result;
	}

	
	@Override
	public Discount_Food getDiscountFoodById(String dis_id) {
		Discount_Food dis_food = null;
		List<Discount_Food> list_discount = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		sb.append("DiscountFoodImpl #GetDiscountFoodByID: ");
		String sql ="Select * from discount_food where id_discount = '" + dis_id + "' and discount_status = 'I'"  ;
		sb.append( sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
//			dis_food = (Discount_Food) session.load(Discount_Food.class, dis_id);
			Query query = session.createSQLQuery(sql).addEntity(Discount_Food.class);
			list_discount = query.list();
			if(list_discount.size() > 0){
				dis_food = list_discount.get(0);
				sb.append("discount food success");
			}else{
				sb.append("discount food failed");
			}
			sb.append(" Discount Food Result: " + dis_food.toString());
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			dis_food = null;
//			System.out.println("Error Discount_Food #getDiscountFoodById");
			logger.error("error exception");
		}
//		System.out.println(sb);
		logger.info(sb);
		return dis_food;
	}

	@Override
	public int updateStatusDiscount(String id_discount) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("Discount_FoodImpl #updateStatusDiscount ");
		String sql = "update discount_food set discount_food.discount_status = 'C' where discount_food.discount_status = 'I' and discount_food.id_discount = '" + id_discount + "'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			transaction.commit();
			result = 1;
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
//			System.out.println("Discount_FoodImpl #updateStatusDiscount error");
			logger.error("error exception");
		}
//		System.out.println(sb);
		logger.info(sb);
		return result;
	}

	@Override
	public Discount_Food getDiscountFoodByUserAndFood(int id_user, int id_food) {
		Discount_Food dis_food = null;
		List<Discount_Food> list_dis_food = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		sb.append("Discount_FoodImpl # getDiscountFoodByUserAndFood ");
		String sql = "select * from discount_food where discount_food.discount_status = 'I' and discount_food.id_user = '" + id_user
					+ "' and discount_food.id_food = '" + id_food + "'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Discount_Food.class);
			list_dis_food = query.list();
			if(list_dis_food.size() < 1){
				sb.append("list discount food not value");
			}else{
				dis_food = list_dis_food.get(0);
				sb.append("value discount food: " + dis_food.toString());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			dis_food = null;
//			System.out.println("Discount_FoodImpl #getDiscountFoodByUserAndFood error");
			logger.error("error exception");
		}
//		System.out.println(sb);
		logger.info(sb);
		return dis_food;
	}

	@Override
	public Discount_Food getDiscountFoodByIdFood(int id_food) {
		Discount_Food dis_food = new Discount_Food();
		List<Discount_Food> list_dis_food = new ArrayList<>();
		String sql = "select * from discount_food where discount_status = 'I' and id_food = '" + id_food + "'";
		StringBuffer sb = new StringBuffer();
		sb.append("Discount_FoodImpl getDiscountFoodByIdFood ");
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Discount_Food.class);
			list_dis_food = query.list();
			transaction.commit();
			if(list_dis_food.size() > 0){
				dis_food = list_dis_food.get(0);
				sb.append("Discount is value : " + dis_food.toString());
			}else {
				sb.append("Discount Food not value");
			}
		} catch (Exception e) {
			dis_food = null;
			e.printStackTrace();
//			System.out.println("Discount_FoodImpl getDiscountFoodByIdFood error");
			logger.error("error exception");
		}
//		System.out.println(sb);
		logger.info(sb);
		return dis_food;
	}

	@Override
	public Double sumDiscount(int id_rest) {
		StringBuffer sb = new StringBuffer();
		Double sum = 0.0;
		List<Double> list = new ArrayList<>();
		String sql = "select sum(id_discount) from food_post where id_rest = '" + id_rest + "'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			list = query.list();
			if(list.size()> 0){
				sum = list.get(0);
			}
			transaction.commit();
			sb.append("\t sum discount succes");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception");
			sum = 0.0;
		}
		logger.info(sb);
		return sum;
	}

}
