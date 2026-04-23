package com.kmh.Spring01.controller;

import com.kmh.Spring01.dao.Article;
import com.kmh.Spring01.dto.ArticleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExampleController {
    @GetMapping("/thymleaf/example")
    public String thymeleafExample(Model model) {
        List< ArticleResponse> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArticleResponse a = new ArticleResponse(new Article("제목"+(i+1), (i+1)+"번째 내용"));
            list.add(a);
        }

        model.addAttribute("articles", list);
        model.addAttribute("name", "홍길동");
        //model.addAttribute("error", "검색오류 발생");
        Person p = new Person(1L, "고길동", 18, List.of("운동","독서","영화","음악","등산"));
        model.addAttribute("Person", p);
        return "example";
    }
}


@Getter
@AllArgsConstructor
class Person{
    private Long id;
    private String name;
    private int age;
    private List<String> hobbies;

}


