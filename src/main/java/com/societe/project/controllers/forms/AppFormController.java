package com.societe.project.controllers.forms;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.societe.project.controllers.application.AdminController;
import com.societe.project.firebase.FirebaseService;
import com.societe.project.models.Adresse;
import com.societe.project.models.Compte;
import com.societe.project.models.Profil;
import com.societe.project.services.CompteService;
import com.societe.project.services.ProfilService;
import com.societe.project.services.RecuperationInfoLoginService;
import com.societe.project.services.RoleService;
import com.societe.project.validators.CompteValidator;
import com.societe.project.validators.Profvalidator;


@Controller
public class AppFormController {
	
	/*
	*************************************************
	*    @Constante
	*************************************************
	*/

	private static final String VUES 	           = "forms";
	
	private static final String URL_CREATE_COMPTE  = "/admin/createcompte";
	
	private static final String URL_LISTUSER_COMPTE  = "/admin/listuser";
	private static final String URL_UPDATE_COMPTE    = "/admin/edit";
	
	private static final String URL_DELETE_COMPTE   = "/admin/delete/{id}";
	
	private static final String VUE_CREATE_COMPTE    = VUES + "/createcompte";
	private static final String VUE_LISTUSER_COMPTE  = VUES + "/listeuser";
	
	/*
	*************************************************
	*    @private
	*************************************************
	*/
	@Autowired
	RecuperationInfoLoginService recuperationInfoLogin;
	@Autowired
	FirebaseService firebaseService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private CompteService compteService;
	
	@Autowired
	private ProfilService profilService;
	@Autowired
	private CompteValidator compteValidator;
	
	@Autowired
	private Profvalidator profilValidator;
	
	/*
	*************************************************
	*    @Mapping createCompte get && Post
	*************************************************
	*/	
	
	@RequestMapping(value= {AppFormController.URL_CREATE_COMPTE}, method=RequestMethod.GET)
	public String createCompteM(Model model) throws IOException {
		
		model.addAttribute("detailPath",URL_CREATE_COMPTE);
		model.addAttribute("roles", roleService.findAll());
		//model.addAttribute("trajetId",firebaseService.getTrajetId());
		model.addAttribute("userEmail",recuperationInfoLogin.recuperationCompteForUserLogge().getEmail());
		System.out.println("get de create user");
		
		return VUE_CREATE_COMPTE;
	}
	
	@RequestMapping(value= {AppFormController.URL_CREATE_COMPTE}, method=RequestMethod.POST)
	public String createCompteValidateM(@ModelAttribute Compte compte,@ModelAttribute Profil profil,@RequestParam String confirm, Model model) {
		
		System.out.println("Post de create user");
		System.out.println(confirm);
		System.out.println("------------------"+compte.getRole().getName());
		System.out.println("------------------"+compte.getRole().getId());
		compte.afficheCompte();
		profil.afficheProfil();

		boolean isvalid =false;
		
		if(!compteValidator.validateCompteAndPassWord(compte) && !profilValidator.validateProfil(profil) && compteValidator.isComparePass(compte.getPassword(),confirm)) {
			
			System.out.println("compte not exist");
			
			isvalid =true;
			
			compteService.getDto().createCompte(compte);
			compteService.getDto().createProfit(profil);
			compteService.getDto().getCreateCompte().afficheCompte();
			compteService.getDto().getCreateProfil().afficheProfil();	
			compteService.initElementTable();
			
		}else {
			System.out.println("error compte");
			System.out.println(compteValidator.getErrors().get("password"));
			model.addAttribute("detailPath",VUE_CREATE_COMPTE );
			model.addAttribute("roles", roleService.findAll());
			model.addAttribute("isExistMail",true);
			model.addAttribute("form",compteValidator.getErrors());
		}
		return (isvalid)? "redirect:"+AdminController.BASE_URL: VUE_CREATE_COMPTE;
	}
	
	
	/*
	*************************************************
	*    @Mapping /admin/listuser get && Post
	*************************************************
	*/	
	
	@RequestMapping(value= {AppFormController.URL_LISTUSER_COMPTE}, method=RequestMethod.GET)
	public String listUser(Model model) {
		
		System.out.println("Liste user");
		
		model.addAttribute("detailPath","/admin");
		model.addAttribute("roles", roleService.findAll());
		
		for (Profil p : profilService.findAll()) {
			p.afficheProfil();
			
			for (Adresse adr : p.getAdresses()) {
				adr.affAdress();
			}
		}
		for (Compte c : compteService.findAll()) {
				c.afficheCompte();
				c.getProfil().getFirstname();
				
				for (Adresse adr : c.getProfil().getAdresses()) {
					adr.affAdress();
				}
		}
		model.addAttribute("items",compteService.findAll());
		model.addAttribute("update", true);
		
		System.out.println("get list user");
		
		return VUE_LISTUSER_COMPTE;
	}
	
	@RequestMapping(value= {AppFormController.URL_UPDATE_COMPTE }, method=RequestMethod.POST)
	public String updateCopteUser(@ModelAttribute Compte compte,@ModelAttribute Profil profil) {
	
		System.out.println("update user");
	    compte.afficheCompte();
	    profil.afficheProfil();
	    System.out.println(compte.getRole().getName());
	    compte.getRole().getName();
	    System.out.println(compte.getRole().getName());
	  compteService.uptdateCompte(compte,profil);
		return "redirect:"+AdminController.BASE_URL;
	}
	
	@RequestMapping(value= {AppFormController.URL_DELETE_COMPTE }, method=RequestMethod.GET)
	public String delete(@ModelAttribute Compte compte,@PathVariable int id) {
	
		System.out.println("delete user");
		System.out.println(id);
		
		compteService.disableCompte(compte,id);
		
		return "redirect:"+AdminController.BASE_URL;
	}
}
