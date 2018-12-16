package com.dosug.demo.controller;

import com.dosug.demo.model.Category;
import com.dosug.demo.model.Event;
import com.dosug.demo.repo.EventRepo;
import com.dosug.demo.repo.UserRepo;
import com.dosug.demo.service.CategoryService;
import com.dosug.demo.service.EventService;
import com.dosug.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class EventController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

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
        return eventService.findByDescription(categoryService.findByTitleCategory(find).getEvent().getDescription());
    }


    @RequestMapping(value = "getEventWords/{userId}" , method = RequestMethod.GET)
    public @ResponseBody
    List<Event> findByWordFromRepo(@PathVariable UUID userId){
        return eventService.findByDescription(
                userService.findUserById(userId).getKeyWords().getKeyWord());
    }

    @RequestMapping(value = "deleteEvent/{uuid}" , method = RequestMethod.DELETE)
    public @ResponseBody void deletoEvent(@PathVariable  String uuid){
        Category category = new Category();
        Event event = eventService.findEventById(UUID.fromString(uuid));
        category.setCategoryId(UUID.randomUUID());
        category.setTitle(event.getCategory().getTitle());
        categoryService.save(category);
        eventService.deleteEvent(uuid);
    }

    @RequestMapping(value = "getLikes/{eventId}" , method = RequestMethod.GET)
    public @ResponseBody Event getLikes(@PathVariable UUID eventId){
        return eventService.addedLikes(eventService.findEventById(eventId));
    }

}
