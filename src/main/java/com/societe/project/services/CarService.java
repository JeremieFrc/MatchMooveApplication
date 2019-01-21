package com.societe.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societe.project.database.CarRepository;
import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Car;
import com.societe.project.services.base.BaseService;

@Service
public class CarService extends BaseService<Car> {

	@Autowired
	private CarRepository carRepository;
	
	@Override
	protected BaseCRUDRepository<Car> getCRUDRepository() {
		return carRepository;
	}

	@Override
	protected List<Car> setItemsByCriterias(Car item, List<Car> result) {
		if (!item.getMarque().equals("")) {
			result = this.carRepository.findByMarque(item.getMarque());
		}else if (!item.getModele().equals("")) {
			result = this.carRepository.findByModele(item.getModele());
		}else if (!item.getImmatriculation().equals("")) {
			result = this.carRepository.findByImmatriculation(item.getImmatriculation());
		}
		return result;
	}

}
