package com.societe.project.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Car;

@Repository
public interface CarRepository extends BaseCRUDRepository<Car> {

	List<Car> findByMarque(String marque);
	List<Car> findByModele(String modele);
	List<Car> findByImmatriculation(String immatriculation);

}
