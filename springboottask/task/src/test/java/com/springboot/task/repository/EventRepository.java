package com.springboot.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.task.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

	List<Event> findAllById(List<String> collect);

}
