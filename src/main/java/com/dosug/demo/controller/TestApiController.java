package com.dosug.demo.controller;

import com.dosug.demo.model.Category;
import com.dosug.demo.model.Event;
import com.dosug.demo.model.KeyWords;
import com.dosug.demo.model.User;
import com.dosug.demo.repo.CategoryRepo;
import com.dosug.demo.repo.UserRepo;
import com.dosug.demo.service.EventService;
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
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "getEvent",method = RequestMethod.GET)
    public @ResponseBody
    List<Event> getEvents(){
        return eventService.showAll();
    }

    @RequestMapping(value = "getEventByWord/{find}" , method = RequestMethod.GET)
    public @ResponseBody
    List<Event> findByWords(@PathVariable String find){
        return eventService.findByDescription(find);
    }

    @RequestMapping(value = "getEventByCategory/{find}" , method = RequestMethod.GET)
    public @ResponseBody
    List<Event> findByCat(@PathVariable String find){
        return eventService.findByDescription(categoryRepo.findFirstByTitle(find).getEvent().getDescription());
    }


    @RequestMapping(value = "getEventWords/{userId}" , method = RequestMethod.GET)
    public @ResponseBody
    List<Event> findByWordFromRepo(@PathVariable UUID userId){
        return eventService.findByDescription(
                userRepo.findByUserId(userId).getKeyWords().getKeyWord());
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


    //Need to be pushed
    @RequestMapping(value = "getLikes/{eventId}" , method = RequestMethod.GET)
    public @ResponseBody Event getLikes(@PathVariable UUID eventId){
         return eventService.addedLikes(eventService.findEventById(eventId));
    }

    @RequestMapping(value = "deleteEvent/{uuid}" , method = RequestMethod.DELETE)
    public @ResponseBody void deletoEvent(@PathVariable  String uuid){
        Category category = new Category();
        Event event = eventService.findEventById(UUID.fromString(uuid));
        category.setCategoryId(UUID.randomUUID());
        category.setTitle(event.getCategory().getTitle());
        categoryRepo.save(category);
        eventService.deleteEvent(uuid);
    }


}
