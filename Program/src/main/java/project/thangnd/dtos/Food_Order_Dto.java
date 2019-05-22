package project.thangnd.dtos;

import project.thangnd.models.Food;

public class Food_Order_Dto {

	private int id_food;
	private String name_food;
	private String image_food;
	private String price;
	private int count_food;
	private int id_rest;
	
	
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



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public int getCount_food() {
		return count_food;
	}



	public void setCount_food(int count_food) {
		this.count_food = count_food;
	}

	
	

	public int getId_rest() {
		return id_rest;
	}



	public void setId_rest(int id_rest) {
		this.id_rest = id_rest;
	}

	

	@Override
	public String toString() {
		return "Food_Order_Dto [id_food=" + id_food + ", name_food=" + name_food + ", image_food=" + image_food
				+ ", price=" + price + ", count_food=" + count_food + ", id_rest=" + id_rest + "]";
	}



	public void toFood(Food food){
		this.id_food = food.getId_food();
		this.name_food = food.getName_food();
		this.image_food = food.getImage_food();
		this.price = Double.toString(Double.parseDouble(food.getId_price()) - (Double.parseDouble(food.getId_price()) * Double.parseDouble(food.getId_discount()))/100 ) ;
		this.count_food = 1;
		this.id_rest = food.getId_rest();
	}
}
