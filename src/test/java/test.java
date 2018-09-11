import com.dosug.demo.Application;
import com.dosug.demo.model.Category;
import com.dosug.demo.model.Event;
import com.dosug.demo.repo.EventRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class test {

    @Autowired
    private EventRepo eventRepo;

    @Test
    public void createSomeCat(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Event event1 = new Event();
        Category category1 = new Category();
        Category category2 = new Category();
        Category category3 = new Category();
        Category category4 = new Category();
        Category category5 = new Category();
        Category category6 = new Category();
        Category category7 = new Category();
        category1.setTitle("Bar");
        category2.setTitle("Football");
        category3.setTitle("TV");
        category4.setTitle("CINEMA");
        category5.setTitle("PARK");
        category6.setTitle("Nature");
        category7.setTitle("Club");
        Event event2 = new Event();
        Event event3 = new Event();
        Event event4 = new Event();
        Event event5 = new Event();
        Event event6 = new Event();
        Event event7 = new Event();
        event1.setEventId(UUID.randomUUID());
        event1.setContact("+380508468615");
        event1.setDescription("Next Time you know");
        event1.setStartTimeEvent(Timestamp.valueOf(LocalDateTime.now()));
        event1.setExpiredTimeEvent(Timestamp.valueOf(LocalDateTime.now().plusHours(3)));

        event2.setEventId(UUID.randomUUID());
        event2.setContact("+380508468615");
        event2.setDescription("Barney party");
        event2.setStartTimeEvent(Timestamp.valueOf(LocalDateTime.now()));
        event2.setExpiredTimeEvent(Timestamp.valueOf(LocalDateTime.now().plusHours(3)));

        event3.setEventId(UUID.randomUUID());
        event3.setContact("+380508468615");
        event3.setDescription("Films");
        event3.setStartTimeEvent(Timestamp.valueOf(LocalDateTime.now()));
        event3.setExpiredTimeEvent(Timestamp.valueOf(LocalDateTime.now().plusHours(3)));

        event4.setEventId(UUID.randomUUID());
        event4.setContact("+380508468615");
        event4.setDescription("Pub");
        event4.setStartTimeEvent(Timestamp.valueOf(LocalDateTime.now()));
        event4.setExpiredTimeEvent(Timestamp.valueOf(LocalDateTime.now().plusHours(3)));

        event5.setEventId(UUID.randomUUID());
        event5.setContact("+380508468615");
        event5.setDescription("Beer party");
        event5.setStartTimeEvent(Timestamp.valueOf(LocalDateTime.now()));
        event5.setExpiredTimeEvent(Timestamp.valueOf(LocalDateTime.now().plusHours(3)));

        event6.setEventId(UUID.randomUUID());
        event6.setContact("+380508468615");
        event6.setDescription("Ladies party");
        event6.setStartTimeEvent(Timestamp.valueOf(LocalDateTime.now()));
        event6.setExpiredTimeEvent(Timestamp.valueOf(LocalDateTime.now().plusHours(3)));

        event7.setEventId(UUID.randomUUID());
        event7.setContact("+380508468615");
        event7.setDescription("PlayStations party");
        event7.setStartTimeEvent(Timestamp.valueOf(LocalDateTime.now()));
        event7.setExpiredTimeEvent(Timestamp.valueOf(LocalDateTime.now().plusHours(3)));
        event1.setCategory(category1);
        event2.setCategory(category2);
        event3.setCategory(category3);
        event4.setCategory(category4);
        event5.setCategory(category5);
        event6.setCategory(category6);
        event7.setCategory(category7);

        eventRepo.save(event1);
        eventRepo.save(event2);
        eventRepo.save(event3);
        eventRepo.save(event4);
        eventRepo.save(event5);
        eventRepo.save(event6);
        eventRepo.save(event7);
    }

    @Test
    public void asdasd() throws IOException {
        String url="https://vkino.ua/ru/cinema/kharkov/kinocentr-smart#afisha";
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
        }
    }
}
