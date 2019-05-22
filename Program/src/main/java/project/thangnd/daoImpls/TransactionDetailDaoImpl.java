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


import project.thangnd.daos.TransactionDetailDao;
import project.thangnd.models.Transaction_detail;

@Repository
@Transactional
public class TransactionDetailDaoImpl implements TransactionDetailDao {

	Logger logger = Logger.getLogger(TransactionDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insertTransactionDetail(Transaction_detail trans_detail) {
		int result = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(trans_detail);
			transaction.commit();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public List<Transaction_detail> listTransactionDetail(int transaction_id) {
		// TODO Auto-generated method stub
		List<Transaction_detail> listTrans = new ArrayList<>();
		String sql = "SELECT * FROM datn_20182_v1.transaction_detail where transaction_id =" + transaction_id ;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Transaction_detail.class);
			listTrans = query.list();
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listTrans;
	}

	@Override
	public int updateTransactionByTransStat(int transaction_id, int id_food) {
		StringBuffer sb = new StringBuffer();
		int result = 0;
		String sql = "update transaction_detail set trans_stat = '1' where transaction_id = '" + transaction_id + "' and id_food = '" + id_food + "'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			result = 1;
			sb.append("update transaction_detail by transaction_id and id food success");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception");
			result = 0;
		}
		logger.info(sb);
		return result;
	}

	
	
	
	
}
