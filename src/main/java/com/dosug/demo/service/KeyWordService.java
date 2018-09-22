package com.dosug.demo.service;

import com.dosug.demo.repo.KeyWordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyWordService {

    @Autowired
    private KeyWordsRepo keyWordsRepo;


}
