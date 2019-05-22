package project.thangnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cmt")
	private int id_cmt;
	
	@Column(name="content_cmt")
	private String content_cmt;
	
	@Column(name="date")
	private String date;
	
	@Column(name="cmt_status")
	private String cmt_status;
	
	@Column(name="id_user")
	private int id_user;
	
	@Column(name="id_rest")
	private int id_rest;

	public int getId_cmt() {
		return id_cmt;
	}

	public void setId_cmt(int id_cmt) {
		this.id_cmt = id_cmt;
	}

	public String getContent_cmt() {
		return content_cmt;
	}

	public void setContent_cmt(String content_cmt) {
		this.content_cmt = content_cmt;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCmt_status() {
		return cmt_status;
	}

	public void setCmt_status(String cmt_status) {
		this.cmt_status = cmt_status;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_rest() {
		return id_rest;
	}

	public void setId_rest(int id_rest) {
		this.id_rest = id_rest;
	}

	@Override
	public String toString() {
		return "Comment [id_cmt=" + id_cmt + ", content_cmt=" + content_cmt + ", date=" + date + ", cmt_status="
				+ cmt_status + ", id_user=" + id_user + ", id_rest=" + id_rest + "]";
	}

	
	
	
}
