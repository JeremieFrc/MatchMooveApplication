package com.societe.project.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Role;

@Repository
public interface RoleRepository extends BaseCRUDRepository<Role> {

	List<Role> findByName(String name);
	
}
