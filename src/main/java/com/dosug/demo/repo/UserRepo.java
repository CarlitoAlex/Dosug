package com.dosug.demo.repo;

import com.dosug.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.UUID;
@Transactional
public interface UserRepo extends JpaRepository<User, UUID> {
    User findByUserId(UUID userId);
    //TODO create update keywordsMethod
}
