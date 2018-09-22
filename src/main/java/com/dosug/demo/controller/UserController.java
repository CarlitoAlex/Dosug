package com.dosug.demo.controller;

import com.dosug.demo.model.Category;
import com.dosug.demo.model.Event;
import com.dosug.demo.model.KeyWords;
import com.dosug.demo.model.User;
import com.dosug.demo.service.CategoryService;
import com.dosug.demo.service.EventService;
import com.dosug.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private EventService eventService;

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
        userService.saveUser(user);
        return user;
    }
}
