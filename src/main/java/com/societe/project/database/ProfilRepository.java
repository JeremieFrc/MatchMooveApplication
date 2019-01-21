package com.societe.project.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Profil;

@Repository
public interface ProfilRepository extends BaseCRUDRepository<Profil> {

	List<Profil> findByFirstnameAndLastname(String firstname, String lastname);
	List<Profil> findByFirstname(String firstname);
	List<Profil> findByLastname(String lastname);

}
