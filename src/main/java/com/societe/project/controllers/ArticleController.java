package com.societe.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.societe.project.controllers.base.BaseController;
import com.societe.project.models.Article;
import com.societe.project.services.ArticleService;
import com.societe.project.services.CompteService;
import com.societe.project.services.base.BaseService;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping(ArticleController.BASE_URL)
public class ArticleController extends BaseController<Article> {

	public static final String BASE_URL = "/articles";
	private static final String BASE_PAGE_NAME = "Articles";
	
	@Autowired
	private ArticleService articleService;
	
	@Override
	protected BaseService<Article> getBaseService() {
		return articleService;
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
	private CompteService compteService;
	
	@Override
	protected void setOtherAttributes(Model model) {
		//model.addAttribute("comptes", compteService.findAll());
	 	
	}
	
	@Override
	protected void setupOtherFields(Article item) {
		item.setCompte(compteService.find(item.getCompte().getId()).get());
	}
	
}
