package com.service;

import com.service.classe.*;
import com.util.AppConfig;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.etudiant.EtudiantDao;
import com.model.Classe;
import com.model.Compte;
import com.model.Etablissement;
import com.model.Etudiant;
import com.model.Professeur;



@Service("etudiantService")
@Transactional
public class EtudiantServiceImpl implements EtudiantService  {
	
		
		@Autowired
		private EtudiantDao dao;
		@Autowired
		private CompteService compteService;
		@Autowired
		private ClasseService classeService;
		
		public void save(Etudiant etudiant){
						
			dao.save(etudiant);
		}
			
		
		
		public Etudiant findById(int id) {
			return (Etudiant) dao.findById(id);
		}

		public Etudiant findBySso(String sso) {
			return null;
		}



		@Override
		public void inscriptionEtudiants(Set<String> emails, String nomClasse, Professeur prof, Etablissement etab) {
            
			Iterator<String> list = emails.iterator();
			
			Classe classe = new Classe();
			
			classe.setNbrEtudiants(emails.size());
			classe.setNom(nomClasse);
			classe.setEtablissement(etab);
			classe.getClasseProfs().add(prof);
			
			classeService.save(classe);
			
			while(list.hasNext())
			{
				String email = list.next();
				
				Compte compte = new Compte();
				
				SecureRandom random = new SecureRandom();
				
				String password = new BigInteger(30, random).toString(32);
				String ssoid = email.split("@")[0];
				
				compte.setPassword(password);
				compte.setSsoId(ssoid);
				
				compteService.save(compte);
				
				Etudiant etudiant = new Etudiant();
				
				etudiant.setCne("null");
				etudiant.setEmail(email);
				etudiant.setFirstName("null");
				etudiant.setLastName("null");
				etudiant.setTel("0555555555");
				
				etudiant.setCompte(compte);
				etudiant.setClasse(classe);
				
				
				save(etudiant);
				
				AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
				   ctx.register(AppConfig.class);
				   ctx.refresh();
				
				
				 JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);
				 MimeMessage mimeMessage = mailSender.createMimeMessage();
			   	 MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
			   	 try {
					mailMsg.setFrom("silamirochdi@gmail.com");
					mailMsg.setTo(email);
				   	 mailMsg.setSubject("Inscription dans la plateforme e-challenge");
				   	 String msg = "On vous invite de continuer l'inscription dans notre platforme e-challenge \n";
				   	 msg += "user : "+ssoid+"\n";
				   	msg += "password : "+password;
				   	 mailMsg.setText(msg);
					 mailSender.send(mimeMessage);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   	 
				
				
				
			}
			
		}



		@Override
		public void update(Etudiant etudiant) {
               dao.update(etudiant);			
		}

}
