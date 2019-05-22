package project.thangnd.dtos;

import java.math.BigInteger;

public class Restaurant_Info {
	
	private int id_rest;
	private String name_rest;
	private String address_rest;
	private String image_rest;
	private float rate_rest;
	private BigInteger count_cmt;
	private String kind_rest;
	private Double sum_discount;
	private int time_space;
	
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
	public String getAddress_rest() {
		return address_rest;
	}
	public void setAddress_rest(String address_rest) {
		this.address_rest = address_rest;
	}
	public String getImage_rest() {
		return image_rest;
	}
	public void setImage_rest(String image_rest) {
		this.image_rest = image_rest;
	}
	public float getRate_rest() {
		return rate_rest;
	}
	public void setRate_rest(float rate_rest) {
		this.rate_rest = rate_rest;
	}
	
	public BigInteger getCount_cmt() {
		return count_cmt;
	}
	public void setCount_cmt(BigInteger count_cmt) {
		this.count_cmt = count_cmt;
	}
	public String getKind_rest() {
		return kind_rest;
	}
	public void setKind_rest(String kind_rest) {
		this.kind_rest = kind_rest;
	}
	
	
	
	public Double getSum_discount() {
		return sum_discount;
	}
	public void setSum_discount(Double sum_discount) {
		this.sum_discount = sum_discount;
	}
	
	
	
	public int getTime_space() {
		return time_space;
	}
	public void setTime_space(int time_space) {
		this.time_space = time_space;
	}
	@Override
	public String toString() {
		return "Restaurant_Info [id_rest=" + id_rest + ", name_rest=" + name_rest + ", address_rest=" + address_rest
				+ ", image_rest=" + image_rest + ", rate_rest=" + rate_rest + ", count_cmt=" + count_cmt
				+ ", kind_rest=" + kind_rest + ", sum_discount=" + sum_discount + ", time_space=" + time_space + "]";
	}
	
	
	
	
	
	

	

}
