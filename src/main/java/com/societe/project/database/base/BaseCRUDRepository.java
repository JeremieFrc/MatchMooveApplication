package com.societe.project.database.base;

import org.springframework.data.repository.CrudRepository;

import com.societe.project.database.DBItem;



public interface BaseCRUDRepository<T extends DBItem> extends CrudRepository<T, Integer>  {
	
}
