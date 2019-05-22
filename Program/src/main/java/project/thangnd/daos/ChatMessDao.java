package project.thangnd.daos;

import java.util.List;

import project.thangnd.models.MessageChat;

public interface ChatMessDao {

	public int insertChatMessage(MessageChat mess);
	public List<MessageChat> listMessageChatById(int id_chat);
}
