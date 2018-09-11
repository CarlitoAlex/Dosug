package com.dosug.demo.repo;

import com.dosug.demo.model.KeyWords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface KeyWordsRepo extends JpaRepository<KeyWords, UUID> {
    KeyWords findByKeyWord(String keyword);
}
