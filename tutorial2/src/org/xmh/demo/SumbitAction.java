package org.xmh.demo;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
public class SumbitAction extends ActionSupport implements
ServletRequestAware {
private String msg;
private javax.servlet.http.HttpServletRequest request;
// ���HttpServletRequest����
public void setServletRequest(HttpServletRequest request) {
this.request = request;
}
// ����save submit��ť�Ķ���
public String save() throws Exception {
request.setAttribute("result", "�ɹ�����[" + msg + "]");
return "save";
}
// ����print submit��ť�Ķ���
public String print() throws Exception {
request.setAttribute("result", "�ɹ���ӡ[" + msg + "]");
return "print";
}
public String getMsg() {
return msg;
}
public void setMsg(String msg) {
this.msg = msg;
}
}
