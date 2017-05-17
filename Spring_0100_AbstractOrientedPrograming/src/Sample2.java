import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


//Jdomʵ��
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
			System.out.println("�鼮��Ϣ");
			System.out.println("���ͣ�"+name);
			System.out.println("������"+title);
			System.out.println("���ߣ�"+author);
			System.out.println("�������ڣ�"+year);
			System.out.println("�۸�"+price);
			System.out.println();
			
		}
	}
}
