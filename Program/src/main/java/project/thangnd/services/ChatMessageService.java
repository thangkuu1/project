package project.thangnd.services;

import java.util.List;

import project.thangnd.models.MessageChat;

public interface ChatMessageService {
	
	public int insertChatMessage(MessageChat mess);
	public List<MessageChat> listMessageChatById(int id_chat);

}
