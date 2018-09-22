package com.dosug.demo.repo;

import com.dosug.demo.model.Event;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
public interface EventRepo extends JpaRepository<Event, UUID> {
    Event findByEventId(UUID id);

    List<Event> findByDescriptionIgnoreCaseContains(String desc);

    void deleteEventByEventId(UUID uuid);
}
