package project.thangnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chat_progress")
public class MessageChat {

	@Column(name="id_chat")
	private int id_chat;
	
	
	@Column(name="message_chat")
	private String message_chat;
	@Id
	@Column(name="count_mess")
	private int count_mess;
	
	@Column(name="check_mess")
	private String check_mess;
	
	@Column(name="time_chat")
	private String time_chat;

	public int getId_chat() {
		return id_chat;
	}

	public void setId_chat(int id_chat) {
		this.id_chat = id_chat;
	}

	public String getMessage_chat() {
		return message_chat;
	}

	public void setMessage_chat(String message_chat) {
		this.message_chat = message_chat;
	}

	

	public int getCount_mess() {
		return count_mess;
	}

	public void setCount_mess(int count_mess) {
		this.count_mess = count_mess;
	}

	public String getCheck_mess() {
		return check_mess;
	}

	public void setCheck_mess(String check_mess) {
		this.check_mess = check_mess;
	}
	
	

	public String getTime_chat() {
		return time_chat;
	}

	public void setTime_chat(String time_chat) {
		this.time_chat = time_chat;
	}

	@Override
	public String toString() {
		return "MessageChat [id_chat=" + id_chat + ", message_chat=" + message_chat + ", count_mess=" + count_mess
				+ ", check_mess=" + check_mess + ", time_chat=" + time_chat + "]";
	}

	
	
	
	
	
}
