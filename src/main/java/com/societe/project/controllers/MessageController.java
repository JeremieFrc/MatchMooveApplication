package com.societe.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.societe.project.controllers.base.BaseController;
import com.societe.project.models.Message;
import com.societe.project.services.MessageService;
import com.societe.project.services.ProfilService;
import com.societe.project.services.TrajetService;
import com.societe.project.services.base.BaseService;

@Controller
@RequestMapping(MessageController.BASE_URL)
public class MessageController extends BaseController<Message> {
	
	public static final String BASE_URL = "/messages";
	private static final String BASE_PAGE_NAME = "messages";
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private TrajetService trajetService;
	@Autowired
	private ProfilService profilService;

	@Override
	protected BaseService<Message> getBaseService() {
		return messageService;
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
		//model.addAttribute("trajets",trajetService.findAll());
	    //	model.addAttribute("profils",profilService.findAll());
		
	}
	
    
	@Override
	protected void setupOtherFields(Message item) {
		item.setTrajet(trajetService.find(item.getTrajet().getId()).get());
		item.setProfil(profilService.find(item.getProfil().getId()).get());
		
		
	}


}

