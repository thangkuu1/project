package project.thangnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_post")
public class Food {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_food")
	private int id_food;
	
	@Column(name="image_food")
	private String image_food;
	
	@Column(name="name_food")
	private String name_food;
	
	
	@Column(name="id_price")
	private String id_price;
	
	
	@Column(name="status_food")
	private String status_food;
	
	@Column(name="id_user")
	private String id_user;
	
	@Column(name="id_discount")
	private String id_discount;
	
	@Column(name="id_rest")
	private int id_rest;

	@Column(name="time_work")
	private String time_work;
	
	public int getId_food() {
		return id_food;
	}

	public String getImage_food() {
		return image_food;
	}

	public void setImage_food(String image_food) {
		this.image_food = image_food;
	}

	public String getName_food() {
		return name_food;
	}

	public void setName_food(String name_food) {
		this.name_food = name_food;
	}

	public String getId_price() {
		return id_price;
	}

	public void setId_price(String id_price) {
		this.id_price = id_price;
	}

	public String getStatus_food() {
		return status_food;
	}

	public void setStatus_food(String status_food) {
		this.status_food = status_food;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getId_discount() {
		return id_discount;
	}

	public void setId_discount(String id_discount) {
		this.id_discount = id_discount;
	}

	public int getId_rest() {
		return id_rest;
	}

	public void setId_rest(int id_rest) {
		this.id_rest = id_rest;
	}

	public void setId_food(int id_food) {
		this.id_food = id_food;
	}

	
	
	public String getTime_work() {
		return time_work;
	}

	public void setTime_work(String time_work) {
		this.time_work = time_work;
	}

	@Override
	public String toString() {
		return "Food [id_food=" + id_food + ", image_food=" + image_food + ", name_food=" + name_food + ", id_price="
				+ id_price + ", status_food=" + status_food + ", id_user=" + id_user + ", id_discount=" + id_discount
				+ ", id_rest=" + id_rest + ", time_work=" + time_work + "]";
	}

	

}