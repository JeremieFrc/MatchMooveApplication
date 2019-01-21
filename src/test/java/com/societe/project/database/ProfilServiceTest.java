/**
 * 
 */
package com.societe.project.database;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.societe.project.models.Profil;
import com.societe.project.models.Role;

/**
 * @author Fabrice
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfilServiceTest {
	
	@Autowired
	private ProfilRepository profilRepository;
	
	@Test
	public void createAndFind() {
		Profil profil = new Profil();
		
		profil.setFirstname("fab");
		profil.setLastname("TOTO");
		profil.setPhoneNumber("0200000000");
		
		profilRepository.save(profil);
		int idUser = profil.getId();
		
		Profil found = profilRepository.findById(idUser).get();
		assertThat(found.getId()).isEqualTo(profil.getId());
		
		found = profilRepository.findByFirstname(profil.getFirstname()).get(0);
		assertThat(found.getFirstname()).isEqualTo(profil.getFirstname());
		
		found = profilRepository.findByLastname(profil.getLastname()).get(0);
		assertThat(found.getLastname()).isEqualTo(profil.getLastname());
		
		found = profilRepository.findByFirstnameAndLastname("fab", "toto").get(0);
		assertThat(found.getFirstname() + found.getLastname()).isEqualTo(profil.getFirstname() + profil.getLastname());
		
		profil.getPhoneNumber().equals("0200000000");
		
		System.out.println(profil.toString());
		profil.afficheProfil();
	}
	
	@Test
	public void findAndDelete() {
		Profil finded = profilRepository.findByFirstname("fab").get(0);
		assertThat(finded.getFirstname().equals("fab"));
		
		finded = profilRepository.findByLastname("TOTO").get(0);
		assertThat(finded.getLastname().equals("TOTO"));
		
		profilRepository.delete(finded);
		List<Profil> deleted = profilRepository.findByFirstname("TOTO");
		assertThat(deleted).isEmpty();
	}
}
