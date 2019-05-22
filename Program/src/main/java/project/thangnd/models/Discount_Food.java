package project.thangnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discount_food")
public class Discount_Food {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_discount")
	private int id_discount;
	
	@Column(name="per_discount")
	private String per_discount;
	
	@Column(name="content_discount")
	private String content_discount;

	@Column(name="discount_status")
	private String discount_status;
	
	@Column(name="id_user")
	private int id_user;
	
	@Column(name="id_food")
	private int id_food;

	

	public int getId_discount() {
		return id_discount;
	}

	public void setId_discount(int id_discount) {
		this.id_discount = id_discount;
	}

	public String getPer_discount() {
		return per_discount;
	}

	public void setPer_discount(String per_discount) {
		this.per_discount = per_discount;
	}

	public String getContent_discount() {
		return content_discount;
	}

	public void setContent_discount(String content_discount) {
		this.content_discount = content_discount;
	}

	public String getDiscount_status() {
		return discount_status;
	}

	public void setDiscount_status(String discount_status) {
		this.discount_status = discount_status;
	}

	
	
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	

	public int getId_food() {
		return id_food;
	}

	public void setId_food(int id_food) {
		this.id_food = id_food;
	}

	@Override
	public String toString() {
		return "Discount_Food [id_discount=" + id_discount + ", per_discount=" + per_discount + ", content_discount="
				+ content_discount + ", discount_status=" + discount_status + ", id_user=" + id_user + ", id_food="
				+ id_food + "]";
	}

	

	
	
	
	
	
}
