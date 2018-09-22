package com.dosug.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Event{

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Column(name = "EVENT_ID", nullable = false, updatable = false)
    private UUID eventId;

    private Timestamp startTimeEvent;
    private Timestamp expiredTimeEvent;
    private String description;
    private String contact;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    private Integer likes;

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }

    public Event() {
    }

    public Event(Timestamp startTimeEvent, Timestamp expiredTimeEvent, String description, String contact, Category category) {
        this.startTimeEvent = startTimeEvent;
        this.expiredTimeEvent = expiredTimeEvent;
        this.description = description;
        this.contact = contact;
        this.category = category;
    }


    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public Timestamp getStartTimeEvent() {
        return startTimeEvent;
    }

    public void setStartTimeEvent(Timestamp startTimeEvent) {
        this.startTimeEvent = startTimeEvent;
    }

    public Timestamp getExpiredTimeEvent() {
        return expiredTimeEvent;
    }

    public void setExpiredTimeEvent(Timestamp expiredTimeEvent) {
        this.expiredTimeEvent = expiredTimeEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
