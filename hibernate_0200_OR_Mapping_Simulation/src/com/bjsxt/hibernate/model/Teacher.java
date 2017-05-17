package com.bjsxt.hibernate.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Teacher {
	private int id;
	private String name;
	private String title;
	private String wifename;
	private Date birthDate;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWifename() {
		return wifename;
	}
	public void setWifename(String wifename) {
		this.wifename = wifename;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
