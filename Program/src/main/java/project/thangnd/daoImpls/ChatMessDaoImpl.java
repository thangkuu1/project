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

import project.thangnd.daos.ChatMessDao;
import project.thangnd.models.MessageChat;

@Repository
@Transactional
public class ChatMessDaoImpl implements ChatMessDao {

	Logger logger = Logger.getLogger(ChatMessDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insertChatMessage(MessageChat mess) {
		int result = 0;
		StringBuffer sb = new StringBuffer();
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(mess);
			transaction.commit();
			result = 1;
			sb.append("insert chat message success");
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
			logger.error("exception");
		}
		logger.info(sb);
		return result;
	}

	@Override
	public List<MessageChat> listMessageChatById(int id_chat) {
		List<MessageChat> listMess = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		String sql = "select * from chat_progress where id_chat = '" + id_chat + "' order by count_mess asc";
		sb.append(sql);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(MessageChat.class);
			listMess = query.list();
			for(MessageChat mess: listMess){
				logger.info("mess dao: " + mess);
			}
			sb.append("\t select chat progress by id chat success");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception");
			listMess = null;
		}
		return listMess;
	}

}
