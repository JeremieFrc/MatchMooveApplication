package com.societe.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societe.project.database.ArticleRepository;
import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Article;
import com.societe.project.services.base.BaseService;

@Service
public class ArticleService extends BaseService<Article> {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	protected BaseCRUDRepository<Article> getCRUDRepository() {
		return articleRepository;
	}

	@Override
	protected List<Article> setItemsByCriterias(Article item, List<Article> result) {
		if (!item.getTitle().equals("")) {
			result = this.articleRepository.findByTitle(item.getTitle());
		} else if (!item.getDescription().trim().equals("")) {
			result = this.articleRepository.findByDescription(item.getDescription());
		} else if (!item.getDate().equals(null)) {
			result = this.articleRepository.findByDate(item.getDate());
		}
		return result;
	}
  
	public List<Article>findLatestArticles()
	{
		return this.articleRepository.findTop3ByOrderByDateDesc();
		
	}
}
