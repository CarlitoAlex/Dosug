package com.dosug.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "usr")
public class User {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Column(name = "USER_ID", nullable = false, updatable = false)
    private UUID userId;


    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "KEYWORD_ID")
    private KeyWords keyWords;

    public User(KeyWords keyWords) {
        this.keyWords = keyWords;
    }

    public User(){

    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public KeyWords getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(KeyWords keyWords) {
        this.keyWords = keyWords;
    }
}
