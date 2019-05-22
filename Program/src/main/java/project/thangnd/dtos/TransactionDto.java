package project.thangnd.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TransactionDto {
	
	
	private int id_transaction;
	
	private String id_user;
	
	private String price;
	
	private String date;
	
	private String tran_stat;

	private String address;
	
	private int id_rest;
	
	private String name_user;

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

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	@Override
	public String toString() {
		return "TransactionDto [id_transaction=" + id_transaction + ", id_user=" + id_user + ", price=" + price
				+ ", date=" + date + ", tran_stat=" + tran_stat + ", address=" + address + ", id_rest=" + id_rest
				+ ", name_user=" + name_user + "]";
	}
	
	

}
