/**
 * 
 */
package com.societe.project.database;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.societe.project.models.Adresse;
import com.societe.project.models.Profil;

/**
 * @author Fabrice
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdresseServiceTest {

	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private AdresseRepository adresseRepository;

	@Test
    public void createAndFind() {
		
		Profil profil = new Profil("toto", "TOTO", "0102030405");
		Adresse adresse = new Adresse(1, "rue de rennes", 35000, "Rennes", true, profil);
		adresse.setNumero(1);
		adresse.setRue("rue de rennes");
		adresse.setCp(35000);
		adresse.setVille("Rennes");
		adresse.setDomicile(true);
		adresse.setProfil(profil);
		
		profilRepository.save(profil);
		adresseRepository.save(adresse);
		
		List<Adresse> adresses = adresseRepository.findByRue(adresse.getRue());
		for (Adresse elt : adresses) {
			assertThat(elt.getRue()).isEqualTo(adresse.getRue());
		}
		
		adresses = adresseRepository.findByVille(adresse.getVille());
		for (Adresse elt : adresses) {
			assertThat(elt.getVille()).isEqualTo(adresse.getVille());
		}
	}
	
	@Test
    public void findAndDelete() {
		List<Adresse> adresses = adresseRepository.findByRue("rue de rennes");
		for (Adresse adresse : adresses) {
			assertThat(adresse.getRue().equals("rue de rennes"));
		}
		
		adresses = adresseRepository.findByVille("Rennes");
		for (Adresse adresse : adresses) {
			assertThat(adresse.getRue().equals("Rennes"));
		}
		
		for (Adresse adresse : adresses) {
			adresseRepository.delete(adresse);
		}
		assertThat(adresses.isEmpty());
		
		List<Profil> profils = profilRepository.findByFirstname("toto");
		for (Profil profil : profils) {
			profilRepository.delete(profil);
		}
		assertThat(profils.isEmpty());
	}

}
