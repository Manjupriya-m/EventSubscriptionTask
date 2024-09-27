package com.springboot.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.task.model.Subscription;


public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

	List<Subscription>findByUserId(Long userId);
}
