package com.example.UserProducer.modal;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
	
	
	private Integer id;
	
	private String topicName;
		
	private Date updatedDateTime; 
	
	private String userName;
	
	private String emailId;
	
	private String userMessage;

}
