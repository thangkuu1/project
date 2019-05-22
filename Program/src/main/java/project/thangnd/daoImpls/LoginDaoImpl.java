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

import project.thangnd.daos.LoginDao;
import project.thangnd.models.User;
import project.thangnd.models.UserHistory;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {
	Logger logger = Logger.getLogger(LoginDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUserByUsePass(String usename, String password) {
		User user = null;
		StringBuffer sb = new StringBuffer();
		List<User> listUser = new ArrayList<User>();
		try {
			sb.append("LoginDaoImpl. getUserByUsePass: ");
			String sql = "select * from datn_20182_v1.user where username = " + "'" + usename + "'"  + "and" + " password = "  + "'" + password +"'";
			sb.append(" sql result: " + sql);
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(User.class);
			listUser = query.list();
			transaction.commit();
			if(listUser.size() > 0){
				user = listUser.get(0);
				sb.append(" Username:" + user.getUsername() + " phone: " + user.getPhone() + " email: " + user.getEmail() + " date: " + user.getDate());
			}else{
				user = null;
				sb.append("Khong co user nao");
			}
//			System.out.println(sb);
			
		} catch (Exception e) {
//			System.out.println("error LoginDaoImpl # getUsetrByUserPass");
			logger.error("error exception");
			e.printStackTrace();
			user = null;
		}
		logger.info(sb);
		return user;
	}

	@Override
	public int insertUserHistory(UserHistory userHistory) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("LoginDaoImpl. insertHistory: ");
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(userHistory);
			transaction.commit();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
			logger.error("error exception");
		}
		logger.info(sb);
		return result;
	}

	@Override
	public int updateStatusLogin(int id_user) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		String sql = "update user set user.user_status = 'O' where user.user_id = '" +id_user + "'";
		sb.append("\t sql: " + sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			transaction.commit();
			result = 1;
			sb.append("\t success");
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("LoginDaoImpl #updateStatusLogin error update user_status");
			logger.error("error exception");
			result = 0;	
		}
		logger.info(sb);
		return result;
	}

	@Override
	public int logoutUser(int id_user) {

		StringBuffer sb = new StringBuffer();
		int result = 0;
		String sql = "update user set user.user_status = 'C' where user.user_id = '" +id_user + "'";
		sb.append("\t sql: " + sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			transaction.commit();
			result = 1;
			sb.append("\t success");
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("LoginDaoImpl #logoutUser error logout");
			logger.error("error exception");
			result = 0;
		}
		logger.info(sb);
		return result;
	}

	@Override
	public int logoutUserByName(String username) {
		StringBuffer sb = new StringBuffer();
		sb.append("LoginDaoImpl #logoutUserByName ");
		int result = 0;
		String sql = "update user set user.user_status = 'C' where user.username = '" + username + "'";
		sb.append("\t sql: " +sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			transaction.commit();
			result = 1;
			sb.append("\t logoutUserByName success");
		} catch (Exception e) {
			result = 0;
//			System.out.println("LoginDaoImpl #logoutUserByName error");
			logger.error("error exception");
			e.printStackTrace();
		}
//		System.out.println(sb);
		logger.info(sb);
		return result;
	}

}
