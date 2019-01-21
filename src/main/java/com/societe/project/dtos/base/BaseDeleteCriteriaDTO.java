package com.societe.project.dtos.base;

import java.util.ArrayList;
import java.util.List;

import com.societe.project.database.DBItem;

public abstract class BaseDeleteCriteriaDTO <T extends DBItem> {

	List<T> items;

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public BaseDeleteCriteriaDTO() {
		this.items = new ArrayList<T>();
	}
}
