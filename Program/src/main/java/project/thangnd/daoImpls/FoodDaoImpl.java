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

import project.thangnd.daos.FoodDao;
import project.thangnd.models.Food;

@Repository
@Transactional
public class FoodDaoImpl implements FoodDao {
	Logger logger = Logger.getLogger(FoodDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insertFood(Food food) {
		StringBuffer sb = new StringBuffer();
		sb.append("FoodDaoImpl #insertFood ");
		int result = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(food);
			transaction.commit();
			result = 1;
			sb.append("\t success" + food.toString());
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
//			System.out.println("Error insert food");
			sb.append("\t error");
		}
		logger.info(sb);
		return result;
	}

	@Override
	public int updateFood(Food food) {
		StringBuffer sb = new StringBuffer();
		sb.append("FoodDaoImpl #updateFood");
		int result = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.update(food);
			transaction.commit();
			result = 1;
			sb.append("\t update success " + food);
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("Error update Food");
			logger.error("Error update Food");
		}
		logger.info(sb);
		return result;
	}

	/*
	 * Thuc chat thay the truong status_food tu I sang C
	 * @see project.thangnd.daos.FoodDao#deleteFood(int)
	 */
	
	@Override
	public int deleteFood(int id_food) {
		StringBuffer sb = new StringBuffer();
		int result = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
//			StringBuffer sb = new StringBuffer();
			sb.append("FoodDaoImpl # deleteFood: ");
			String sql = "update food_post set food_post.status_food = 'C' where food_post.id_food = '" + id_food + "'";
			sb.append("  Sql:  " + sql);
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			transaction.commit();
			result = 1;
//			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
			System.out.println("error foodDaoImpl #deleteFood");
		}
		logger.info(sb);
		return result;
	}

	@Override
	public List<Food> listFood() {
		StringBuffer sb = new StringBuffer();
		sb.append("FoodDaoImpl #listFood");
		List<Food> listFood = new ArrayList<>();	
		String sql = "select * from food_post where food_post.status_food = 'I'";
		sb.append("\t sql: " + sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
//			listFood = session.createQuery("from Food").list();
			
			Query query = session.createSQLQuery(sql).addEntity(Food.class);
			listFood = query.list();
			transaction.commit();
			sb.append("Success list Food");
		} catch (Exception e) {
			listFood = null;
			e.printStackTrace();
			System.out.println("Error FoodDaoImpl #listFood");
		}
		logger.info(sb);
		return listFood;
	}

	@Override
	public Food getFoodByImageUser(int id_user, String image) {
		StringBuffer sb = new StringBuffer();
		sb.append("FoodDaoImpl #getFoodByImageUser ");
		Food food = new Food();
		List<Food> listFood = new ArrayList<>();
		String sql = "select * from food_post where food_post.id_user = " + "'" + id_user + "'" + " and food_post.image_food = " 
						+ "'" + image + "'"; 
		sb.append("Result: sql " + sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Food.class);
			listFood = query.list();
			transaction.commit();
			if(listFood.size() > 0){
				food = listFood.get(0);
				sb.append("Food: " + food.toString());
			}else{
				food = null;
				sb.append("Food not found" );
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FoodDaoImpl #getFoodByUserImage Error");
		}
		logger.info(sb);
		return food;
	}

	@Override
	public List<Food> listFoodByIdUser(int id_user) {
		List<Food> listFood = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		sb.append("FoodDaoImpl #listFoodByIdUser");
		String sql = "select * from food_post where food_post.status_food = 'I' and id_user = '" + id_user + "'";
		sb.append("Result SQL: " + sql); 
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Food.class);
			listFood = query.list();
			transaction.commit();
			if(listFood.size() > 0){
				sb.append(" ListFoodByUser is value");
			}else{
				sb.append(" ListFoodByUser not value");
			}
		} catch (Exception e) {
			listFood = null;
			e.printStackTrace();
			System.out.println("FoodDaoImpl #listFoodByIduser error");
		}
		logger.info(sb);
		return listFood;
	}

	@Override
	public Food getFoodById(int id_food) {
		StringBuffer sb = new StringBuffer();
		sb.append("FoodDaoImpl # getFoodById ");
		Food food = new Food();
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			food = (Food) session.load(Food.class, id_food);
			if(food == null){
				sb.append("food not value");
			}else{
				sb.append("food is value");
				sb.append(" Food: " + food.toString());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FoodDaoImpl #getFoodById error");
			food = null;
		}
//		System.out.println(sb);
		logger.info(sb);
		return food;
	}

	@Override
	public int updateFoodByPriceAndDiscount(String id_discount, String id_price, int id_food) {
		StringBuffer sb = new StringBuffer();
		sb.append("FoodDaoImpl #updateFoodByPriceAndDiscount ");
		int result = 0;
		String sql = "update food_post set food_post.id_price = '" + id_price + "' , food_post.id_discount = '" + id_discount
					+ "' where food_post.id_food = '" + id_food +"'";
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
			System.out.println("FoodDaoImpl #updateFoodByPriceAndDiscount");
			result = 0;
		}
//		System.out.println(sb);
		logger.info(sb);
		return result;
	}

	@Override
	public List<Food> listFoodByIdRest(int id_rest) {
		StringBuffer sb = new StringBuffer();
		sb.append("FoodDaoImpl #listFoodByIdRest");
		List<Food> list_food = new ArrayList<>();
		String sql = "select * from food_post where status_food = 'I' and id_rest = '" + id_rest + "'";
		sb.append("\t " + sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Food.class);
			
			list_food = query.list();
			transaction.commit();
			if(list_food.size() > 0){
				sb.append("\t food is value");
			}else{
				sb.append("\t food is not value");
			}
		} catch (Exception e) {
			System.out.println("FoodDaoImpl #listFoodbyIdRest error");
			e.printStackTrace();
			list_food = null;
		}
//		System.out.println(sb);
		logger.info(sb);
		return list_food;
	}

	

}
