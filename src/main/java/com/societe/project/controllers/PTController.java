package com.societe.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.societe.project.controllers.base.BaseController;
import com.societe.project.models.PT;
import com.societe.project.models.Trajet;
import com.societe.project.services.PTService;
import com.societe.project.services.ProfilService;
import com.societe.project.services.TrajetService;
import com.societe.project.services.base.BaseService;

@Controller
@RequestMapping(PTController.BASE_URL)
public class PTController extends BaseController<PT> {
	
	public static final String BASE_URL = "/pts";
	private static final String BASE_PAGE_NAME = "pts";
	
	@Autowired
	private PTService ptService;
	@Autowired
	private TrajetService trajetService;
	@Autowired
	private ProfilService profilService;

	@Override
	protected BaseService<PT> getBaseService() {
		return ptService;
	}

	@Override
	protected String getBaseURL() {
		return BASE_URL;
	}

	@Override
	protected String getBasePageName() {
		return BASE_PAGE_NAME;
	}
 

	@Override
	protected void setOtherAttributes(Model model) {
		model.addAttribute("trajets",trajetService.findAll());
		model.addAttribute("profils",profilService.findAll());
		
	}
	
    
	@Override
	protected void setupOtherFields(PT item) {
		item.setTrajet(trajetService.find(item.getTrajet().getId()).get());
		item.setProfil(profilService.find(item.getProfil().getId()).get());
	}


}
