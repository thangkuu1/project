package project.thangnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rate")
public class Rate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_rate")
	private int id_rate;
	
	@Column(name="id_user")
	private int id_user;
	
	@Column(name="id_rest")
	private int id_rest;
	
	@Column(name="count_rate")
	private int count_rate;
	
	@Column(name="date")
	private String date;
	
	@Column(name="status_rate")
	private String status_rate;

	public int getId_rate() {
		return id_rate;
	}

	public void setId_rate(int id_rate) {
		this.id_rate = id_rate;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_rest() {
		return id_rest;
	}

	public void setId_rest(int id_rest) {
		this.id_rest = id_rest;
	}

	public int getCount_rate() {
		return count_rate;
	}

	public void setCount_rate(int count_rate) {
		this.count_rate = count_rate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus_rate() {
		return status_rate;
	}

	public void setStatus_rate(String status_rate) {
		this.status_rate = status_rate;
	}

	@Override
	public String toString() {
		return "Rate [id_rate=" + id_rate + ", id_user=" + id_user + ", id_rest=" + id_rest + ", count_rate="
				+ count_rate + ", date=" + date + ", status_rate=" + status_rate + "]";
	}
	
	
	
	
	
}
