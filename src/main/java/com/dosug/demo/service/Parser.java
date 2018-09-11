package com.dosug.demo.service;


import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.dosug.demo.model.Category;
import com.dosug.demo.model.Event;
import com.dosug.demo.repo.EventRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Parser {

    @Autowired
    private EventRepo eventRepo;

    @Value("${urlResearch}")
    private String url;

    @Scheduled(fixedRate = 20000)
    public void reportCurrentTime() throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("#tab-table > section > div > div > div:nth-child(2) > div > div.film-info > div > a");
        for(Element link : links){
            Category category1 = new Category();
            category1.setTitle("Cinema");
            Event event1 = new Event();
            event1.setEventId(UUID.randomUUID());
            event1.setDescription(link.text());
            event1.setContact("+380508468615");
            event1.setCategory(category1);
            event1.setStartTimeEvent(Timestamp.valueOf(LocalDateTime.now().plusMinutes(40)));
            event1.setExpiredTimeEvent(Timestamp.valueOf(LocalDateTime.now().plusDays(3)));
            eventRepo.save(event1);
            System.out.println("Created new EVENT " + event1.getDescription() + event1.getCategory());
        }
    }
}
