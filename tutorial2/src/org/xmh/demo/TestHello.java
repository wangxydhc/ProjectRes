package org.xmh.demo;
import junit.framework.TestCase;
import com.opensymphony.xwork2.ActionSupport;
public class TestHello extends TestCase {
	
public void testHelloWorld() throws Exception {
HelloWorld hello_world = new HelloWorld();
String result = hello_world.execute();
assertTrue(ActionSupport.SUCCESS
.equals(result));
}
}
