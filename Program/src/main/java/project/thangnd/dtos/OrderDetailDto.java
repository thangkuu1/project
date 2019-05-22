package project.thangnd.dtos;

import java.util.List;

import project.thangnd.models.Progress;

public class OrderDetailDto {

	private int id_transaction;
	private int id_rest;
	private String name_rest;
	private String price;
	private String tran_stat;
	private List<Progress> listProgress;
	public int getId_transaction() {
		return id_transaction;
	}
	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}
	public int getId_rest() {
		return id_rest;
	}
	public void setId_rest(int id_rest) {
		this.id_rest = id_rest;
	}
	public String getName_rest() {
		return name_rest;
	}
	public void setName_rest(String name_rest) {
		this.name_rest = name_rest;
	}
	public List<Progress> getListProgress() {
		return listProgress;
	}
	public void setListProgress(List<Progress> listProgress) {
		this.listProgress = listProgress;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTran_stat() {
		return tran_stat;
	}
	public void setTran_stat(String tran_stat) {
		this.tran_stat = tran_stat;
	}
	
	
	
	
	
	
	
	
	
	
}
