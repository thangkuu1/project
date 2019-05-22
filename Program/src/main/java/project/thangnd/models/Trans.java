package project.thangnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Trans {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_transaction")
	private int id_transaction;
	
	@Column(name="id_user")
	private String id_user;
	
	@Column(name="price")
	private String price;
	
	@Column(name="date")
	private String date;
	
	@Column(name="tran_stat")
	private String tran_stat;

	@Column(name="address")
	private String address;
	
	@Column(name="id_rest")
	private int id_rest;
	
	public int getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTran_stat() {
		return tran_stat;
	}

	public void setTran_stat(String tran_stat) {
		this.tran_stat = tran_stat;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getId_rest() {
		return id_rest;
	}

	public void setId_rest(int id_rest) {
		this.id_rest = id_rest;
	}

	@Override
	public String toString() {
		return "Trans [id_transaction=" + id_transaction + ", id_user=" + id_user + ", price=" + price + ", date="
				+ date + ", tran_stat=" + tran_stat + ", address=" + address + ", id_rest=" + id_rest + "]";
	}

	

	

	
	
}
