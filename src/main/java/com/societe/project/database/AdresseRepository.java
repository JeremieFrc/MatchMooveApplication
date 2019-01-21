package com.societe.project.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Adresse;

@Repository
public interface AdresseRepository extends BaseCRUDRepository<Adresse> {

	List<Adresse> findByRue(String rue);
	List<Adresse> findByVille(String ville);
	
}
