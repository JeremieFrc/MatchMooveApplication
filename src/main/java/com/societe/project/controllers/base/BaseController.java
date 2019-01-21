package com.societe.project.controllers.base;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.societe.project.database.DBItem;
import com.societe.project.dtos.base.BaseDeleteCriteriaDTO;
import com.societe.project.firebase.FirebaseService;
import com.societe.project.services.RecuperationInfoLoginService;
import com.societe.project.services.base.BaseService;


//@PreAuthorize ("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
public abstract class BaseController<T extends DBItem> {

	private static final String BASE_ATTRIBUT_LIST = "items";
	private static final String BASE_ATTRIBUT = "item";
	
	protected abstract BaseService<T> getBaseService();
	protected abstract String getBaseURL();
	protected abstract String getBasePageName();
	protected abstract void setOtherAttributes(Model model);
	protected abstract void setupOtherFields(T item);
	@Autowired
	RecuperationInfoLoginService recuperationInfoLogin;
	@Autowired
	FirebaseService firebaseService;
	
	@RequestMapping(value= {"","/","/index"}, method=RequestMethod.GET)
	public String index(Model model) throws IOException {
		model.addAttribute(BASE_ATTRIBUT_LIST,this.getBaseService().findAll());
		model.addAttribute("pageName",this.getBasePageName()+" index");
		model.addAttribute("detailPath",this.getBaseURL());
		//model.addAttribute("trajetId",firebaseService.getTrajetId());
		model.addAttribute("userEmail",recuperationInfoLogin.recuperationCompteForUserLogge().getEmail());
		return this.getBaseURL()+"/index";
		
	}
	
	
	@RequestMapping(value= {"/delete/{id}"}, method=RequestMethod.GET)
	public String deleteId(Model model, @PathVariable Integer id) {
		this.getBaseService().deleteById(id);
		return "redirect:"+this.getBaseURL()+"/index";
	}
	
	
	@RequestMapping(value= {"/delete"}, method=RequestMethod.GET)
	public String deleteCriteria(Model model) {
		model.addAttribute("pageName",this.getBasePageName()+" deletion criteria");
		model.addAttribute("detailPath",this.getBaseURL());
		return this.getBaseURL()+"/delete";
	}
	
	
	@RequestMapping(value= {"/delete"}, method=RequestMethod.POST)
	public String deleteCriteriaSearch(Model model, @ModelAttribute T item) {
		List<T> items = this.getBaseService().findWithCriteria(item);
		if (items.size() > 0) {
			model.addAttribute(BASE_ATTRIBUT_LIST,items);
		}else {
			model.addAttribute("notFound","No match");
		}
		
		model.addAttribute("pageName",this.getBasePageName()+" deletion criteria");
		model.addAttribute("detailPath",this.getBaseURL());
		return this.getBaseURL()+"/delete";
	}
	
	
	@RequestMapping(value= {"/deletecriteria"}, method=RequestMethod.POST)
	public String deleteCriteriaDelete(@ModelAttribute BaseDeleteCriteriaDTO<T> form) {
		this.getBaseService().delete(form.getItems());
		return "redirect:"+this.getBaseURL()+"/delete";
	}
	
	@RequestMapping(value= {"/find"}, method=RequestMethod.GET)
	public String findCriteria(Model model) {
		model.addAttribute("pageName",this.getBasePageName()+" find criteria");
		model.addAttribute("detailPath",this.getBaseURL());
		return this.getBaseURL()+"/find";
	}
	
	@RequestMapping(value= {"/find"}, method=RequestMethod.POST)
	public String findCriteriaSearch(Model model, @ModelAttribute T item) {
		List<T> items = this.getBaseService().findWithCriteria(item);
		if (items.size() > 0) {
			model.addAttribute(BASE_ATTRIBUT_LIST,items);
		}else {
			model.addAttribute("notFound","No match");
		}
		
		model.addAttribute("pageName",this.getBasePageName()+" find criteria");
		model.addAttribute("detailPath",this.getBaseURL());
		return this.getBaseURL()+"/find";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("pageName",this.getBasePageName()+" create");
		model.addAttribute("detailPath",this.getBaseURL());
		this.setOtherAttributes(model);
		return this.getBaseURL()+"/edit";
	}
	
	@RequestMapping(value= {"/edit/{id}"}, method=RequestMethod.GET)
	public String edit(Model model, @PathVariable Integer id) {
		model.addAttribute(BASE_ATTRIBUT,this.getBaseService().find(id).get());
		model.addAttribute("pageName",this.getBasePageName()+" edit");
		model.addAttribute("detailPath",this.getBaseURL());
		this.setOtherAttributes(model);
		return this.getBaseURL()+"/edit";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.POST)
	public String editSave(@ModelAttribute T item) {
		//this.setupOtherFields(item);
		this.getBaseService().save(item);
		return "redirect:"+this.getBaseURL()+"/index";
	}
	
	@RequestMapping(value= {"/edit"}, method=RequestMethod.DELETE)
	public String editDelete() {
		return "redirect:"+this.getBaseURL()+"/index";
	}
}
