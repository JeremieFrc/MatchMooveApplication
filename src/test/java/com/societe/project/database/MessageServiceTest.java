/**
 * 
 */
package com.societe.project.database;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.societe.project.models.Message;
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
public class MessageServiceTest {
	
	@Test
    public void createAndFind() {
		Date date = new Date();
		Trajet trajet = new Trajet();
		Profil profil = new Profil();
		Message message = new Message("mon message", date, trajet, profil);
		message.setContent("mon message");
		message.setDate(date);
		
		
	}

}
