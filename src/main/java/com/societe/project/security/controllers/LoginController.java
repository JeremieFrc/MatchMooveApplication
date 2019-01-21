package com.societe.project.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.societe.project.services.RecuperationInfoLoginService;

@Controller
public class LoginController {
	@Autowired
	RecuperationInfoLoginService recuperationInfoLogin;
	public static final String FORM_PASSWORD = "password";
	public static final String FORM_USERNAME = "username";
	private static final String SECURITY_LOGIN = "/security/login";
	public static final String LOGIN = "/login";

	@RequestMapping(value = { LOGIN }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("form_username",FORM_USERNAME);
		model.addAttribute("form_password",FORM_PASSWORD);
		

		
		return SECURITY_LOGIN;
	}
	
}
