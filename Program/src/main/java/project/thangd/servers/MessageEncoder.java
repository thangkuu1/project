package project.thangd.servers;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class MessageEncoder implements Encoder.Text<Message> {

	Gson gson = new Gson();
	
	@Override
	public void destroy() {
		System.out.println("MessageEncoder - destroy method called");
	}

	@Override
	public void init(EndpointConfig arg0) {
		System.out.println("MessageEncoder - init method called");
		
	}

	@Override
	public String encode(Message message) throws EncodeException {
		return gson.toJson(message);
	}

}
