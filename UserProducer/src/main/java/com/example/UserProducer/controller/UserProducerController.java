package com.example.UserProducer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserProducer.modal.UserDetails;
import com.example.UserProducer.service.UserProducerService;

@RestController
public class UserProducerController {
	
	@Autowired
	private UserProducerService userProducerService;
	
	@RequestMapping("/saveUserDetails")
	public String saveUserDetails(@RequestBody UserDetails userDetail) {
		return userProducerService.saveUserDetails(userDetail);
	}
	
	@RequestMapping("/deleteUserDetails")
	public String deleteUserDetails(@RequestParam String id) {
		return userProducerService.deleteUserDetails(id);
	}
	

}
