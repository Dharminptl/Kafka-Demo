package com.example.UserConsumer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.UserProducer.modal.UserDetails;

@Repository
public interface UserConsumerRepository extends CrudRepository<UserDetails, Integer> {

}
