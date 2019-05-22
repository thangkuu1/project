package project.thangnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post_location")
public class Location {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_post_l")
	private int id_post_l;
	
	@Column(name="content_post_l")
	private String content_post_l;
	
	@Column(name="image_l")
	private String image_l;
	
	@Column(name="location_l")
	private String location_l;
	
	@Column(name="date_time")
	private String date_time;
	
	@Column(name="count_like")
	private String count_like;
	
	@Column(name="l_status")
	private String l_status;
	
	@Column(name="user_id")
	private String user_id;

	public int getId_post_l() {
		return id_post_l;
	}

	public void setId_post_l(int id_post_l) {
		this.id_post_l = id_post_l;
	}

	public String getContent_post_l() {
		return content_post_l;
	}

	public void setContent_post_l(String content_post_l) {
		this.content_post_l = content_post_l;
	}

	public String getImage_l() {
		return image_l;
	}

	public void setImage_l(String image_l) {
		this.image_l = image_l;
	}

	public String getLocation_l() {
		return location_l;
	}

	public void setLocation_l(String location_l) {
		this.location_l = location_l;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public String getCount_like() {
		return count_like;
	}

	public void setCount_like(String count_like) {
		this.count_like = count_like;
	}

	public String getL_status() {
		return l_status;
	}

	public void setL_status(String l_status) {
		this.l_status = l_status;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}
