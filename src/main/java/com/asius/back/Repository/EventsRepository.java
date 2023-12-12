package com.asius.back.Repository;


import com.asius.back.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events,Long> {
}
