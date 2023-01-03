package com.example.UserProducer.modal;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("user_details")
//@RedisHash("UserDetails")
public class UserDetails {
	
	@PrimaryKey
	private Integer id;
	
	private String topicName;
	
	private Date updatedDateTime = new Date(); 
	
	private String userName;
	
	private String emailId;
	
	private String userMessage;
	
}
