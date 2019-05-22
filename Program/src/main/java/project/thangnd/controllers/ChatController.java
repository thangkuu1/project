package project.thangnd.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import project.thangnd.models.MessageChat;
import project.thangnd.services.ChatMessageService;

@Controller
public class ChatController {
	Logger logger = Logger.getLogger(ChatController.class);
	@Autowired
	private ChatMessageService chatMessService;
	
	@RequestMapping(value = "insertchat")
	public @ResponseBody Map<String, Object> insertChatMess(@RequestParam("data_mess") String data_mess){
		logger.info("data message chat: " + data_mess);
		//1.1 convert json to object MessageChat
		Gson gson = new Gson();
		MessageChat mess_chat = gson.fromJson(data_mess, MessageChat.class);
		List<MessageChat> listMess = new ArrayList<>();
		//1.2 check count message if count_mess = 0 
		listMess = chatMessService.listMessageChatById(mess_chat.getId_chat());
		if(listMess.size() == 0){
			mess_chat.setCount_mess(0);
		}else if(listMess.size() > 0){
			mess_chat.setCount_mess(listMess.size() + 1);
		}
		//1.3 insert Message in table chat_progress
		chatMessService.insertChatMessage(mess_chat);
		return null;
	}

}
