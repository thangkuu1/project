package project.thangd.servers;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.buf.UDecoder;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.util.JSONPObject;

@ServerEndpoint(value="/chatRoomServer/{id_send}/{id_receive}"
/*encoders = {MessageEncoder.class}, decoders = {MessageDecoder.class}*/)
public class ChatRoomServerEndPoint {
	Logger logger = Logger.getLogger(ChatRoomServerEndPoint.class);
	static Set<Session> users = Collections.synchronizedSet(new HashSet<Session>());
	boolean check = true;
	private EndpointConfig epCfg;
//	private EndpointCondig epCfg;
	@OnOpen
	public void handleOpen(Session session, EndpointConfig epCfg, @PathParam("id_send") String id_send){
		if(users.size() == 0){
			users.add(session);
		}else if(users.size() > 0){
			for(Session session1: users){
				if(session1.getUserProperties().get("username").equals(id_send)){
					check = false;
					break;
				}
			}
			if(check == true){
				users.add(session);
			}
		}
		logger.info("all user in websocket: " + users.size());
		session.getUserProperties().put("username", id_send);
		this.epCfg = epCfg;
		this.epCfg.getUserProperties().put(session.getId(), id_send);
		System.out.println(session.getId());
		
		System.out.println(session.getRequestURI() );
		logger.info("id session websocket: " + session.getId());
		logger.info("url request websocket: " + session.getRequestURI());
	}
	@OnMessage
	//Message message
	public void handleMessage(String message, Session userSession, @PathParam("id_receive") String id_receive) 
	throws IOException, EncodeException{
		String username = (String) userSession.getUserProperties().get("username");
		System.out.println("username: " + username);
		for(Session sessison: users){
			if(sessison.getUserProperties().get("username").equals(id_receive)){
				System.out.println("message server send: " + message + "user connect to: " + username  + "id_receive: " + id_receive);
				
				sessison.getBasicRemote().sendText( message );
			}
			logger.info("message: " + message);
		}
	}
	
	@OnClose
	public void hangleClose(Session session){
		users.remove(session);
	}
	
	@OnError
	public void handleError(Throwable t){
		t.printStackTrace();
	}
}
