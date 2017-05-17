package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class ProNode {
	private int id;
	private int whichTime;
	private String state;
	private Date date;
	private ProNode next;
	
	@OneToOne
	@JoinColumn(name="PronodeTo")
	public ProNode getNext() {
		return next;
	}
	public void setNext(ProNode next) {
		this.next = next;
	}
	public int getWhichTime() {
		return whichTime;
	}
	public void setWhichTime(int whichTime) {
		this.whichTime = whichTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
