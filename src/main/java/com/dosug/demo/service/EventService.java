package com.dosug.demo.service;

import com.dosug.demo.model.Event;
import com.dosug.demo.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;

    public Event findEventById(UUID id){
        return eventRepo.findByEventId(id);
    }

    public List<Event> findByDescription(String find){
        return eventRepo.findByDescriptionIgnoreCaseContains(find);
    }

    public List<Event> showAll(){
        return eventRepo.findAll();
    }

    public Event addedLikes(Event event){
        int a = event.getLikes();
        event.setLikes(a + 1);
        eventRepo.save(event);
        return event;
    }

}
