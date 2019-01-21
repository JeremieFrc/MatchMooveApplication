package com.societe.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societe.project.database.AdresseRepository;
import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Adresse;
import com.societe.project.services.base.BaseService;

@Service
public class AdresseService extends BaseService<Adresse> {

	@Autowired
	private AdresseRepository adresseRepository;
	
	@Override
	protected BaseCRUDRepository<Adresse> getCRUDRepository() {
		return adresseRepository;
	}

	@Override
	protected List<Adresse> setItemsByCriterias(Adresse item, List<Adresse> result) {
		if (!item.getVille().equals("")) {
			result = this.adresseRepository.findByVille(item.getVille());
		} else if (!item.getRue().equals("")) {
			result = this.adresseRepository.findByRue(item.getRue());
		}
		return result;
	}
	
	
}
