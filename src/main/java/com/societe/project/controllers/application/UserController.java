package com.societe.project.controllers.application;


import java.io.IOException;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.societe.project.firebase.FirebaseService;

import com.societe.project.models.Adresse;
import com.societe.project.models.Car;
import com.societe.project.models.Compte;
import com.societe.project.models.Message;
import com.societe.project.models.PT;
import com.societe.project.models.Profil;
import com.societe.project.models.Trajet;

import com.societe.project.services.AdresseService;
import com.societe.project.services.CarService;
import com.societe.project.services.CompteService;
import com.societe.project.services.MessageService;
import com.societe.project.services.PTService;
import com.societe.project.services.ProfilService;
import com.societe.project.services.RecuperationInfoLoginService;
import com.societe.project.services.TrajetService;
import com.societe.project.validators.CompteValidatorForGestionUser;
import com.societe.project.validators.TrajetValidator;

@Controller
public class UserController {

	private static final String URL_GESTION_COMPTE  = "/user/gestioncompte";
	
	private static final String VUES 	            = "user";
	private static final String VUE_GESTION_COMPTE  = VUES + "/gestioncompte";
	
	
	private static final String URL_TRAJET_USER           = "/user/researchtrajet";
	private static final String URL_TRAJET_VALIDATE       = "/user/validTrajet";
	private static final String URL_TRAJET_MESS           = "/user/sendMessTrajet";
	private static final String URL_VOS_TRAJET            = "/user/vostrajet";
	
	private static final String URL_DELETE_MESS_TRAJET    = "/user/delmessage";
	
	
	
	private static final String VUE_MATCH_TRAJET_COMPTE   = "/trajets/matchTrajet";
	private static final String URL_PROPOSER_TRAJET  = "/user/proposertrajet";
	private static final String VUE_PROPOSER_TRAJET  = "/trajets/proposertrajet";
	
	private static final String VUE_VOS_TRAJET    = "/trajets/vostrajet";
	private static final String URL_VOS_MESSAGE   = "/trajets/vosmessage";
	
	@Autowired
	FirebaseService firebaseService;
	@Autowired
	CompteService  compteService;
	@Autowired
	ProfilService  profilService;
	@Autowired
	AdresseService adresseService;
	@Autowired
	CarService     carService;	
	@Autowired
	TrajetService  trajetService;
	@Autowired
	PTService      ptService;
	@Autowired
	MessageService messageService;
	@Autowired
	CompteValidatorForGestionUser compteValidatorForGestionUser;
	@Autowired

	RecuperationInfoLoginService recuperationInfoLogin;

	TrajetValidator trajetValidator;

	

	@RequestMapping(value={UserController.URL_GESTION_COMPTE}, method=RequestMethod.GET)
	public String gestionCompte(Model model) {
		Compte compte = recuperationInfoLogin.recuperationCompteForUserLogge();
		model.addAttribute("compte", compte);
		//model.addAttribute("errors", bindingResult);

		return VUE_GESTION_COMPTE;
	}
	
	@RequestMapping(value={UserController.URL_GESTION_COMPTE}, method=RequestMethod.POST)
	public String modificationCompte(@ModelAttribute Compte compte, BindingResult bindingResult, Model model) {

		compteValidatorForGestionUser.validate(compte, bindingResult);
		
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getErrorCount());
			System.out.println(bindingResult.getAllErrors().get(0).getCode());
			model.addAttribute("errors", bindingResult);
			return URL_GESTION_COMPTE;
        }
		
		profilService.save(compte.getProfil());
		
		List<Adresse> adresses = compte.getProfil().getAdresses();
		List<Car> cars = compte.getProfil().getCars();
		
		for (Adresse adresse : adresses) {
			adresseService.save(adresse);
		}
		
		if (cars.get(0).getMarque() != null) {
			for (Car car : cars) {
				carService.save(car);
			}
		}
	
		return "redirect:/home";
	}

	
	/**
	 * *********************************************************
	 * 		reseach trajet
	 * ***********************************************************
	 */

	
	@RequestMapping(value={UserController.URL_PROPOSER_TRAJET}, method=RequestMethod.GET)
	public String proposerTrajet(Model model) {
		Compte compte = recuperationInfoLogin.recuperationCompteForUserLogge();
		Trajet trajet = new Trajet();
		PT pt = new PT();
		model.addAttribute("compte", compte);
		model.addAttribute("trajet", trajet);
		model.addAttribute("pt", pt);
		
		Trajet userTraget = firebaseService.getUserTrajet();
		if(!userTraget.getId().equals(-1))
		{model.addAttribute("trajetMessage",userTraget);}
		
		return VUE_PROPOSER_TRAJET;
	}
	
	@RequestMapping(value={UserController.URL_PROPOSER_TRAJET}, method=RequestMethod.POST)
	public String proposerTrajetSave(@ModelAttribute Compte compte, @ModelAttribute PT pt, @ModelAttribute Trajet trajet, Model model) {
		
//		trajetValidator.validate(trajet, bindingResult);
//		if (bindingResult.hasErrors()) {
//			System.out.println(bindingResult.getErrorCount());
//			System.out.println(bindingResult.getAllErrors().get(0).getCode());
//			model.addAttribute("errors", bindingResult);
//			return URL_PROPOSER_TRAJET;
//        }
		
		trajetService.save(trajet);

		pt.setProfil(compte.getProfil());
		pt.setTrajet(trajet);
		ptService.save(pt);
		
		// ici  creer conversation pour ce trajet
		try {
			firebaseService.createFirebaseTrajet(trajet.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		Trajet userTraget = firebaseService.getUserTrajet();
		if(!userTraget.getId().equals(-1))
		{model.addAttribute("trajetMessage",userTraget);}
	
		

		return "redirect:/home";
	}

	@RequestMapping(value= {UserController.URL_TRAJET_USER},method=RequestMethod.GET)
	public String matchTrajet(Model model) {
		System.out.println("matchTrajet");
		
		model.addAttribute("detailPath", "/user");
		
//		List <PT> listPt = (List<PT>) ptService.findAll();
		List <PT> listPt = (List<PT>) ptService.findAllPts();
		//model.addAttribute()
		
		for (PT pt : listPt) {
			pt.affPT();
		}	
		model.addAttribute("listPt", listPt);	
		
		Trajet userTraget = firebaseService.getUserTrajet();
		if(!userTraget.getId().equals(-1))
		{model.addAttribute("trajetMessage",userTraget);}
		
		return VUE_MATCH_TRAJET_COMPTE ;
	}
	
	/**
	 * *********************************************************
	 * 		save trajet Id
	 * *********************************************************
	 */
	
	
	@RequestMapping(value= {UserController.URL_TRAJET_VALIDATE+"/{id}"},method=RequestMethod.GET)

	public String matchTrajetSave(@PathVariable int id, Model model) {

		Boolean response = true;
		int idUser = recuperationInfoLogin.recuperationCompteForUserLogge().getProfil().getId();
		Profil profil = profilService.find(idUser).get();
		PT pt = ptService.find(id).get();
		int idTrajet = pt.getTrajet().getId();
		Trajet trajet = trajetService.find(idTrajet).get();
		if (pt.getNbrePlace() > 0) {
			pt.setNbrePlace(pt.getNbrePlace()-1);
			PT newPT = new PT(pt.getNbrePlace(), pt.getVolumeMax(), profil, trajet);
			ptService.save(newPT);
		}else {
			model.addAttribute("error", "Le trajet est complet");
			response = false;
		}
		return "redirect:"+ URL_TRAJET_USER;	

	}
	
	/**
	 * *********************************************************
	 * 		save message sur trajet id
	 *  **********************************************************
	 */
	
	@RequestMapping(value= {UserController.URL_TRAJET_MESS},method=RequestMethod.POST)
	public String validateTrajet(@ModelAttribute("id") Integer id,@ModelAttribute("messages") String messages) {
		System.out.println("message sur trajet ");
		
		System.out.println(id);
		System.out.println(messages);
		//recupe le propfil associe au compte 
		//save messagee fonction id trajet
		//l'id recu c'est l'id du pt 
		
		PT pt = ptService.find(id).get();
		Profil profil = pt.getProfil();
		Trajet trajet = pt.getTrajet();
		Date date = new Date();
		Message message = new Message(messages, date, trajet, profil);
		messageService.save(message);
		
		return "/trajets/ok" ;
	}
	
	
	/**
	 * *********************************************************
	 * 		URL_VOS_TRAJET 
	 *  **********************************************************
	 */
	
	@RequestMapping(value= {UserController.URL_VOS_TRAJET },method=RequestMethod.GET)
	public String vosTrajet() {
		System.out.println("vos trajets ");
		
		Compte compte = recuperationInfoLogin.recuperationCompteForUserLogge();
		
		compte.afficheCompte();  //ok
		compte.getProfil().afficheProfil(); //ok
		
		//recupere le profil 
		List <Message> listMess = (List<Message>) messageService.findAll();
		
		
		
		//recuperation des trajet fonction du profil
		//recupere les messages fonction des trajet
		
		return VUE_VOS_TRAJET ;
	}
	
	
	/**
	 * *********************************************************
	 * 		Vos message des trajet creer
	 *  **********************************************************
	 */
	
	@RequestMapping(value= {UserController.URL_VOS_MESSAGE },method=RequestMethod.GET)
	public String vosMessagreTrajet() {
		System.out.println("vos trajets ");
		
		//requete de recuperation des message  function id trajet
		//insert dans model 
		
		return VUE_VOS_TRAJET;
	}
	
	/**
	 * *********************************************************
	 * 		DELETE MESS  URL_DELETE_MESS_TRAJET 
	 *  **********************************************************
	 */
	@RequestMapping(value= {UserController.URL_DELETE_MESS_TRAJET },method=RequestMethod.GET)
	public String deleteMessTrajet() {
		System.out.println("delete Message trajet ");
		
		//recuperation id message a delete
		//return sur la vue 
		
		//model avc new vue de message de list 
		//xhr
		
		
		return VUE_VOS_TRAJET ;
	}
	
	
}
