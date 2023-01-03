package com.example.UserConsumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserConsumer.service.UserConsumerService;
import com.example.UserProducer.modal.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
public class UserConsumerController {
	
	@Autowired
	private UserConsumerService userConsumerService;
	
	@KafkaListener(topics = "${insert.kafka.bootstrap-topic}", groupId = "${kafka.bootstrap-groupId}")
	public String fetchAndSaveUserDetails(String userDetailsJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		UserDetails userDetails = new UserDetails();
		try {
			userDetails = objectMapper.readValue(userDetailsJson, UserDetails.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userConsumerService.saveUserDetails(userDetails);
	}
	
	@KafkaListener(topics = "${delete.kafka.bootstrap-topic}", groupId = "${kafka.bootstrap-groupId}")
	public String deleteUserDetails(String json) {
		Gson gson = new Gson();		
		Integer id = gson.fromJson(json,Integer.class);
		return userConsumerService.deleteUserDetails(id);
	}
	
}
