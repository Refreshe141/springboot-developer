package com.kmh.Spring01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "김민혁") String name) {
        return "반갑습니다 " + name + "님";
    }
    @GetMapping("/student")
    public Student getStudent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return new Student(firstName, lastName);
    }
    @GetMapping("/student/{firstName}/{lastName}")
    public Student getStudent2(@PathVariable("firstName")String firstName,@PathVariable("lastName")String lastName){
        return new Student(firstName, lastName);
    }


}
