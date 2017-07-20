import java.util.Iterator;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class CreateDom4j {

	public static void main(String[] args) {
		//Dom4j ����xml 
		String xml=createDocument().asXML().toString();
		try {
			Document document=DocumentHelper.parseText(xml);
			Element root=document.getRootElement();
			for (Iterator i = root.elementIterator(); i.hasNext();) {
				Element type = (Element) i.next();			
				System.out.println("������:"+i+"Element:"+type.asXML().toString());
//			System.out.println(type.toString()+"/n");
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
		System.out.println();
		
	}

	public static Document createDocument(){
		Document document=DocumentHelper.createDocument();
		//����һ��document ���� 
		Element root=document.addElement("root");
		
		//addAttribute �ڵ�����  
//		Element auto1=root.addElement("auto")
//				.addAttribute("name", "����")
//				.addAttribute("sex", "��");
//		
//		Element auto2=root.addElement("auto")
//				.addAttribute("name", "����")
//				.addAttribute("sex", "Ů");
//			
		
		//��������ڵ�  list ��ʽ
		//���ڵ�
		Element auto1=root.addElement("auto");
		
		//�ӽڵ�
		Element list1=auto1.addElement("list").addAttribute("id", "1");					
		Element auto2=list1.addElement("sex").addText("��");	
		Element auto3=list1.addElement("name").addText("����");
		
		//�ӽڵ�
		Element list2=auto1.addElement("list").addAttribute("id", "2");				
		Element auto5=list2.addElement("sex").addText("Ů");	
		Element auto6=list2.addElement("name").addText("����");
		return document;
	}
}
