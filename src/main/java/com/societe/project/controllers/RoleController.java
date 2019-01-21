package com.societe.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.societe.project.controllers.base.BaseController;
import com.societe.project.models.Role;
import com.societe.project.services.ProfilService;
import com.societe.project.services.RoleService;
import com.societe.project.services.base.BaseService;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping(RoleController.BASE_URL)
public class RoleController extends BaseController<Role> {

	public static final String BASE_URL = "/roles";
	private static final String BASE_PAGE_NAME = "Roles";
	
	@Autowired
	private RoleService roleService;
	
	@Override
	protected BaseService<Role> getBaseService() {
		return roleService;
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
	ProfilService profilService;

	@Override
	protected void setOtherAttributes(Model model) {
		model.addAttribute("profils", profilService.findAll());
		
	}

	@Override
	protected void setupOtherFields(Role item) {
		//item.setProfil(profilService.find(item.getProfil().getId()).get());
	}

}
