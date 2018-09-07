package com.dosug.demo.controller;


import com.dosug.demo.model.Event;
import com.dosug.demo.model.KeyWords;
import com.dosug.demo.model.User;
import com.dosug.demo.repo.EventRepo;
import com.dosug.demo.repo.KeyWordsRepo;
import com.dosug.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class TestApiController {

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private KeyWordsRepo keyWordsRepo;

    @RequestMapping(value = "getEvent",method = RequestMethod.GET)
    public @ResponseBody
    List<Event> getEvents(){
        return eventRepo.findAll();
    }

    @RequestMapping(value = "getEventByWord/{find}" , method = RequestMethod.GET)
    public @ResponseBody
    List<Event> findByWords(@PathVariable String find){
        return eventRepo.findByDescriptionIgnoreCaseContains(find);
    }


    @RequestMapping(value = "createUser/{keyword}" , method = RequestMethod.POST)
    public @ResponseBody
    User createUser(@PathVariable String keyword){
        User user = new User();
        user.setUserId(UUID.randomUUID());
        KeyWords keyWords = new KeyWords();
        user.setKeyWords(keyWords);
        keyWords.setKeywordId(UUID.randomUUID());
        keyWords.setKeyWord(keyword);
        return userRepo.save(user);
    }

}
