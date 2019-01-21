package com.societe.project.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.PT;
import com.societe.project.models.Trajet;
@Repository
public interface PTRepository extends BaseCRUDRepository<PT>{

	//List<PT> findByNbrePlaceAndVolumeMax(Integer nbrePlace, Double volumeMax);

	List<PT> findByNbrePlace(Integer nbrePlace);
	List<PT> findByVolumeMax(Double volumeMax);
	PT findByTrajet(Integer id);
	
//	@Modifying
//	@Query(value = "insert into pt (nbre_place, volume_max, profil_id, trajet_id) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
//	void insertPt(Integer nbre_place, Double volume_max, Integer profil_id, Integer trajet_id);
	
	//Normalement il faudrait faire une requete HQL
	@Query (value = "SELECT DISTINCT trajet_id, id, nbre_place,volume_max,profil_id FROM pt GROUP BY trajet_id", nativeQuery = true)
	List<PT> findAllPts();
	
}
