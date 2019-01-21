package com.societe.project.database;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Trajet;

@org.springframework.stereotype.Repository
public interface TrajetRepository extends BaseCRUDRepository<Trajet> {
	
	List<Trajet> findByNom(String nom);
	List<Trajet> findByPerimetre(Double perimetre);
	List<Trajet> findByDateDepart(Date date);

	List<Trajet> findByHeureDepartAndMinuteDepart(Integer heure,Integer minute);
	
	//@Query("select id from trajet innerjoin pt on pt.trajet_id = trajet_id where " )
	//List<Trajet> getTrajetByCompteEmail(String email);



}