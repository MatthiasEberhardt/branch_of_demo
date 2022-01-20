package com.example.demo.repository;

import com.example.demo.entity.delivery.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Integer> {
}
