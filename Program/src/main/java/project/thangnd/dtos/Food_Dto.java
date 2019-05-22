package project.thangnd.dtos;

import project.thangnd.models.Food;

public class Food_Dto {
	
	public int id_food;
	public String name_food;
	public String image_food;
	public String id_price;
	public String price; //lay gia san pham tu bang change_price;
	public String open_time_food;
	public String status_food;
	public String id_user;
	public String id_discount;
	public String discount_per;// lay ma khuyen mai tu bang discount_food;
	public int count_food ;
	public int total_price_order;
	public int getId_food() {
		return id_food;
	}
	public void setId_food(int id_food) {
		this.id_food = id_food;
	}
	public String getName_food() {
		return name_food;
	}
	public void setName_food(String name_food) {
		this.name_food = name_food;
	}
	public String getImage_food() {
		return image_food;
	}
	public void setImage_food(String image_food) {
		this.image_food = image_food;
	}
	public String getId_price() {
		return id_price;
	}
	public void setId_price(String id_price) {
		this.id_price = id_price;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOpen_time_food() {
		return open_time_food;
	}
	public void setOpen_time_food(String open_time_food) {
		this.open_time_food = open_time_food;
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
	public String getDiscount_per() {
		return discount_per;
	}
	public void setDiscount_per(String discount_per) {
		this.discount_per = discount_per;
	}
	
	public int getCount_food() {
		return count_food;
	}
	public void setCount_food(int count_food) {
		this.count_food = count_food;
	}
	
	public int getTotal_price_order() {
		return total_price_order;
	}
	public void setTotal_price_order(int total_price_order) {
		this.total_price_order = total_price_order;
	}
	@Override
	public String toString() {
		return "Food_Dto [id_food=" + id_food + ", name_food=" + name_food + ", image_food=" + image_food
				+ ", id_price=" + id_price + ", price=" + price + ", open_time_food=" + open_time_food
				+ ", status_food=" + status_food + ", id_user=" + id_user + ", id_discount=" + id_discount
				+ ", discount_per=" + discount_per + ", count_food=" + count_food + ", total_price_order="
				+ total_price_order + "]";
	}
	
	
	
	
	
	
	
	
	
}
