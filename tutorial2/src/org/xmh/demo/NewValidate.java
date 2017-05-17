package org.xmh.demo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.*;
public class NewValidate extends ActionSupport{
	private String requiredString;
	public String getRequiredString() {
		return requiredString;
	}
	public void setRequiredString(String requiredString) {
		this.requiredString = requiredString;
	}

	public String execute() {
		FiledError
		requiredString="dafdsf";
		return SUCCESS;
	}
}
