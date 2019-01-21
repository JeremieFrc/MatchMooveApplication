package com.societe.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.societe.project.controllers.base.BaseController;
import com.societe.project.models.Adresse;
import com.societe.project.services.AdresseService;
import com.societe.project.services.ProfilService;
import com.societe.project.services.base.BaseService;

@Controller
@RequestMapping(AdresseController.BASE_URL)
public class AdresseController extends BaseController<Adresse> {

	public static final String BASE_URL = "/adresses";
	private static final String BASE_PAGE_NAME = "Adresses";
	
	@Autowired
	private AdresseService adresseService;

	@Override
	protected BaseService<Adresse> getBaseService() {
		return adresseService;
	}

	@Override
	protected String getBaseURL() {
		return BASE_URL;
	}

	@Override
	protected String getBasePageName() {
		return BASE_PAGE_NAME;
	}

	@Autowired
	private ProfilService profilService;
	
	@Override
	protected void setOtherAttributes(Model model) {
		model.addAttribute("profils", profilService.findAll());
		
	}

	@Override
	protected void setupOtherFields(Adresse item) {
		item.setProfil(profilService.find(item.getProfil().getId()).get());
		
	}
	
}
