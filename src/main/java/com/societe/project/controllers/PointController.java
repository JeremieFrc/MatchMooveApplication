package com.societe.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.societe.project.controllers.base.BaseController;
import com.societe.project.models.Point;
import com.societe.project.services.PointService;
import com.societe.project.services.TrajetService;
import com.societe.project.services.base.BaseService;


@Controller
@RequestMapping(PointController.BASE_URL)
public class PointController extends BaseController<Point> {
	
	public static final String BASE_URL = "/points";
	private static final String BASE_PAGE_NAME = "Points";
	
	@Autowired
	private PointService pointService;
	@Autowired
	private TrajetService trajetService;


	@Override
	protected BaseService<Point> getBaseService() {
		return pointService;
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
		model.addAttribute("trajets", trajetService.findAll());
		
		
	}
	
    
	@Override
	protected void setupOtherFields(Point item) {
		item.setTrajet(trajetService.find(item.getTrajet().getId()).get());
		
	}


}
