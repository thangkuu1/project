package project.thangnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_rest")
	private int id_rest;
	
	@Column(name="addres_rest")
	private String addres_rest;
	
	@Column(name="name_rest")
	private String name_rest;
	
	@Column(name="time_open")
	private String time_open;
	
	@Column(name="cost_rest")
	private String cost_rest;
	
	@Column(name="status_rest")
	private String status_rest;
	
	@Column(name="kind_rest")
	private String kind_rest;
	
	@Column(name="image_rest")
	private String image_rest;
	
	@Column(name="id_user")
	private int id_user;

	public int getId_rest() {
		return id_rest;
	}

	public void setId_rest(int id_rest) {
		this.id_rest = id_rest;
	}

	public String getAddres_rest() {
		return addres_rest;
	}

	public void setAddres_rest(String addres_rest) {
		this.addres_rest = addres_rest;
	}

	public String getName_rest() {
		return name_rest;
	}

	public void setName_rest(String name_rest) {
		this.name_rest = name_rest;
	}

	public String getTime_open() {
		return time_open;
	}

	public void setTime_open(String time_open) {
		this.time_open = time_open;
	}

	public String getCost_rest() {
		return cost_rest;
	}

	public void setCost_rest(String cost_rest) {
		this.cost_rest = cost_rest;
	}

	public String getStatus_rest() {
		return status_rest;
	}

	public void setStatus_rest(String status_rest) {
		this.status_rest = status_rest;
	}

	public String getKind_rest() {
		return kind_rest;
	}

	public void setKind_rest(String kind_rest) {
		this.kind_rest = kind_rest;
	}

	public String getImage_rest() {
		return image_rest;
	}

	public void setImage_rest(String image_rest) {
		this.image_rest = image_rest;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	@Override
	public String toString() {
		return "Restaurant [id_rest=" + id_rest + ", addres_rest=" + addres_rest + ", name_rest=" + name_rest
				+ ", time_open=" + time_open + ", cost_rest=" + cost_rest + ", status_rest=" + status_rest
				+ ", kind_rest=" + kind_rest + ", image_rest=" + image_rest + ", id_user=" + id_user + "]";
	}

	
	
	
}
