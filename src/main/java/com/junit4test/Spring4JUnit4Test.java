package com.junit4test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;



import javax.validation.ValidatorFactory;

import com.compilers.IDE;
import com.dao.CompteDaoImpl;
import com.dao.UserDao;
import com.dao.challenges.ChallengerDao;
import com.model.Challenge;
import com.model.Challenger;
import com.model.Compte;
import com.model.Entreprise;
import com.model.Etablissement;
import com.model.Langage;
import com.model.Professeur;
import com.service.ChallengeService;
import com.service.CompteService;
import com.service.CompteServiceImpl;
import com.service.EtudiantService;
import com.service.ProfesseurService;
import com.service.challenge.ChallengesService;
import com.service.entreprise.EntrepriseService;
import com.service.etab.EtabService;
import com.service.language.LangageService;
import com.dao.professeur.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.configuration.ConfigurationViews.class, loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class Spring4JUnit4Test {
	
  @Autowired
  private UserDao compteDao;
  @Autowired 
  private CompteService compteService;
  
  @Autowired
  private ChallengerDao challengerDao;
  @Autowired 
  private ChallengeService challengeService;
  
  
  @Autowired
  private ProfesseurDao professeurDao;
  @Autowired 
  private ProfesseurService professeurService;
  
  
  @Autowired
  private EtudiantService etudiantService;
  
  @Autowired
  private EtabService etabService;
  
  
  @Autowired
  private EntrepriseService entrepriseService;
  
  
  @Autowired
  LangageService languageService;
  
  
  @Autowired
  ChallengesService challengesService;
  
  @Autowired 
  LocalValidatorFactoryBean  validator;
  
  @Autowired
  Professeur prof;

  /*
       Test BEAN VALIDATION : COMPTE 
  */
  //@Test
  public void validationCompteTest(){  
	  Compte user = new Compte();
	  user.setPassword("123456");
	  user.setSsoId("a");
	  
	  Set<ConstraintViolation<Compte>> violations = validator.validate(user);
	  
      assertTrue(violations.isEmpty());	  	  
  }
 
  /*
       Test SAVING BEAN : COMPTE
  */
  //@Test
  public void saveCompteTest(){
	  
	  Compte user = new Compte();
	  user.setPassword("123456");
	  user.setSsoId("amine");
	  
	  
	  compteDao.save(user);
	  
	  
	  Compte userTest = compteDao.findById(user.getId());
	  
	  assertTrue(userTest != null);
	  assertEquals("amine", userTest.getSsoId());
	  
  }
  
  /*
  Test BEAN VALIDATION : CHALLENGER 
  */  
  
  //@Test
  public void validationChallengerTest()
  {
	  Compte compte = new Compte();
	  compte.setPassword("123456");
	  compte.setSsoId("ahmed");
	  	  
	  
	  Challenger challenger = new Challenger();
	  
	  challenger.setCompte(compte);
	  challenger.setEmail("ahmed@gmail.com");
	  challenger.setFirstName("ahmed");
	  challenger.setLastName("ahmed");
	  challenger.setTel("0522553388");
	  
      Set<ConstraintViolation<Challenger>> violations = validator.validate(challenger);
      assertTrue(violations.isEmpty());	 
	  
  }
  
  
  
  /*
  Test SAVING BEAN : CHALLENGER
  */
  //@Test
  public void saveChallengerTest()
  {
	  Compte compte = new Compte();
	  compte.setPassword("123456");
	  compte.setSsoId("ahmed");
	  	  
	  
	  compteService.save(compte);
	  
	  Challenger challenger = new Challenger();
	  
	  
	  
	  challenger.setCompte(compte);
	  challenger.setEmail("ahmed@gmail.com");
	  challenger.setFirstName("ahmed");
	  challenger.setLastName("ahmed");
	  challenger.setTel("0522553388");
	  
      challengerDao.save(challenger); 
	  
      Challenger challengerTest =  challengerDao.findById(challenger.getId());
      
      assertTrue(challengerTest != null);
      assertEquals(challengerTest.getEmail(), challenger.getEmail());
  }
  
 
  
  /*
  Test BEAN VALIDATION : PROFESSEUR 
  */  
  //@Test
  public void validationProfesseurTest()
  {
	  //Creation du model professeur
	  Compte compte = new Compte();
	  compte.setPassword("123456");
	  compte.setSsoId("ahmed");
	  
	  Professeur prof = new Professeur(); 	  
	  prof.setCompte(compte);
	  prof.setEmail("ahmed@gmail.com");
	  prof.setFirstName("ahmed");
	  prof.setLastName("ahmed");
	  prof.setTel("0522553388");
	  prof.setReference("ref1");     
	  
	  Set<ConstraintViolation<Professeur>> violations = validator.validate(prof);
	  
	  Iterator<ConstraintViolation<Professeur>> it =  violations.iterator();
	  
	  while(it.hasNext())
		  System.out.println(it.next().getMessage());
	  
      assertTrue(violations.isEmpty());	 	 
  }
  
  
  /*
  Test SAVING BEAN : CHALLENGER
  */
// @Test
  public void saveProfesseurTest()
  {
	//Creation du model professeur
	  Compte compte = new Compte();
	  compte.setPassword("123456");
	  compte.setSsoId("ahmed");
	  compteService.save(compte);
	  
	  Professeur prof = new Professeur(); 	  
	  prof.setCompte(compte);
	  prof.setEmail("ahmed@gmail.com");
	  prof.setFirstName("ahmed");
	  prof.setLastName("ahmed");
	  prof.setTel("0522553388");
	  prof.setReference("ref15");
	  professeurDao.save(prof); 
	  
	  
	 // Professeur profTest =  professeurDao.findById(prof.getId());
      
   //   assertTrue(profTest != null);
 //     assertEquals(profTest.getReference(), prof.getReference());
	  
  
  }
  /*
  Test SERVICE BEAN : ETUDIANT
  */
  //@Test
  public void serviceEtudiantTest()
  { 
	  //Creation du model professeur
	  Compte compte = new Compte();
	  compte.setPassword("123456");
	  compte.setSsoId("ahmed");
	  compteService.save(compte);
	  
	  Professeur prof = new Professeur(); 	  
	  prof.setCompte(compte);
	  prof.setEmail("ahmed@gmail.com");
	  prof.setFirstName("ahmed");
	  prof.setLastName("ahmed");
	  prof.setTel("0522553388");
	  prof.setReference("ref");
	  professeurDao.save(prof);  
	  
	  
	  Set<String> emails = new HashSet<String>();
	  
	  emails.add("mr.cheguevara77@gmail.com");
	  String nomClasse = "classe4";
	  Etablissement etab = etabService.findById(1);
	  
	  etudiantService.inscriptionEtudiants(emails, nomClasse, prof, etab);
	  
  }
  
  /*
  Test BEAN SAVING : ENTREPRISE 
  */  
  //@Test
  public void validationEntrepriseTest()
  {
	//Creation du model entreprise
	  Compte compte = new Compte();
	  compte.setPassword("123456");
	  compte.setSsoId("entreprise");
	  
	  Entreprise entreprise = new Entreprise();
	  entreprise.setAdresse("adresse");
	  entreprise.setCompte(compte);
	  entreprise.setDescription("description");
	  entreprise.setEmail("email@gmail.com");
	  entreprise.setNomEntreprise("nomEntreprise");
	  entreprise.setTaille(120);
	  entreprise.setTel("0566884455");
	  
	  
      Set<ConstraintViolation<Entreprise>> violations = validator.validate(entreprise);
	  
	  Iterator<ConstraintViolation<Entreprise>> it =  violations.iterator();
	  
	  while(it.hasNext())
		  System.out.println(it.next().getMessage());
	  
      assertTrue(violations.isEmpty());	 
	  
	  
	  
  }
  
  
  /*
  Test BEAN SAVING : ENTREPRISE 
  */  
  //@Test
  public void saveEntrepriseTest()
  {
	  
	  //Creation du model entreprise
	  Compte compte = new Compte();
	  compte.setPassword("123456");
	  compte.setSsoId("entreprise");
	  compteService.save(compte);
	  
	  Entreprise entreprise = new Entreprise();
	  entreprise.setAdresse("adresse");
	  entreprise.setCompte(compte);
	  entreprise.setDescription("description");
	  entreprise.setEmail("email@entreprise.com");
	  entreprise.setNomEntreprise("nomEntreprise");
	  entreprise.setTaille(120);
	  entreprise.setTel("0566778844");
	  
	  
	  entrepriseService.save(entreprise);
	  
	  Entreprise entrepriseTest;
	  
	  entrepriseTest = entrepriseService.findById(entreprise.getId()); 
	  
	  assertTrue(entrepriseTest != null);
	  assertEquals(entrepriseTest.getCompte().getSsoId(), entreprise.getCompte().getSsoId());
	
  }
  
  
    
  //@Test
  public void runProgrammeTest()
  {
	  
	  String  sourceCode = "#include <stdio.h> \n int main(void) \n{ \nint i = 5;\n  scanf(\"%d\", &i);\nprintf(\"Tets %d\", i);\nreturn 0;\n}";
	  
	  HashMap<String,String> res = IDE.runProgramme(sourceCode, "141\n", 11,true);
	   
	  String ouput = res.get("output");
	  	  
	  assertEquals(ouput,"Tets 141");  
	  
  }
  
  //@Test
  public void addLanguagesIDE()
  {
	  HashMap<Integer,String>  languagesIDE = IDE.getLanguages();
      
	  java.util.Iterator<Integer> keys =  languagesIDE.keySet().iterator();
		 
	  while(keys.hasNext())
	  {
		 Integer key = keys.next();
	     String namelanguage = languagesIDE.get(key);
	     
	     Langage langage = new Langage();
	     
	     langage.setCleeLangage(key);
	     langage.setNomLangage(namelanguage);
	     
	     languageService.save(langage);
	     
	     
	     
		 //System.out.println(key + " : " + languge);	 
	  }
	  
  }
  
 // @Test
  public void  testProgramme()
  {
	List<Langage> languages =   languageService.allLanguages();
	
	Iterator<Langage> it = languages.iterator();
	
	while(it.hasNext())
	{
		System.out.println(it.next().getNomLangage());
	}
	
	
  }
  
  @Test
  public void  testChallenge()
  {
	    Challenge challenge =  challengesService.findById(1);
		
		Langage langage = challenge.getLangage();     
     
      
        String output = challenge.getOutput();
      
        String[] outputS = output.split("\\r?\\n");
      
        int i = outputS.length;
    
        while(i > 1)
        {
      	i--;
      	System.out.println(outputS[i]);
        }
     
	
	   prof.print();
  }
  
  
  
  
}