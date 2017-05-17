package com.bjsxt.spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.bjsxt.model.User;
import com.bjsxt.service.UserService;

public class ClassPathXmlApplicationContext implements BeanFactory {
	private Map<String,Object> beans=new HashMap<String,Object>();
	public ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build("src/Copy of beans.xml");
		Element root = doc.getRootElement();
		List list = root.getChildren("bean");
		for (int i = 0; i < list.size(); i++) {
			Element element = (Element) list.get(i);
			String id=element.getAttributeValue("id");
			String _class=element.getAttributeValue("class");
			System.out.println(id+":"+_class);
			Object objectA=Class.forName(_class).newInstance();
			beans.put(id, objectA);
			for(Element propertyElement:(List<Element>)element.getChildren("property")){
				String nameC=propertyElement.getAttributeValue("name");
				System.out.println("方法名:"+nameC);
				String nameB=propertyElement.getAttributeValue("bean");
				System.out.println("要设置的参数名：" +nameB);
				Object objectB=beans.get(nameB);
				System.out.println("要设置的参数这个对象："+objectB);
				
				String methodName="set"+nameC.substring(0, 1).toUpperCase()+nameC.substring(1);	
				
				System.out.println("method name= "+methodName);
				
				Method m=objectA.getClass().getMethod(methodName, objectB.getClass().getInterfaces()[0]);
				System.out.println("接口名："+objectB.getClass().getInterfaces()[0]);
				m.invoke(objectA,objectB);
			}
		}
	}

	@Override
	public Object getBean(String name) {		
		return beans.get(name);
	}
	public static void main(String[] args) throws Exception {
		BeanFactory a=new ClassPathXmlApplicationContext();
		UserService u=(UserService)a.getBean("userService");
		User s=new User();
		u.add(s);
	}
}
