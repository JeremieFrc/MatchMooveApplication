package com.societe.project.database;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Article;

@Repository
public interface ArticleRepository extends BaseCRUDRepository<Article> {

	List<Article> findByTitle(String title);
	List<Article> findByDescription (String description);
	List<Article> findByDate (Date date);
	List<Article> findTop3ByOrderByDateDesc();

}
