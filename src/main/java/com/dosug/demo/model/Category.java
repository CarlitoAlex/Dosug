package com.dosug.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Column(name = "CATEGORY_ID", nullable = false, updatable = false)
    private UUID categoryId;

    private String title;

    @OneToOne(optional = false, mappedBy = "category")
    @JsonIgnore
    private Event event;

    public Event getEvent() {
        return event;
    }


    public void setEvent(Event event) {
        this.event = event;
    }

    public Category(){

    }

    public Category(String title, Event event) {
        this.title = title;
        this.event = event;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
