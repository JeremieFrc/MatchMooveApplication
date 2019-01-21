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

import com.societe.project.models.Car;
import com.societe.project.models.Profil;

/**
 * @author Fabrice
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarServiceTest {
	
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private CarRepository carRepository;
	

	
	@Test
	public void createAndFind() {
		Profil profil = new Profil("titi", "TITI", "0102030405");
		Car car = new Car("Citroen", "C3", 5, "AA-000-AA", profil);
		
		profilRepository.save(profil);
		carRepository.save(car);
		
		List<Car> cars = carRepository.findByMarque(car.getMarque());
		for (Car elt : cars) {
			assertThat(elt.getMarque()).isEqualTo(car.getMarque());
		}
		
		cars = carRepository.findByModele(car.getModele());
		for (Car elt : cars) {
			assertThat(elt.getModele()).isEqualTo(car.getModele());
		}
		
		cars = carRepository.findByImmatriculation(car.getImmatriculation());
		for (Car elt : cars) {
			assertThat(elt.getImmatriculation()).isEqualTo(car.getImmatriculation());
		}
	}
	
	@Test
	public void findAndDelete() {
		List<Car> cars = carRepository.findByMarque("Citroen");
		for (Car car : cars) {
			assertThat(car.getMarque().equals("Citroen"));
		}
		cars = carRepository.findByModele("C3");
		for (Car car : cars) {
			assertThat(car.getModele().equals("C3"));
		}
		cars = carRepository.findByImmatriculation("AA-000-AA");
		for (Car car : cars) {
			assertThat(car.getModele().equals("AA-000-AA"));
		}
		
	}
}
