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

import project.thangnd.daos.CommentDao;
import project.thangnd.models.Comment;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {
	Logger logger = Logger.getLogger(CommentDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public int insertComment(Comment cmt) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("CommentDaoImpl #insertComment ");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(cmt);
			transaction.commit();
			result = 1;
			sb.append("insert comment success" );
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
//			System.out.println("CommentDaoImpl #insetComment error");
			logger.error("CommentDaoImpl #insetComment error");
		}
		logger.info(sb);
		return result;
	}


	@Override
	public List<Comment> listComment(int id_rest) {
		List<Comment> list_cmt = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		String sql = "select * from comment where id_rest = '" + id_rest + "'";
		sb.append("CommentDaoImpl #listComment " );
		sb.append("\t" + sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
//			list_cmt = session.createQuery("from Comment").list();
			Query query = session.createSQLQuery(sql).addEntity(Comment.class);
			list_cmt = query.list();
			transaction.commit();
			sb.append("ListComment: " +list_cmt.size());
		} catch (Exception e) {
			e.printStackTrace();
			list_cmt = null;
//			System.out.println("CommentDaoImpl #listComment error");
			sb.append("/t exception ");
		}
//		System.out.println(sb);
		logger.info(sb);
		return list_cmt;
	}


	@Override
	public BigInteger countComment(int id_rest) {
		StringBuffer sb = new StringBuffer();
		BigInteger count = new BigInteger("0");
		List<BigInteger> list = new ArrayList<>();
		String sql = "select count(id_cmt) from comment where id_rest = '" + id_rest + "'";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			list = query.list();
			count = list.get(0);
			transaction.commit();
			sb.append("\t count comment success");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exeption");
			count = new BigInteger("0");
		}
		logger.info(sb);
		return count;
	}

}
