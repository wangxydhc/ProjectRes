package com.xy.bbs2016.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xy.bbs2016.model.Category;;
public class CategoryAction extends ActionSupport{
	private List<Category> categories;
	public String list(){
		return SUCCESS;
	}
	
}
