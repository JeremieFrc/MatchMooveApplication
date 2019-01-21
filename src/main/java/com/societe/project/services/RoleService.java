package com.societe.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societe.project.database.RoleRepository;
import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Role;
import com.societe.project.services.base.BaseService;

@Service
public class RoleService extends BaseService<Role> {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	protected List<Role> setItemsByCriterias(Role item, List<Role> result) {
		if (!item.getName().equals("")) {
			result = this.roleRepository.findByName(item.getName());
		}
		return result;
	}

	@Override
	protected BaseCRUDRepository<Role> getCRUDRepository() {
		return roleRepository;
	}
	
	

}
