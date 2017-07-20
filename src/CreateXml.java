import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXml {

	public static void main(String[] args) {
		//DOM 生成xml	
		try {
			
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder documentbuilder=factory.newDocumentBuilder();	
			Document document= documentbuilder.newDocument();
			
			//根标签的创建
			Element root =document.createElement("Languages");
			root.setAttribute("cat", "it");
			
			Element lan1 =document.createElement("lan");
			lan1.setAttribute("id", "1");		
			Element ide1 =document.createElement("ide");
			ide1.setTextContent("eclipse");
			Element name1 =document.createElement("name");
			name1.setTextContent("java");
			
			lan1.appendChild(ide1);
			lan1.appendChild(name1);
			root.appendChild(lan1);
			
			Element lan2 =document.createElement("lan");
			lan2.setAttribute("id", "2");		
			Element ide2 =document.createElement("ide");
			ide2.setTextContent("plsql");
			Element name2 =document.createElement("name");
			name2.setTextContent("oracle");
			
			lan2.appendChild(ide2);
			lan2.appendChild(name2);
			root.appendChild(lan2);
			
			document.appendChild(root);
			//---------------对象创建完毕 开始输出 
			TransformerFactory transformerfactory=TransformerFactory.newInstance();
			Transformer transformer=transformerfactory.newTransformer();
//			StringWriter write=new StringWriter();
			transformer.transform(new DOMSource(document),new StreamResult(new File("xmlss.xml")));
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}	
		
	}

}
