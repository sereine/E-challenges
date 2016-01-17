package com.util;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadDataRefXML {

	public static Set<String> readDataRefXML(String fileName) throws ParserConfigurationException, SAXException, IOException
	{
		
		Set<String> refs = new HashSet<String>();
		
		File fXmlFile = new File(fileName);
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		doc.getDocumentElement().normalize();
		
		
		NodeList nList = doc.getElementsByTagName("professeur");
		
		
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				
				
				Element eElement = (Element) nNode;
                  
				NodeList firstNameList = eElement.getElementsByTagName("ref");
                Element firstNameElement = (Element)firstNameList.item(0);

                NodeList textFNList = firstNameElement.getChildNodes();
                refs.add(((Node)textFNList.item(0)).getNodeValue().trim());
				
			}
			
			
		
		}
		
	    
		return refs;
		
	}
	
	
}
