package com.dosug.demo.controller;


import com.dosug.demo.model.Event;
import com.dosug.demo.model.KeyWords;
import com.dosug.demo.model.User;
import com.dosug.demo.repo.EventRepo;
import com.dosug.demo.repo.KeyWordsRepo;
import com.dosug.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        KeyWords keyWords = new KeyWords();
        keyWords.setKeywordId(UUID.randomUUID());
        keyWords.setKeyWord(keyword);
        user.setUserId(UUID.randomUUID());
        user.setKeyWords(keyWords);
        keyWords.setUser(user);
        return userRepo.save(user);
    }

}
