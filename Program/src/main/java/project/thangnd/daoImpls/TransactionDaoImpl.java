package project.thangnd.daoImpls;

import project.thangnd.models.Trans;
import project.thangnd.models.Transaction_detail;

import static org.hamcrest.CoreMatchers.instanceOf;

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

import com.mysql.fabric.xmlrpc.base.Array;

import project.thangnd.daos.TransactionDao;
import project.thangnd.dtos.TransactionDetailDto;

@Repository
@Transactional
public class TransactionDaoImpl implements TransactionDao {
	
	Logger logger = Logger.getLogger(TransactionDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int inserTransaction(Trans trans) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("TransactionDaoImpl #insertTransaction");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(trans);
			transaction.commit();
			result = 1;
			sb.append("\t insert transaction success");
		} catch (Exception e) {
//			System.out.println("TransactionDaoImpl #insertTransaction error");
			logger.error("exception");
			e.printStackTrace();
			result = 0;
			// TODO: handle exception
		}
		logger.info(sb);
		return result;
	}

	@Override
	public List<Trans> listTransByIdRest(int id_rest) {
		StringBuffer sb = new StringBuffer();
		List<Trans> list_trans = new ArrayList<>();
		String sql = "select * from transaction where id_rest = '" + id_rest + "'" ;
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Trans.class);
			list_trans = query.list();
			transaction.commit();
			sb.append("\t list transaction by id restaurant success");
		} catch (Exception e) {
			e.printStackTrace();
			list_trans = null;
			logger.error("exception");
		}
		logger.info(sb);
		return list_trans;
	}

	@Override
	public Trans getTransById(int id_trans) {
		Trans trans = new Trans();
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			trans = (Trans) session.load(Trans.class, id_trans);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error");
		}
		return trans;
	}

	@Override
	public List<Trans> listTransByIdUser(int id_user, String tran_stat) {
		List<Trans> list_trans = new ArrayList<>();
		String sql ="";
		if(tran_stat.contains("Đặt hàng")){
			sql = "select * from transaction where id_user = '" + id_user + "' and (tran_stat = 'Đặt hàng' or tran_stat = 'Đang làm món ăn' or tran_stat = 'Đang giao hàng') order by id_transaction desc";
		}
		else if(tran_stat.contains("Hoàn thành")){
			sql = "select * from transaction where id_user = '" + id_user + "' and (tran_stat = 'Hoàn thành') order by id_transaction desc";
		}
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Trans.class);
			list_trans = query.list();
			transaction.commit();
			logger.info("list transaction by is_user success");
		} catch (Exception e) {
			e.printStackTrace();
			list_trans = null;
			logger.error("exception");
		}
		return list_trans;
	}

	@Override
	public int updateTrans(int id_trans, String trans_stat) {
		int result = 0;
		String sql = "update transaction set tran_stat = '" + trans_stat + "' where id_transaction = '"+ id_trans + "'";
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			result = query.executeUpdate();
			transaction.commit();
			logger.info("update tran stat success");
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
			logger.error("exception");
		}
		return result;
	}

	@Override
	public Double sumPriceTrans(int rest) {
		Double price_total = 0.0;
		List<Double> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		String sql = "select sum(price) from transaction where id_rest = '" + rest +"'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			list = query.list();
			logger.info("price total: " + list.get(0));
			price_total = list.get(0);
			transaction.commit();
			sb.append("\t sum price transaction success");
		} catch (Exception e) {
			e.printStackTrace();
			price_total = 0.0;
			logger.error("exception");
		}
		logger.info(sb);
		return price_total;
	}

	@Override
	public BigInteger countTransactionByDate(String date, int rest) {
		BigInteger countTrans = new BigInteger("0");
		List<BigInteger> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		String sql = "select count(id_transaction) from transaction where date like '%" + date + "%' and id_rest = '" + rest + "'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			list = query.list();
			countTrans = list.get(0);
			sb.append("\t count transaction by date success");
			transaction.commit();
		} catch (Exception e) {
			logger.error("exception");
			countTrans = new BigInteger("0");
			e.printStackTrace();
		}
		logger.info(sb);
		return countTrans;
	}

	@Override
	public BigInteger countTransaction(int rest) {
		BigInteger countTrans = new BigInteger("0");
		StringBuffer sb = new StringBuffer();
		List<BigInteger> list = new ArrayList<>();
		String sql = "select count(id_transaction) from transaction where id_rest = '" + rest + "'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			list = query.list();
			countTrans = list.get(0);
			sb.append("\t count transaction success");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			countTrans = new BigInteger("0");
			logger.error("exception");
		}
		logger.info(sb);
		return countTrans;
	}

	@Override
	public Double sumPriceTransByDate(String date, int rest) {
		Double total_price = 0.0;
		List<Double> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		String sql = "select sum(price) from transaction where date like'%" + date + "%' and id_rest = '" + rest + "'";
		sb.append(sql); 
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			list = query.list();
			total_price = list.get(0);
			transaction.commit();
			sb.append("/t sum price in table transaction by date success ");
		} catch (Exception e) {
			e.printStackTrace();
			total_price = 0.0;
			logger.error("exception");
		}
		logger.info(sb);
		return total_price;
	}

	@Override
	public List<Transaction_detail> listTrans(String start_date, String end_date, int rest) {
		List<Transaction_detail> listTrans = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		String sql = "select transaction_id, id_food, count(quantum) as quantum from transaction_detail, transaction where (transaction.date between '"+start_date + "' and '" + end_date + "')" +
					"and transaction.id_transaction = transaction_detail.transaction_id and transaction.id_rest = '" + rest + "' group by transaction_detail.id_food ;";
		sb.append(sb);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Transaction_detail.class);
			listTrans = query.list();
			sb.append("\t list transaction detail by start date, end date and rest");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			listTrans = null;
			logger.error("exception");
		}
		logger.info(sb);
		return listTrans;
	}
	

}
