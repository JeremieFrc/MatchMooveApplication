package com.societe.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.societe.project.controllers.base.BaseController;
import com.societe.project.models.Compte;
import com.societe.project.services.CompteService;
import com.societe.project.services.ProfilService;
import com.societe.project.services.RoleService;
import com.societe.project.services.base.BaseService;

@Controller
@RequestMapping(CompteController.BASE_URL)
@Secured("ROLE_ADMIN")
public class CompteController extends BaseController<Compte> {

	public static final String BASE_URL = "/comptes";
	private static final String BASE_PAGE_NAME = "Comptes";
	
	@Autowired
	private CompteService compteService;

	@Override
	protected BaseService<Compte> getBaseService() {
		return compteService;
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
	private RoleService roleService;
	
	@Autowired
	private ProfilService profilService;
	
	@Override
	protected void setOtherAttributes(Model model) {
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("profils", profilService.findAll());
	}

	@Override
	protected void setupOtherFields(Compte item) {
		item.setRole(roleService.find(item.getRole().getId()).get());
		item.setProfil(profilService.find(item.getProfil().getId()).get());
	}

}
