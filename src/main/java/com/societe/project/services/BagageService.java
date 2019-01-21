package com.societe.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societe.project.database.AdresseRepository;
import com.societe.project.database.BagageRepository;
import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Bagage;
import com.societe.project.services.base.BaseService;
@Service
public class BagageService extends BaseService<Bagage> {


	@Autowired
	private BagageRepository bagageRepository;
	
	@Override
	protected BaseCRUDRepository<Bagage> getCRUDRepository() {
		
		return bagageRepository;
	}

	@Override
	protected List<Bagage> setItemsByCriterias(Bagage item, List<Bagage> result) {

		if (!item.getVolume().equals(null)) {

			result = this.bagageRepository.findByVolume(item.getVolume());
		} 
		return result;
	}

	

}
