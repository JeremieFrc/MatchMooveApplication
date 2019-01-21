package com.societe.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.societe.project.controllers.base.BaseController;
import com.societe.project.models.Car;
import com.societe.project.services.CarService;
import com.societe.project.services.ProfilService;
import com.societe.project.services.base.BaseService;

@Controller
@RequestMapping(CarController.BASE_URL)
public class CarController extends BaseController<Car> {

	public static final String BASE_URL = "/cars";
	private static final String BASE_PAGE_NAME = "Cars";
	
	@Autowired
	private CarService carService;
	
	@Override
	protected BaseService<Car> getBaseService() {
		return carService;
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
	protected void setupOtherFields(Car item) {
		item.setProfil(profilService.find(item.getProfil().getId()).get());
		
	}
}
