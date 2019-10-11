package com.example.sweater.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Этот класс содержит конфигарцию ВЭБ слоя. Раздаются шаблны страничек, на котор нет никакой логики.
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/home").setViewName("home");   Это все уже замаппено
//        registry.addViewController("/").setViewName("home");       Это все уже замаппено
//        registry.addViewController("/hello").setViewName("hello"); Это все уже замаппено
        registry.addViewController("/login").setViewName("login"); //Сприрнг предоставляет систему авторизации
    }
}
