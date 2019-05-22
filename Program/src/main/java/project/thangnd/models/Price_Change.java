package project.thangnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="change_price")
public class Price_Change {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_price")
	private int id_price;
	
	@Column(name="price_new")
	private String price_new;
	
	@Column(name="date")
	private String date;
	
	@Column(name="price_status")
	private String price_status;
	
	@Column(name="detail")
	private String detail;
	
	@Column(name="id_food")
	private int id_food;

	@Column(name="id_user")
	private int id_user;

	

	public int getId_price() {
		return id_price;
	}

	public void setId_price(int id_price) {
		this.id_price = id_price;
	}

	public String getPrice_new() {
		return price_new;
	}

	public void setPrice_new(String price_new) {
		this.price_new = price_new;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrice_status() {
		return price_status;
	}

	public void setPrice_status(String price_status) {
		this.price_status = price_status;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getId_food() {
		return id_food;
	}

	public void setId_food(int id_food) {
		this.id_food = id_food;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	@Override
	public String toString() {
		return "Price_Change [id_price=" + id_price + ", price_new=" + price_new + ", date=" + date + ", price_status="
				+ price_status + ", detail=" + detail + ", id_food=" + id_food + ", id_user=" + id_user + "]";
	}
	
	
	
	
}
