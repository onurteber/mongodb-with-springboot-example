package com.spring.mongodb.springmongodb.repository;

import com.spring.mongodb.springmongodb.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
}
