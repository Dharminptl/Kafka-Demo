package com.example.UserProducer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.UserProducer.modal.UserDetails;
import com.google.gson.Gson;

@Service
public class UserProducerService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public String saveUserDetails(UserDetails userDetail) {
		Gson gson = new Gson();
		String userJson = gson.toJson(userDetail);
        String topicName = "insert-user-topic";
        kafkaTemplate.send(topicName, userJson);
        return "User Successfully Send To Topic For Insert Operation";
    }

	public String deleteUserDetails(String id) {
        String topicName = "delete-user-topic";
        kafkaTemplate.send(topicName, id);
        return "User Id SuccessFully Send To Topic For Delete Operation";
	}

}
