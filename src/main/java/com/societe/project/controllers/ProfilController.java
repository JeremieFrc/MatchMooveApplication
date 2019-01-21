package com.societe.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.societe.project.controllers.base.BaseController;
import com.societe.project.models.Profil;
import com.societe.project.services.CompteService;
import com.societe.project.services.ProfilService;
import com.societe.project.services.base.BaseService;

@Controller
@RequestMapping(ProfilController.BASE_URL)
public class ProfilController extends BaseController<Profil> {

	public static final String BASE_URL = "/profils";
	private static final String BASE_PAGE_NAME = "Profils";
	
	@Autowired
	private ProfilService profilService;

	@Override
	protected BaseService<Profil> getBaseService() {
		return profilService;
	}

	@Override
	protected String getBaseURL() {
		return BASE_URL;
	}

	@Override
	protected String getBasePageName() {
		return BASE_PAGE_NAME;
	}

//	@Autowired
//	private CompteService compteService;
	
	@Override
	protected void setOtherAttributes(Model model) {
//		model.addAttribute("comptes", compteService.findAll());
	}

	@Override
	protected void setupOtherFields(Profil item) {
//		item.setCompte(compteService.find(item.getCompte().getId()).get());
	}
	
	
}
