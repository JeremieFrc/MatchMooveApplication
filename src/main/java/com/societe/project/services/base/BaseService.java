package com.societe.project.services.base;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.societe.project.database.DBItem;
import com.societe.project.database.base.BaseCRUDRepository;


public abstract class BaseService<T extends DBItem> {

	protected abstract BaseCRUDRepository<T> getCRUDRepository();
	protected abstract List<T> setItemsByCriterias(T item, List<T> result);
	
	public void save(T item) {
		this.getCRUDRepository().save(item);
	}

	public void delete(T item) {
		this.getCRUDRepository().delete(item);
	}

	public void deleteById(Integer id) {
		this.getCRUDRepository().deleteById(id);
	}

	public Optional<T> find(Integer id) {
		return this.getCRUDRepository().findById(id);
	}

	public Iterable<T> findAll() {
		return this.getCRUDRepository().findAll();
	}

	public List<T> findWithCriteria(T item) {
		List<T> result = new ArrayList<T>();
		result = setItemsByCriterias(item, result);
		return result;
	}

	public void delete(List<T> items) {
		this.getCRUDRepository().deleteAll(items);
	}
	
}
