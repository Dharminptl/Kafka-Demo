package com.example.UserConsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.example.UserConsumer.repository.UserConsumerRepository;
import com.example.UserProducer.modal.UserDetails;

@Service
public class UserConsumerService {
	
	@Autowired
	private UserConsumerRepository userConsumerRepository;

	@CachePut(key = "#userDetails.id", value = "UserDetails")
	public String saveUserDetails(UserDetails userDetails) {
		userConsumerRepository.save(userDetails);
		return userDetails.toString();
	}

	public String deleteUserDetails(Integer id) {
		userConsumerRepository.deleteById(id);
		return "User Deleted Successfully";
	}	
}
