package com.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ReadDataStudentsXML {
   
	public static Set<String> readDataStudentsXML(String fileName) throws ParserConfigurationException, SAXException, IOException
	{
		
		Set<String> emails = new HashSet<String>();
		
		File fXmlFile = new File(fileName);
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		doc.getDocumentElement().normalize();
		
		
		NodeList nList = doc.getElementsByTagName("etudiant");
		
		
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				
				
				Element eElement = (Element) nNode;
                  
				NodeList firstNameList = eElement.getElementsByTagName("email");
                Element firstNameElement = (Element)firstNameList.item(0);

                NodeList textFNList = firstNameElement.getChildNodes();
                emails.add(((Node)textFNList.item(0)).getNodeValue().trim());
				
			}
			
			
		
		}
		
		return emails;
		
	}
	
	
}
