package com.societe.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.societe.project.controllers.base.BaseController;
import com.societe.project.models.Trajet;
import com.societe.project.services.TrajetService;
import com.societe.project.services.base.BaseService;

@Controller
@RequestMapping(TrajetController.BASE_URL)
public class TrajetController extends BaseController<Trajet> {
	
	public static final String BASE_URL = "/trajets";
	private static final String BASE_PAGE_NAME = "trajets";
	
	@Autowired
	private TrajetService trajetService;

	@Override
	protected BaseService<Trajet> getBaseService() {
		return trajetService;
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
	protected void setupOtherFields(Trajet item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setOtherAttributes(Model model) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
