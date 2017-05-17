import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

//domʵ��
public class Sample1 {

	public static void main(String[] args) throws Exception {
		// step 1:���DOM����������
		// �����������Ǵ�������Ľ�����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// step 2����þ����dom������
		DocumentBuilder db = dbf.newDocumentBuilder();

		// step 3:����һ��xml�ĵ������Document���󣨸��ڵ㣩
		// ���ĵ�������ĿĿ¼�¼���
		Document document = db.parse(new File("src/test.xml"));

		// ���ݱ�ǩ�����ʽڵ�
		NodeList list = document.getElementsByTagName("book");
		System.out.println("list length: " + list.getLength());

		// ����ÿһ���ڵ�
		for (int i = 0; i < list.getLength(); ++i) {
			System.out.println("----------------------");
			// ���Ԫ�أ����ڵ�ǿ��ת��ΪԪ��
			Element element = (Element) list.item(i);
			// ��ʱelement����һ�������Ԫ��

			// ��ȡ��Ԫ�أ���Ԫ��titleֻ��һ���ڵ㣬֮��ͨ��getNodeValue������ȡ�ڵ��ֵ
			String content0 = element.getElementsByTagName("title").item(0)
					.getNodeValue();

			System.out.println(content0);// �˴���ӡ��Ϊnull
			// ��Ϊ�ڵ�getNodeValue��ֵ��ԶΪnull

			// �������������getFirstChild()
			String content = element.getElementsByTagName("title").item(0)
					.getFirstChild().getNodeValue();
			System.out.println("title: " + content);// �˴���ӡ������

			// �������ƴ����ɣ�
			content = element.getElementsByTagName("author").item(0)
					.getFirstChild().getNodeValue();
			System.out.println("author: " + content);
			content = element.getElementsByTagName("year").item(0)
					.getFirstChild().getNodeValue();
			System.out.println("year: " + content);
			content = element.getElementsByTagName("price").item(0)
					.getFirstChild().getNodeValue();
			System.out.println("price: " + content);
		}
	}

}
