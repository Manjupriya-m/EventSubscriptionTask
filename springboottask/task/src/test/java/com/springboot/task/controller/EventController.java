package com.springboot.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.task.model.Event;
import com.springboot.task.model.Subscription;
import com.springboot.task.service.EventService;

@RestController
@RequestMapping("/api")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping ("/events")
	
	public ResponseEntity<Event> createEvent(@RequestBody Event event){
		Event createdEvent = eventService.createEvent(event);
		return ResponseEntity.ok(createdEvent);
	}
	
    @PostMapping ("/subscription")
	
	public ResponseEntity<Subscription> subscribeToEvent(@RequestBody Subscription subscription){
    	Subscription createdSubscription = eventService.subscribeToEvent(subscription);
		return ResponseEntity.ok(createdSubscription);
	}
    
    
    @GetMapping("/events/{userId}")
    public ResponseEntity<List<Event>> getEventsForUser(@PathVariable Long userId){
    	List<Event> events = eventService.getRecentEventsForUser(userId);
    	return ResponseEntity.ok(events);
    }
    

}
