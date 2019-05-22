package project.thangnd.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.ChatMessDao;
import project.thangnd.models.MessageChat;
import project.thangnd.services.ChatMessageService;

@Service
public class ChatMessageServiceImpl implements ChatMessageService{

	@Autowired
	private ChatMessDao chatMessDao;
	@Override
	public int insertChatMessage(MessageChat mess) {
		// TODO Auto-generated method stub
		return chatMessDao.insertChatMessage(mess);
	}
	@Override
	public List<MessageChat> listMessageChatById(int id_chat) {
		// TODO Auto-generated method stub
		return chatMessDao.listMessageChatById(id_chat);
	}

}
