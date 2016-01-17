package com.util;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.xml.sax.SAXException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;





import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
public class QuickPasswordEncodingGenerator {

	public static void main(String[] args) throws MessagingException {
       
		
try {
			
	    Set<String> refs =	ReadDataRefXML.readDataRefXML("C:\\Users\\PC\\Desktop\\Projet JEE\\FilesUpload\\refs.xml");
		
	    Iterator<String> it = refs.iterator();
	    
	    while(it.hasNext())
	    	System.out.println(it.next());
	    
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		/*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	   ctx.register(AppConfig.class);
	   ctx.refresh();
	   JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);
	   MimeMessage mimeMessage = mailSender.createMimeMessage();
   	   MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
   	   mailMsg.setFrom("silamirochdi@gmail.com");
   	   mailMsg.setTo("lotfisilami@gmail.com");
   	   mailMsg.setSubject("Test mail");
   	   mailMsg.setText("Hello World!");
	   mailSender.send(mimeMessage);
	   System.out.println("---Done---");
		*/
		/*
		SecureRandom random = new SecureRandom();
		System.out.println(new BigInteger(30, random).toString(32));
		
		*/
		/*
		try {
			
			ReadDataStudentsXML.readDataStudentsXML("C:\\Users\\PC\\Desktop\\Projet JEE\\FilesUpload\\classe.xml");
		
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}*/
		
		/*
			String password = "admin";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			System.out.println(passwordEncoder.encode(password));
		*/
	
		/*
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest.post("https://hackerrank-hackerrank.p.mashape.com/https://api.hackerrank.com/checker/submission.json?api_key=")
					  .header("X-Mashape-Key", "<required>")
					  .header("Content-Type", "application/x-www-form-urlencoded")
					  .header("Accept", "application/json") 
					  .field("callback_url", "https://mywebsite.com/responseHandler")
					  .field("format", "json")
					  .field("lang", 8)
					  .field("source", "puts 'Hello World'")
					  .field("testcases", "[\"This is input 1\", \"This is input 2\"]")
					  .field("wait", false)
					  .asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
