package com.societe.project.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.societe.project.database.CompteRepository;
import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.dto.CompteProfilDto;
import com.societe.project.models.Compte;
import com.societe.project.models.Profil;

import com.societe.project.services.base.BaseService;

@Service
public class CompteService extends BaseService<Compte> {

	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private CompteProfilDto dto;
	
	@Autowired
	private ProfilService profilService;
	

	
	@Override
	protected BaseCRUDRepository<Compte> getCRUDRepository() {
		return compteRepository;
	}

	public CompteProfilDto getDto() {
		return dto;
	}

	public void setDto(CompteProfilDto dto) {
		this.dto = dto;
	}
	

//	@Override
//	protected List<Compte> setItemsByCriterias(Compte item, List<Compte> result) {
//		if (!item.getEmail().equals("")) {
//			result = this.compteRepository.findByEmail(item.getEmail());
//		}
//		return result;
//	}

	@Override
	public void save(Compte item) {
		item.setPassword(bCryptPasswordEncoder.encode(item.getPassword()));
		super.save(item);
	}

	
	@Override
	protected List<Compte> setItemsByCriterias(Compte item, List<Compte> result) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Compte findByEmail(String email) {
		return compteRepository.findByEmail(email);
	}

	public Compte finByEmailCompte(String email) {
		
		return compteRepository.findByEmail(email);
	}
	
	public void initElementTable() {
		
		Compte compte = dto.getCreateCompte();
		Profil profil = dto.getCreateProfil();

		profilService.save(profil);
		compte.setProfil(profil);
	
		compte.setActive(1);
		
		this.save(compte);	
	}
	
	public void uptdateCompte(Compte compte,Profil profil) {
		
		compte.afficheCompte();
		profil.afficheProfil();
		
		
		//update element
		//lie ensemble 
		Compte c = compteRepository.findById(compte.getId()).get();
		profil.setId(c.getProfil().getId());

		profil.setPhoneNumber(c.getProfil().getPhoneNumber());
		
//		if(c.getRole() != compte.getRole()) {
//			compte.setId(roleService.finByNameRole(compte.getRole().getName()));
//		}
		//profil
		c.setProfil(profil);
		//uptadate compte 
		profilService.save(profil);
	
		compte.setProfil(profil);
		
		if(compte.getPassword()!=null) {
			this.save(compte);
		}else {
			compte.setPassword(c.getPassword());
		}
		
		compte.setActive(1);
		compteRepository.save(compte);
	
	}
	
	public void disableCompte(Compte compte,int id) {
		
		Compte c = compteRepository.findById(id).get();
		c.setActive(0);
		compteRepository.save(c);
	}
	
	
	
	


}
