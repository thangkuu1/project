package project.thangnd.daoImpls;

import java.math.BigInteger;
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

import project.thangnd.daos.ProgressDao;
import project.thangnd.models.Progress;

@Repository
@Transactional
public class ProgressDaoImpl implements ProgressDao {

	Logger logger = Logger.getLogger(ProgressDao.class);
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public List<Progress> listProgress(int id) {
		List<Progress> listProgress = new ArrayList<>();
		String sql = "select * from progress where id_progress = '" + id + "' order by step_progress";
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Progress.class);
			listProgress = query.list();
			transaction.commit();
			logger.info("list progress success");
		} catch (Exception e) {
			logger.error("exception");
			e.printStackTrace();
			listProgress = null;
		}
		return listProgress;
	}

	@Override
	public int insertProgress(Progress progress) {

		int result = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(progress);
			transaction.commit();
			result = 1;
			logger.info("insert progress success");
		} catch (Exception e) {
			logger.error("exception");
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public int updateNoteProgress(int transaction_id, String progress, String note) {
		String sql = "update progress set notes = '" + note + "' where id_progress = '" + transaction_id + "' and progress = 'progress-bar-info'";
		int result = 0;
		logger.info(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			result = 1;
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception");
			result = 0;
		}
		return result;
	}

	@Override
	public String timeProgress(int id_progress) {
		StringBuffer sb = new StringBuffer();
		String time = "";
		List<String> list = new ArrayList<>();
		String sql = "select time from progress where progress = 'progress-bar-info' and id_progress = '"+id_progress + "'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			list = query.list();
			time = list.get(0);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	@Override
	public BigInteger countTimeProgress(String time_start, String time_end) {
		BigInteger count_time = new BigInteger("0");
		List<BigInteger> list = new ArrayList<>();
		String sql = "SELECT TIMESTAMPDIFF(MINUTE,STR_TO_DATE('"+time_start+"','%d/%m/%Y %H:%i:%s'), STR_TO_DATE('"+time_end+"','%d/%m/%Y %H:%i:%s'))";
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			list = query.list();
			count_time = list.get(0);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count_time;
	}

	@Override
	public List<BigInteger> listTimeSpaceById_rest(int id_rest) {
		// TODO Auto-generated method stub
		List<BigInteger> listTime = new ArrayList<BigInteger>();
		String sql = "select time_space from progress where id_rest = '" + id_rest + "'";
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			if(query.list().size() == 0){
				listTime = null;
			}else{
				//listTime = query.list();
				for(int i = 0 ; i < query.list().size(); i++){
					listTime.add(new BigInteger(query.list().get(i).toString()));
				}
			}
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listTime;
	}

}
