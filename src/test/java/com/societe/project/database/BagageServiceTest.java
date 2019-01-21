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

import com.societe.project.models.Bagage;
import com.societe.project.models.Profil;
import com.societe.project.models.Trajet;

/**
 * @author Fabrice
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BagageServiceTest {
	
	@Autowired
	private BagageRepository bagageRepository;
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private TrajetRepository trajetRepository;
	
	@Test
    public void createAndFind() {
		Profil profil = new Profil("toto", "TOTO", "0102030405");
		Trajet trajet = new Trajet();
		Bagage bagage = new Bagage(10.5, profil, trajet);
		bagage.setVolume(10.5);
		bagage.setProfil(profil);
		bagage.setTrajet(trajet);
		
		profilRepository.save(profil);
		trajetRepository.save(trajet);
		bagageRepository.save(bagage);
		
		List<Bagage> bagages = bagageRepository.findByVolume(bagage.getVolume());
		for (Bagage elt : bagages) {
			assertThat(elt.getVolume()).isEqualTo(bagage.getVolume());
		}
		System.out.println(bagage.getTrajet().getNom());
		System.out.println(bagage.getProfil().getFirstname());
	}
	
	@Test
    public void findAndDelete() {
		List<Bagage> bagages = bagageRepository.findByVolume(10.5);
		for (Bagage elt : bagages) {
			assertThat(elt.getVolume().equals(10.5));
		}
		
		for (Bagage elt : bagages) {
			bagageRepository.delete(elt);
		}
		assertThat(bagages.isEmpty());
	}
}
