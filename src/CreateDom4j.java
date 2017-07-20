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
		//Dom4j 操作xml 
		String xml=createDocument().asXML().toString();
		try {
			Document document=DocumentHelper.parseText(xml);
			Element root=document.getRootElement();
			for (Iterator i = root.elementIterator(); i.hasNext();) {
				Element type = (Element) i.next();			
				System.out.println("对象名:"+i+"Element:"+type.asXML().toString());
//			System.out.println(type.toString()+"/n");
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
		System.out.println();
		
	}

	public static Document createDocument(){
		Document document=DocumentHelper.createDocument();
		//创建一个document 对象 
		Element root=document.addElement("root");
		
		//addAttribute 节点属性  
//		Element auto1=root.addElement("auto")
//				.addAttribute("name", "张三")
//				.addAttribute("sex", "男");
//		
//		Element auto2=root.addElement("auto")
//				.addAttribute("name", "李四")
//				.addAttribute("sex", "女");
//			
		
		//创建多个节点  list 格式
		//根节点
		Element auto1=root.addElement("auto");
		
		//子节点
		Element list1=auto1.addElement("list").addAttribute("id", "1");					
		Element auto2=list1.addElement("sex").addText("男");	
		Element auto3=list1.addElement("name").addText("张三");
		
		//子节点
		Element list2=auto1.addElement("list").addAttribute("id", "2");				
		Element auto5=list2.addElement("sex").addText("女");	
		Element auto6=list2.addElement("name").addText("李四");
		return document;
	}
}
