package com.societe.project.firebase.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.core.ApiFuture;
import com.google.firebase.database.DatabaseReference;
import com.societe.project.firebase.FirebaseNotificationObserver;
import com.societe.project.firebase.FirebaseOpenHelper;
import com.societe.project.firebase.FirebaseService;
import com.societe.project.models.PT;
import com.societe.project.models.Trajet;
import com.societe.project.services.RecuperationInfoLoginService;

@Controller
@RequestMapping("/messagerie")
public class MessagerieController {
	@Autowired
	RecuperationInfoLoginService recuperationInfoLogin;
	@Autowired 
	FirebaseService firebaseService;
	
	/*@RequestMapping(value = {"","/"},method=RequestMethod.GET)
	public String messagerie(Model model) throws IOException, ParseException  {
		//model.addAttribute("message", FirebaseNotificationObserver.getInstance().getNotification());
	     //model.addAttribute("user",recuperationInfoLogin.recuperationCompteForUserLogge().getEmail());
		return "/messagerie";
		
	}*/
	
	@RequestMapping(value= {"","/"})
	public String Index(Model model) throws IOException {
     /*   Trajet trajet = new Trajet(1,"saintmalo");
		DatabaseReference Ref = FirebaseOpenHelper.getInstance().getDatabase().getReference("conversations/");
	    DatabaseReference trajetRef = Ref.child(trajet.getId().toString());
		model.addAttribute("trajetId", trajet.getId());
		model.addAttribute("userEmail",recuperationInfoLogin.recuperationCompteForUserLogge().getEmail());
		model.addAttribute("notification",FirebaseNotificationObserver.getInstance().getNotification());*/
		
		/*int Id = 0; 
		DatabaseReference Ref = FirebaseOpenHelper.getInstance().getDatabase().getReference("conversations/");
		List<PT> pts = recuperationInfoLogin.recuperationCompteForUserLogge().getProfil().getPT();
		for (PT pt : pts) {
			if( pt.getTrajet().getId() > Id)
			{Id = pt.getTrajet().getId();}
		}
		String trajetId = String.valueOf(Id);
	    DatabaseReference trajetRef = Ref.child(trajetId);
		model.addAttribute("trajetId", trajetId);*/
		
	//	model.addAttribute("trajetId",firebaseService.getTrajetId("13"));
		model.addAttribute("trajetId", firebaseService.getUserTrajet());
		model.addAttribute("userEmail",recuperationInfoLogin.recuperationCompteForUserLogge().getEmail());
		return "/messagerie";
	}
	
}
