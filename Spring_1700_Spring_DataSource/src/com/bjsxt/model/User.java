package com.bjsxt.model;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	private static int num=0;
	private String name;
	@Resource
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(){
		id=num++;
		System.out.println("User "+id+" is created ");
		}
}
