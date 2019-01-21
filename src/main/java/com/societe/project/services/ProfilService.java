package com.societe.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societe.project.database.ProfilRepository;
import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Profil;
import com.societe.project.services.base.BaseService;

@Service
public class ProfilService extends BaseService<Profil> {

	@Autowired
	private ProfilRepository profilRepository;
	
	@Override
	protected BaseCRUDRepository<Profil> getCRUDRepository() {
		return profilRepository;
	}

	@Override
	protected List<Profil> setItemsByCriterias(Profil item, List<Profil> result) {
		if (!item.getFirstname().equals("") && !item.getLastname().equals("")) {
			result = this.profilRepository.findByFirstnameAndLastname(item.getFirstname(), item.getLastname());
		} else if (!item.getFirstname().equals("")) {
			result = this.profilRepository.findByFirstname(item.getFirstname());
		} else if (!item.getLastname().equals("")) {
			result = this.profilRepository.findByLastname(item.getLastname());
		}
		return result;
	}
	
	public void saveProfil(Profil profil) {
		//utilise les methode de crudRepository
		profilRepository.save(profil);
	}
	

}
