/**
 * 
 */
package com.societe.project.database;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.societe.project.models.Article;
import com.societe.project.models.Compte;

/**
 * @author Fabrice
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticleServiceTest {

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private ArticleRepository articleRepository;
	
	@Test
    public void createAndFind() {
		Date date = new Date();
		Compte compte = new Compte("test@test.com", "password", 1);
		Article article = new Article("titre", "description", date, compte);
		article.setTitle("titre");
		article.setDescription("description");
		article.setDate(date);
		article.setCompte(compte);

		compteRepository.save(compte);
		articleRepository.save(article);
		
		List<Article> articles = articleRepository.findByTitle(article.getTitle());
		for (Article elt : articles) {
			assertThat(elt.getTitle()).isEqualTo(article.getTitle());
		}
		
		articles = articleRepository.findByDescription(article.getDescription());
		for (Article elt : articles) {
			assertThat(elt.getDescription()).isEqualTo(article.getDescription());
		}
		System.out.println(article.getCompte().getEmail());
		System.out.println(article.getDate());
	}
	
	@Test
    public void findAndDelete() {
		List<Article> articles = articleRepository.findByTitle("titre");
		for (Article elt : articles) {
			assertThat(elt.getTitle().equals("titre"));
		}
		
		articles = articleRepository.findByDescription("description");
		for (Article elt : articles) {
			assertThat(elt.getDescription().equals("description"));
		}
		Compte compte = compteRepository.findByEmail("test@test.com");
		compteRepository.delete(compte);
	}
}
