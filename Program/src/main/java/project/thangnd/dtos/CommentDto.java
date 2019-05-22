package project.thangnd.dtos;

public class CommentDto {

	private int id_cmt;
	private String date;
	private String content_cmt;
	private String id_user;
	private String id_food;
	private String id_rest;
	private String image_user;
	private String username;
	
	public int getId_cmt() {
		return id_cmt;
	}
	public void setId_cmt(int id_cmt) {
		this.id_cmt = id_cmt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent_cmt() {
		return content_cmt;
	}
	public void setContent_cmt(String content_cmt) {
		this.content_cmt = content_cmt;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getId_food() {
		return id_food;
	}
	public void setId_food(String id_food) {
		this.id_food = id_food;
	}
	public String getImage_user() {
		return image_user;
	}
	public void setImage_user(String image_user) {
		this.image_user = image_user;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getId_rest() {
		return id_rest;
	}
	public void setId_rest(String id_rest) {
		this.id_rest = id_rest;
	}
	@Override
	public String toString() {
		return "CommentDto [id_cmt=" + id_cmt + ", date=" + date + ", content_cmt=" + content_cmt + ", id_user="
				+ id_user + ", id_food=" + id_food + ", id_rest=" + id_rest + ", image_user=" + image_user
				+ ", username=" + username + "]";
	}
	
	
	
}
