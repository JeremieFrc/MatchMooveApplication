package com.societe.project.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CguController {
	
	@RequestMapping(value = {"/cgu/cgu"})
	public String showPage(Model model) throws IOException {
		return "/cgu/cgu";
	}

}
