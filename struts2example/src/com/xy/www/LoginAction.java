package com.xy.www;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("convention-default")
@Namespace("/")
@ResultPath(value="/")
@Result(name="success",location="/login.jsp")
public class LoginAction extends ActionSupport{

}