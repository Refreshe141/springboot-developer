package com.kmh.Spring01.controller;

import com.kmh.Spring01.dao.Article;
import com.kmh.Spring01.dto.AddArticleRequest;
import com.kmh.Spring01.dto.ArticleResponse;
import com.kmh.Spring01.dto.UpdateArticleRequest;
import com.kmh.Spring01.repository.BlogRepository;
import com.kmh.Spring01.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor//응답으로 데이터를 반환
public class BLogController {
    private final BlogRepository blogRepository;
    private final BlogService blogService;


    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest articleRequest) {

        Article article = blogService.save(articleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);


    }
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>>findAllArticles() {
        List<Article> articles = blogRepository.findAll();
        List<ArticleResponse> result = articles.stream().map(ArticleResponse::new).toList();
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id) {
        Article article = blogService.findById(id);
        return ResponseEntity.ok().body(new ArticleResponse(article));
    }


    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
                                                 @RequestBody  UpdateArticleRequest request) {
        Article updatedArticle = blogService.update(id, request);
        return ResponseEntity.ok().body(updatedArticle);

    }




}
