package com.kmh.Spring01.dto;

import com.kmh.Spring01.dao.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() {
        //return new Article(title, content);
        return Article.builder().title(title).content(content).build();
    }
}
