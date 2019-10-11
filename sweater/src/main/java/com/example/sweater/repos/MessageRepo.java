package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);//Имя метода ключево слово ФАЙНД и бай -
    // переход к слову котор ищем tag - указано в сущности Message.java
    // эти правила описаны в spring JPA (SQL методы)
    // https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation

}

