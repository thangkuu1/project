package project.thangnd.daoImpls;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.thangnd.daos.UserDao;
import project.thangnd.models.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	Logger logger = Logger.getLogger(UserDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insertUser(User user) {
		int result = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public User getUserById(int id_user) {
		StringBuffer sb = new StringBuffer();
		sb.append("UserDaoImpl #getUserById " );
		User user = new User();
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			user = (User) session.load(User.class, id_user);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			user = null;
//			System.out.println("UserDaoImpl #getUserById error");
			logger.error("error exception");
		}
//		System.out.println(sb);
		logger.info(sb);
		return user;
	}

}
