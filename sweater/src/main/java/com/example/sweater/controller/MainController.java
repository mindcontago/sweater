



package com.example.sweater.controller;


import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/main") //RequestParam выдергивается из формы (мусташ), либо из УРЛа если передаем ГЕТ запрос
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message); //We saved this - Message message = new Message(text, tag);
        //Now we want to return list of messages from DataBase

        //We took from repo
        Iterable<Message> messages = messageRepo.findAll();
        //And put it to model
        model.put("messages", messages);
        //Return to user
        return "main";
    }

    @PostMapping("/filter") //Надо найти по переданному тегу все сообщения, создаем метод в репозитории
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;//Здесь Iterable  потому что findAll  возвр Iterable
        //FindByTag возвр лист

        if (filter != null && !filter.isEmpty()) { //Если фильт был задан и задан не пустым
            messages = messageRepo.findByTag(filter); //то ищем по тэгу
        } else {
            messages = messageRepo.findAll(); //иначе показываем все
        }
        model.put("messages", messages);
        return "main";

    }
}
