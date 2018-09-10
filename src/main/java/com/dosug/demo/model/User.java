package com.dosug.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "usr")
public class User {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Column(name = "USER_ID", nullable = false, updatable = false, unique = false)
    private UUID userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_keyword",
    joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    @JsonIgnore
    private KeyWords keyWords;
    
    public User(){}

    public User(KeyWords keyWords) {
        this.keyWords = keyWords;
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
