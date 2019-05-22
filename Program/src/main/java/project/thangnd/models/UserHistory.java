package project.thangnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history_user")
public class UserHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_history")
	private int id_history;
	
	@Column(name = "session_id")
	private String session_id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="pc_ip")
	private String pc_ip;

	public int getId_history() {
		return id_history;
	}

	public void setId_history(int id_history) {
		this.id_history = id_history;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPc_ip() {
		return pc_ip;
	}

	public void setPc_ip(String pc_ip) {
		this.pc_ip = pc_ip;
	}
	
	
}
