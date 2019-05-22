package project.thangnd.models;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="progress")
public class Progress {
	
	
	@Column(name="id_progress")
	private int id_progress;
	@Id
	@Column(name="progress")
	private String progress;
	
	@Column(name="width")
	private String width;
	
	@Column(name="name_progress")
	private String name_progress;
	
	@Column(name= "step_progress")
	private String step_progress;

	@Column(name = "time")
	private String time;
	
	@Column(name = "distance")
	private String distance;
	
	@Column(name="time_expect")
	private String time_expect;

	@Column(name="notes")
	private String notes;
	
	@Column(name="time_space")
	private BigInteger time_space;
	
	@Column(name="id_rest")
	private int id_rest;
	
	public int getId_progress() {
		return id_progress;
	}

	public void setId_progress(int id_progress) {
		this.id_progress = id_progress;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getName_progress() {
		return name_progress;
	}

	public void setName_progress(String name_progress) {
		this.name_progress = name_progress;
	}

	public String getStep_progress() {
		return step_progress;
	}

	public void setStep_progress(String step_progress) {
		this.step_progress = step_progress;
	}

	
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	
	
	public String getTime_expect() {
		return time_expect;
	}

	public void setTime_expect(String time_expect) {
		this.time_expect = time_expect;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
	
	public BigInteger getTime_space() {
		return time_space;
	}

	public void setTime_space(BigInteger time_space) {
		this.time_space = time_space;
	}
	
	public int getId_rest() {
		return id_rest;
	}

	public void setId_rest(int id_rest) {
		this.id_rest = id_rest;
	}

	@Override
	public String toString() {
		return "Progress [id_progress=" + id_progress + ", progress=" + progress + ", width=" + width
				+ ", name_progress=" + name_progress + ", step_progress=" + step_progress + ", time=" + time
				+ ", distance=" + distance + ", time_expect=" + time_expect + ", notes=" + notes + ", time_space="
				+ time_space + ", id_rest=" + id_rest + "]";
	}

	 
	
	

	

	
	

	

	

}
