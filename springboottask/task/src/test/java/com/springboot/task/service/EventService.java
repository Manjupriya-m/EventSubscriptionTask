package com.springboot.task.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.task.model.Event;
import com.springboot.task.model.Subscription;
import com.springboot.task.repository.EventRepository;
import com.springboot.task.repository.SubscriptionRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	
	public Event createEvent(Event event) {
		event.setTimestamp(LocalDateTime.now());
		return eventRepository.save(event);
		
	}
	
	public Subscription subscribeToEvent(Subscription subscription) {
		return subscriptionRepository.save(subscription);
		
	}
	
	public List<Event> getRecentEventsForUser(Long userId){
		
		List<Subscription> subscriptions = subscriptionRepository.findByUserId(userId);
		return eventRepository.findAllById(subscriptions.stream().map(Subscription::getEventType).collect(Collectors.toList()));
				
		
	}
	
	
}
