package com.day19;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Test1 {

	public static void main(String[] args) {
		
		try {//�ܺ����� �о���Ƿ� try�� ����
			
			//DOM Document ��ü�� �����ϱ� ���� ���丮 ����
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance(); //newInstance static�޼ҵ�. ��ü������ �Ǽ� �ҷ���.
			DocumentBuilder parser = f.newDocumentBuilder();
			
			Document xmlDoc = null;
			
			String url = "bookList.xml"; 			//xml������ ��ǻ� ���ͳ����� ����� �������� ����. �� ������ �������� ���ؼ��� url �ʿ�
			
			if(url.indexOf("http://")!=-1){			//�������� �ִٸ� ����
				
				URL u = new URL(url);
				InputStream is = u.openStream();	//��Ʈ������
				xmlDoc = parser.parse(is);			//
			
			}else{
			
				xmlDoc = parser.parse(url);//���ÿ� �ִٸ� ����
				
			}
			
			//Element : xml������ ��Ҹ� ǥ���ϱ� ���� ���
			Element root = xmlDoc.getDocumentElement();
			//System.out.println(root.getTagName()); //bookList
			
			//ù��°book
			//Node : �� ��Ҹ� �а� ���� ���� ���
			Node book1 = root.getElementsByTagName("book").item(0);
			System.out.println(((Element)book1).getAttribute("kind"));
			
			//getNextSibling() ������ ���� ���, getPreviousSibling()���� ���� ���
			
			Node title = book1.getFirstChild();//ù��° å�� ù��° �ڽĳ�� 
			Node title1 = title.getNextSibling();
			System.out.println(title.getNodeName()); //#text
			System.out.println(title1.getNodeName());//tag > title �о��
			
			Node title1_1 = title1.getFirstChild();
			System.out.println(title1_1.getNodeValue());
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
