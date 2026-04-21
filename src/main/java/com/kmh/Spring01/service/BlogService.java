package com.kmh.Spring01.service;

import com.kmh.Spring01.dao.Article;
import com.kmh.Spring01.dto.AddArticleRequest;
import com.kmh.Spring01.dto.UpdateArticleRequest;
import com.kmh.Spring01.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    // 1. void를 Article(반환 타입)로 변경
    public Article save(AddArticleRequest articleRequest) {

        // 2. 앞에 return을 붙여서 저장된 결과를 돌려줌
        return blogRepository.save(articleRequest.toEntity());

    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("not found:" +id));

    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request) {
       Article article = blogRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("not found:" +id));
       article.update(request.getTitle(), request.getContent());
       return article;
    }

}

