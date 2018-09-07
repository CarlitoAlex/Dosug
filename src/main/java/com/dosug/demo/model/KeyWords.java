package com.dosug.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "keywords")
public class KeyWords {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Column(name = "KEYWORD_ID", nullable = false, updatable = false)
    private UUID keywordId;

    private String keyWord;

    @OneToOne(optional = false, mappedBy = "keyWords")
    @JsonIgnore
    private User userKeyword;

    public User getUserKeyword() {
        return userKeyword;
    }

    public void setUserKeyword(User userKeyword) {
        this.userKeyword = userKeyword;
    }

    public KeyWords() {
    }

    public KeyWords(String keyWord) {
        this.keyWord = keyWord;
    }

    public UUID getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(UUID keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
