package project.thangd.servers;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class MessageDecoder implements Decoder.Text<Message> {

	Gson gson = new Gson();
	
	@Override
	public void destroy() {
		 System.out.println("MessageDecoder - destroy method called");
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		System.out.println("MessageDecoder -init method called");
		
	}

	@Override
	public Message decode(String jsonMessage) throws DecodeException {
		return gson.fromJson(jsonMessage, Message.class);
	}

	@Override
	public boolean willDecode(String jsonMessage) {
		return (jsonMessage != null);
	}
	

}
