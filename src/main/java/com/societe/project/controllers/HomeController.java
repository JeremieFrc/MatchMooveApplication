package com.societe.project.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.firebase.database.DatabaseReference;
import com.societe.project.firebase.FirebaseNotificationObserver;
import com.societe.project.firebase.FirebaseOpenHelper;
import com.societe.project.firebase.FirebaseService;
import com.societe.project.models.PT;
import com.societe.project.models.Trajet;
import com.societe.project.services.ArticleService;
import com.societe.project.services.ProfilService;
import com.societe.project.services.RecuperationInfoLoginService;

import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;

@Controller
public class HomeController {
    @Autowired
    ArticleService articleService;
    @Autowired
    ProfilService profilService;
    @Autowired
    FirebaseService firebaseService;
	@Autowired
	RecuperationInfoLoginService recuperationInfoLogin;
	
	@RequestMapping(value = {"/home"})
	public String showPage(Model model) throws TemplateModelException, IOException {
		//Ici je récupère la liste des roles de l'utilisateur connecté afin de passer dans la vue les différents roles
//		ArrayList<String> roles = new ArrayList<>();
//		SecurityContext securityContext = SecurityContextHolder.getContext();
//		Collection<? extends GrantedAuthority> role = securityContext.getAuthentication().getAuthorities();
//		for (GrantedAuthority grantedAuthority : role) {
//			roles.add(grantedAuthority.getAuthority());
//		}
		//Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
		//cfg.setSharedVariable("user", recuperationInfoLogin.recuperationCompteForUserLogge().getEmail());
		ArrayList<String> roles = recuperationInfoLogin.recuperationRole();
		model.addAttribute("roles", roles);
		/// 
		///firebase messagerie
		///
		Trajet userTraget = firebaseService.getUserTrajet();
		if(!userTraget.getId().equals(-1))
		{model.addAttribute("trajetMessage",userTraget);}
		 model.addAttribute("userEmail",recuperationInfoLogin.recuperationCompteForUserLogge().getEmail());
		
		 
		 
		 model.addAttribute("lastArticles",articleService.findLatestArticles());
		
		
		return "/home";
	}
	
	
	@RequestMapping(value = {"/displayArticle/{id}"},method=RequestMethod.GET)
	public String displayArticle(Model model, @PathVariable Integer id) {
		model.addAttribute("article",articleService.find(id).get());
		return "/displayArticle";
		
	}
	
	
	
}

