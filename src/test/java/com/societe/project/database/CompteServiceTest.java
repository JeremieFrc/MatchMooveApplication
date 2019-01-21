/**
 * 
 */
package com.societe.project.database;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.societe.project.models.Compte;
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
public class CompteServiceTest {
	
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Test
    public void createAndFind() {
		Role role = new Role("ROLE_ADMIN");
		Profil profil = new Profil("toto", "TOTO", "0102030405");
		Compte compte = new Compte("test@test.com", "password", role, profil);
		
		compte.setActive(1);
		compte.setEmail("test@test.com");
		compte.setPassword("password");
		compte.setRole(role);
		compte.setProfil(profil);
		
		profilRepository.save(profil);
		roleRepository.save(role);
		compteRepository.save(compte);
		int idCompte = compte.getId();
		
		Compte found = compteRepository.findById(idCompte).get();
		assertThat(found.getId()).isEqualTo(compte.getId());
		
		found = compteRepository.findByEmail(compte.getEmail());
		assertThat(found.getEmail()).isEqualTo(compte.getEmail());
		
		compte.afficheCompte();
	}
	
	@Test
	public void findAndDelete() {
		Compte finded = compteRepository.findByEmail("test@test.com");
		assertThat(finded.getEmail().equals("test@test.com"));
		
		compteRepository.delete(finded);
		Compte deleted = compteRepository.findByEmail("test@test.com");
		assertThat(deleted).isNull();
	}
}
