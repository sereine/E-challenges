package com.controller;

import java.beans.PropertyEditorSupport;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.compilers.IDE;
import com.dao.etab.EtabDaoImpl;
import com.model.Challenge;
import com.model.ChallengeTest;
import com.model.Challenger;
import com.model.Classe;
import com.model.Compte;
import com.model.Developpeur;
import com.model.Entreprise;
import com.model.Etablissement;
import com.model.Etudiant;
import com.model.FileBucket;
import com.model.Langage;
import com.model.Probleme;
import com.model.Professeur;
import com.model.Solution;
import com.model.UserProfile;
import com.service.ChallengerService;
import com.service.CompteService;
import com.service.DeveloppeurService;
import com.service.EtudiantService;
import com.service.ProfesseurService;
import com.service.ProfesseurServiceImpl;
import com.service.UserProfileService;
import com.service.challenge.ChallengeTestService;
import com.service.challenge.ChallengesService;
import com.service.challenge.ProblemeService;
import com.service.entreprise.EntrepriseService;
import com.service.etab.EtabService;
import com.service.etab.EtabServiceImpl;
import com.service.language.LangageService;
import com.service.solution.SolutionService;
import com.util.ReadDataStudentsXML;
import com.validator.FileValidator;

@Controller
public class ControllerServlet {
    
	private static String UPLOAD_LOCATION="C:\\Users\\PC\\Desktop\\Projet JEE\\FilesUpload\\";
	
    
	
	
	@Autowired
    FileValidator fileValidator;
    @InitBinder("fileBucket")
    protected void initBinderFileBucket(WebDataBinder binder) {
       binder.setValidator(fileValidator);
    }
	
   
    @Autowired
    Professeur prof;
    
    @Autowired
    EtabService etabService;
	@Autowired
	UserProfileService userProfileService;
	@Autowired
	CompteService compteService;
	@Autowired
	ChallengerService challengerService;
	@Autowired
	DeveloppeurService developpeurService;
	@Autowired
	ProfesseurService professerService;
	@Autowired
	EtudiantService etudiantService;
	@Autowired
    EntrepriseService entrepriseService;
	@Autowired
	LangageService languageService;
	
	
	@Autowired
	ProblemeService problemeService;
	
	@Autowired
	ChallengeTestService challengeTestService;
	
	@Autowired
	ChallengesService challengeService;
	
	@Autowired
	  SolutionService solutionService;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		
		initData();		
		return "welcome";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		
		
		System.out.println(getRole());
		
		return "user";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {

		
		return "login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	
	@RequestMapping(value = "/InscriptionDeveloppeur", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		Developpeur developeur = new Developpeur();
		model.addAttribute("developpeur", developeur);
		return "InscriptionDevloppeur";
	}

	
	@RequestMapping(value = "/InscriptionDeveloppeur", method = RequestMethod.POST)
	public String saveRegistration(@Valid Developpeur developpeur,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println(developpeur.getFirstName());
			return "InscriptionDevloppeur";
		}
		developpeurService.save(developpeur);
		
		
		return "redirect:/home";
	}
	
	
	
	@RequestMapping(value = "/InscriptionProfesseur", method = RequestMethod.GET)
	public String inscriptionProfesseur(ModelMap model) {
		
		System.out.println(prof.getEmail());
		
		//Professeur professeur = new Professeur();
		model.addAttribute("professeur", prof);
		return "InscriptionProfesseur";
	}

	
	@RequestMapping(value = "/InscriptionProfesseur", method = RequestMethod.POST)
	public String enregistrerProfesseur(@Valid Professeur professeur,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println(professeur.getFirstName());
			return "InscriptionProfesseur";
		}
		
		
		
		
		professerService.save(professeur);
		
		return "redirect:/home";
	}
	
	
	
	
	
	
	
	
	//   Add Students 
	
	 @RequestMapping(value="/AddStudents", method = RequestMethod.GET)
	    public String getSingleUploadPage(ModelMap model) {
		    
		   String role =   getRole();
		    
		   
		   if(role == null)
			return   "redirect:/home";
		   
		   if(role.compareTo("Professeur") != 0)
			return   "redirect:/home";
		   
	        FileBucket fileModel = new FileBucket();
	        model.addAttribute("fileBucket", fileModel);
	        
	        
	        List<Etablissement> etabs = etabService.allEtab();
	        
	      
	        
	        model.addAttribute("etabs", etabs);
	        
	          
	        
	        return "AddStudents";
	    }
	    
	    
	 
	    @RequestMapping(value="/AddStudents", method = RequestMethod.POST)
	    public String singleFileUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap model) {
	        	    	
	        if (result.hasErrors()) {
	            System.out.println("validation errors");
	            
	            List<Etablissement> etabs = etabService.allEtab();
		        
		        model.addAttribute("etabs", etabs);
	            
	            return "AddStudents";
	        } else {            
	            System.out.println(fileBucket.getNomClasse());
	            MultipartFile multipartFile = fileBucket.getFile();
	 
	            try {
					
	            	FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION + fileBucket.getFile().getOriginalFilename()));
				    
	            	try {
						  Set<String> emails =  ReadDataStudentsXML.readDataStudentsXML(UPLOAD_LOCATION + fileBucket.getFile().getOriginalFilename());
						  
						  Challenger challenger = getChallenger();
						  
						  Professeur prof = professerService.findById(challenger.getId());
						  
						  etudiantService.inscriptionEtudiants(emails,fileBucket.getNomClasse(),prof,fileBucket.getEtabs());
	            	
	            	} catch (ParserConfigurationException e) {
						e.printStackTrace();
						return "AddStudents";
					} catch (SAXException e) {
						e.printStackTrace();
						return "AddStudents";
					}
	            	
	            } catch (IOException e) {
					e.printStackTrace();
					return "AddStudents";
				}
	             
	            String fileName = multipartFile.getOriginalFilename();
	            model.addAttribute("fileName", fileName);
	            return "success";
	        }
	    }
		
    
	    
	// Continnuer l'inscription étudiant     
    
	    
   @RequestMapping(value = "/InscriptionEtudiant", method = RequestMethod.GET)
   public String inscriptionEtudiant(ModelMap model) {
			
	        String role = getRole();
	        
	        if(role == null) 
	        	return "redirect:/home";
	        	        
	        if( role.compareTo("Etudiant") != 0 )
	        	return "redirect:/home";
	        	        
	        Etudiant etudiant = (Etudiant) getChallenger(); 
	        
	        if(etudiant.isActive())
	        	return "redirect:/home";
	        	
	        
			model.addAttribute("etudiant", etudiant);
			return "InscriptionEtudiant";
   }
    
   @RequestMapping(value="/InscriptionEtudiant", method = RequestMethod.POST)
   public String inscriptionEtudiantPost(Etudiant etudiant, BindingResult result, ModelMap model) {
	   if (result.hasErrors()) {
           
           return "InscriptionEtudiant";
       } else {
	      
    	   
    	   String role = getRole();
	        
	        if(role == null) 
	        	return "redirect:/home";
	        	        
	        if( role.compareTo("Etudiant") != 0 )
	        	return "redirect:/home";
	        	        
	        Etudiant _etudiant = (Etudiant) getChallenger(); 
	        
	        if(etudiant.isActive())
	        	return "redirect:/home";
    	   
	        _etudiant.setCne(etudiant.getCne());
	        _etudiant.setFirstName(etudiant.getFirstName());
	        _etudiant.setLastName(etudiant.getLastName());
	        _etudiant.setTel(etudiant.getTel());
	        _etudiant.setActive(true);
	        
    	  etudiantService.update(_etudiant);
    	   return "redirect:/home";
       }
	   
   }
	    
   //    INSCRIPTION ENTREPRISE
   
   
   @RequestMapping(value = "/InscriptionEntreprise", method = RequestMethod.GET)
	public String newRegistrationEntreprise(ModelMap model) {
		Entreprise entreprise = new Entreprise();
		model.addAttribute("entreprise", entreprise);
		return "InscriptionEntreprise";
	}

	
	@RequestMapping(value = "/InscriptionEntreprise", method = RequestMethod.POST)
	public String saveRegistrationEntreprise(@Valid Entreprise entreprise,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println(entreprise.getNomEntreprise());
			return "InscriptionEntreprise";
		}
		entrepriseService.save(entreprise);
		
		
		return "redirect:/home";
	}
   
   
	
   //    ADD CHALLENGE
   
	
	@RequestMapping(value = "/AddChallenge", method = RequestMethod.GET)
	public String addchallenges(ModelMap model) {
		
		
	    	   
	   String role = getRole();
		        
	   if(role == null) 
		       return "redirect:/home";
		       
	   
	   if( role.compareTo("Entreprise") != 0 )
		        return "redirect:/login";
		        	        
		
		
		
		ChallengeTest challengetest = new ChallengeTest();
		
		model.addAttribute("challengetest", challengetest);
		List<Langage> langage=languageService.allLanguages();
		
		model.addAttribute("langage", langage);
		
		return "AddChallenge";
	}
    
	
	@RequestMapping(value = "/AddChallenge", method = RequestMethod.POST)
	public String saveRegistrationChallenge(@Valid ChallengeTest challengetest,
			BindingResult result, ModelMap model, @RequestParam String type) {
		
		if (result.hasErrors()) {
			System.out.println(challengetest.getTitre());
			System.out.println(result.toString());
			return "AddChallenge";
		}
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		challengetest.setDate_creation(date);
		if(date.after(challengetest.getDate_echeance()))
		{
			return "redirect:/login";
		}
		
		else
		{
	    
        challengetest.setType(type);
        
		challengeTestService.save(challengetest);
		return "redirect:/home";
		}
	}
	
	
	
	
    
	@RequestMapping(value = "/AddProbleme", method = RequestMethod.POST)
	public String addProbleme(ModelMap model) {
		Probleme probleme = new Probleme();
		model.addAttribute("probleme", probleme);
		return "AddProbleme";
	}
   
   
	    
	
	// FUNCTION 
	
	
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
			
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	private String getRole(){
		String userName = getPrincipal();
		
		
		if(userName == null)
			return null;
		
		Compte compte =  compteService.findBySso(userName);
		
		
		Challenger challenger = challengerService.findByCompte(compte);
		
		if(challenger != null)
		{
		if(challenger instanceof Developpeur)
		{
			return "Developpeur"; 
		}
		else if(challenger instanceof Professeur)
		{
			return "Professeur";
		}
		else if(challenger instanceof Etudiant)
		{
			return "Etudiant";
		}
		}
	
		else
		{
		Entreprise entreprise = entrepriseService.findByCompte(compte);
		
		if( entreprise != null )
			return "Entreprise";
		
		}
		
		
		
		return null;
		
	}
	
	
	Entreprise getEntreprise()
	{   
		
		 String userName = getPrincipal();	
		 if(userName == null)
				return null;
		 
		 Compte compte =  compteService.findBySso(userName);	
		 
		 if(entrepriseService.findByCompte(compte) == null)
			return null;
			
		 Entreprise entreprise = entrepriseService.findByCompte(compte);
		 return entreprise;
		
	}
	
	
	Challenger getChallenger()
	{
        String userName = getPrincipal();
		
		
		if(userName == null)
			return null;
		
		Compte compte =  compteService.findBySso(userName);
		
		if(challengerService.findByCompte(compte) == null)
			return null;
		
		Challenger challenger = challengerService.findByCompte(compte);
		
		return challenger;
	}
	
	void initData()
	{
		   Etablissement etab;
	       
	       etab = etabService.findById(1);
	     
	       if(etab == null)
	       {
		       etab = new Etablissement();
		       etab.setNomEta("Faculte des Sciences Ain Chock ");
		       etab.setAdresseEta("Km 8 Route d El Jadida");
		       etabService.save(etab);
		       
		       
		       etab = new Etablissement();
		       etab.setNomEta("Faculté des Sciences Ben M'Sik");
		       etab.setAdresseEta("Av Avenue Driss El Harti B.P 7955, Sidi Othmane Casablanca");
		       etabService.save(etab);
		       
		       
		       etab = new Etablissement();
		       etab.setNomEta("Faculté des sciences et techniques de Mohammedia");
		       etab.setAdresseEta("Mohammedia 20650 Maroc ");
		       etabService.save(etab);
	       }
		
	}
	
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Etablissement.class, "etabs", new PropertyEditorSupport() {
	    @Override
	    public void setAsText(String text) {
	        Etablissement etab = etabService.findById(Integer.parseInt(text));
	        setValue(etab);
	    }
	    });
	    
	    binder.registerCustomEditor(Langage.class, "langage", new PropertyEditorSupport() {
		    @Override
		    public void setAsText(String text) {
		        Langage langage = languageService.findById(Integer.parseInt(text));
		        setValue(langage);
		    }
		    });
	    
	    
	}
	
	// Effectuer challenge 
	
	@RequestMapping(value = "/effectuerchallenge", method = RequestMethod.GET)
	public String effectuerEhallenge(ModelMap model,@RequestParam(value="challenge_id",required=false) String challenge_id) {
		
		
		if(challenge_id == null)
			return "redirect:/home";
		
		
		String role =   getRole();
	    
		   
	    if(role == null)
		  return   "redirect:/home";
		   
	    
	    
		if(role.compareTo("Developpeur") != 0 && role.compareTo("Professeur") != 0
				&& role.compareTo("Etudiant") != 0 )
			return   "redirect:/home";
		   
		
		 Integer id = null;
		
		try
		{
		    id = Integer.parseInt(challenge_id);
		}
		catch(Exception e)
		{
			return "redirect:/home";
		}
		
		Challenge challenge =  challengeService.findById(id);
		
		if(challenge == null )
			return "redirect:/home";
		
		Langage langage = challenge.getLangage();

		if(challenge == null)
			return "redirect:/home";
		
		
		model.addAttribute("language",langage.getNomLangage());
		model.addAttribute("titre",challenge.getTitre());
		model.addAttribute("id_challenge",challenge.getId());
		
		return "effectuerchallenge";
	}
	
	
	 // Envoyer Solution	
		@RequestMapping(value = "/envoyerSolution", method = RequestMethod.GET)
		public @ResponseBody HashMap<String, String> envoyerSolution(
				@RequestParam("code") String code,
				@RequestParam("id_challenge") String challenge_id){
	        
		    HashMap<String,String> repErr = new  HashMap<String,String>();   
            
		    repErr.put("msgSolution", "La solution est envoye");
		
			if(code == null)
			{
				 repErr.put("msgSolution","entrer le code");
				 return repErr;
			}
			if(challenge_id == null)
			{
				 repErr.put("msgSolution","challende id est incorrecte");
				 return repErr;
			}
			String role =   getRole();
		    if(role == null)
		    {
				 repErr.put("msgSolution","vous etes pas autoriser");
				 return repErr;
			}
			if(role.compareTo("Developpeur") != 0 && role.compareTo("Professeur") != 0
					&& role.compareTo("Etudiant") != 0 )
			{
				 repErr.put("msgSolution","vous etes pas autoriser");
				 return repErr;
			}
			   
			Challenger challenger = getChallenger();
			
			if(challenger == null)
			{
				 repErr.put("msgSolution","vous étes pas autoriser");
				 return repErr;
			}
			
			Integer id = null;
			
			try
			{
			    id = Integer.parseInt(challenge_id);
			}
			catch(Exception e)
			{
				
					 repErr.put("msgSolution","challenge id est incorecte");
					 return repErr;
				
			}
			Challenge challenge =  challengeService.findById(id);
			if(challenge == null )
			{
				 repErr.put("msgSolution","vous étes pas autoriser");
				 return repErr;
			}
			
			Langage langage = challenge.getLangage();

			HashMap<String,Object> res = new HashMap<String,Object>();

			
	        //Traitement
			
			  res = IDE.runProgramme(code, challenge.getInput(), langage.getCleeLangage(),true);
			  
			  if(res == null)
			  {
					 repErr.put("msgSolution","connexion erreur");
					 return repErr;
			  }
			  
			  
		      Solution solution = new Solution();      
			  
		      solution.setChallenge(challenge);
		      solution.setChallenger(challenger);
		      solution.setCode(code);
			  java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		      solution.setDate(date);      
		      System.out.println(res.get("memory") +" "+ res.get("time"));
		      solution.setTailleFichier((Integer)res.get("memory"));
		      solution.setTempsExecution((Float)res.get("time"));
		      solution.setSolutionCorrecte(true);
		      
		      
		      
		      String output = challenge.getOutput();
		      
		      String[] outputS = output.split("\\r?\\n");
		      String[] resS = ((String)(res.get("output"))).split("\n");
		      
		      int nbrOuput = outputS.length;
		      
		      int nbrRes = resS.length;
		      
		      if( nbrOuput!=  nbrRes)
		    	  solution.setSolutionCorrecte(false);
		      
		      System.out.println(nbrOuput);
		      System.out.println(nbrRes);
		      int i = nbrOuput;
		      i--;
		      
		      while(i >=0 )
		      {
		    	
		      	System.out.println(outputS[i] + "  "+ resS[i]);
		      	if(outputS[i].compareTo(resS[i]) != 0)
		      	{
		      		 System.out.println("co");
		      		solution.setSolutionCorrecte(false);
			        break;
		      	}
		      	i--; 
		      }
		     
		      
		      solutionService.save(solution); 
		      
		      System.out.println("aze");
			
			
			
			
		      repErr.put("msgSolution","la solution est envoye");
			  return repErr;
		}
		
	
	//  response Compiler  Test  ( effectuer challenge )
	
	
	@RequestMapping(value = "/responseCompilerTest", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> responseCompilerTest(
			@RequestParam("code") String code,
			@RequestParam("id_challenge") String challenge_id){
            
		    HashMap<String,Object> repErr = new  HashMap<String,Object>();   
		
			if(challenge_id == null)
			{	
				repErr.put("msgErreur", "challenge id incorrecte");
				return repErr;
				
			}
			
			 Integer id = null;
			
			try
			{
			    id = Integer.parseInt(challenge_id);
			}
			catch(Exception e)
			{
				repErr.put("msgErreur", "challenge id incorrecte");
				return repErr;
			}
			
			Challenge challenge =  challengeService.findById(id);
			
			if(challenge == null)
			{
				repErr.put("msgErreur", "challenge id incorrecte");
				return repErr;
			}
			
			Langage langage = challenge.getLangage();
			
			
			
	        

	        HashMap<String,Object> res = new HashMap<String,Object>();
	       
	       
	        res = IDE.runProgramme(code, challenge.getInput(), langage.getCleeLangage(),true);
	        
	        
	        if(res == null)
	        {
	        	repErr.put("msgErreur", "erreur de connexion");
				return repErr;
	        }
	        
	        
	        
	        String output = challenge.getOutput();
	        
	        String[] outputS = output.split("\\r?\\n");
	        String[] resS = ((String)res.get("output")).split("\n");
	        
	        int nbrOuput = outputS.length;
	        
	        int nbrRes = resS.length;
	        
	        if( nbrOuput!=  nbrRes)
	        {
	        	res.put("res", "false");
	        	res.remove("input");
	        	res.remove("output");
	        	return res;
	        }
	        
	        int i = nbrOuput;
	        
	        i = i  - 1;
	        
	        while(i >= 0)
	        {
	        	
	        	if(outputS[i].compareTo(resS[i]) != 0)
	        	{
	        		res.put("res", "false");
	        		res.remove("input");
		        	res.remove("output");
		        	return res;
	        	}
	        	i--;
	        }
	       
	        res.put("res", "true");
	        
	        System.out.println(res);
	         
	        res.remove("input");
        	res.remove("output");
	        return res;
	       
	}
	
	
	
	
	
	
	
	
	
	// COMPILER ONLINE
	
	
	@RequestMapping(value = "/compiler", method = RequestMethod.GET)
	public String testAJAX(ModelMap model) {
		
		List<Langage> languages =   languageService.allLanguages();
		
		model.addAttribute("languages", languages);
		
		return "compiler";
	}
   
	@RequestMapping(value = "/responseCompiler", method = RequestMethod.GET)
	public @ResponseBody String processAJAXRequest(
				@RequestParam("code") String code,
				@RequestParam("input") String input,
				@RequestParam("languages") String idLanguage){
                

		        Langage langage = languageService.findById(Integer.parseInt(idLanguage));
		        
		        if( langage == null )
		        	return "Non valide langage.";
		        

		        HashMap<String,Object> res = IDE.runProgramme(code, input, langage.getCleeLangage(),true);
		        
		         System.out.println(res);
		        
		         
		         
		           if(res == null)
		        	 return "connexion error";
			  
			        	
		         
		        if( ((String)res.get("cmpinfo")).isEmpty() == false )
		           return (String) res.get("cmpinfo");
		        	
		       
		        
		       
		  
			return (String)res.get("output");
		}
	
	
	
	
	
	
	
	
	  /*
	  String  sourceCode = "#include <stdio.h> \n int main(void) \n{ \nint i = 5;\n  scanf(\"%d\", &i);\nprintf(\"Tets %d\", i);\nreturn 0;\n}";
	  
	  HashMap<String,String> res = IDE.runProgramme(sourceCode, "141\n", 11);
	   
	  String ouput = res.get("output");
	  
	  System.out.println(ouput);
	*/

}