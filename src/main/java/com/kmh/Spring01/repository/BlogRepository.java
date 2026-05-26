package com.kmh.Spring01.repository;

import com.kmh.Spring01.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}