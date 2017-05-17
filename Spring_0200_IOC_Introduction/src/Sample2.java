import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


//Jdom实现
public class Sample2 {

	public static void main(String[] args) throws Exception {
		SAXBuilder sb=new SAXBuilder();
		Document doc=sb.build("src/test.xml");
		Element root=doc.getRootElement();
		List list=root.getChildren("book");
		for(int i=0;i<list.size();i++){
			Element element=(Element)list.get(i);
			String name=element.getAttributeValue("category");
			String title=element.getChildText("title");
			String author=element.getChildText("author");
			String year=element.getChildText("year");
			String price=element.getChildText("price");
			System.out.println("书籍信息");
			System.out.println("类型："+name);
			System.out.println("书名："+title);
			System.out.println("作者："+author);
			System.out.println("出版日期："+year);
			System.out.println("价格："+price);
			System.out.println();
			
		}
	}
}
