package com.dosug.demo.service;

import com.dosug.demo.model.Event;
import com.dosug.demo.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;


    public Event findEventById(UUID id){
        System.out.println(eventRepo.findByEventId(id));
        return eventRepo.findByEventId(id);
    }
}
