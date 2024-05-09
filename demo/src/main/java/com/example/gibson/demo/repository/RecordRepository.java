package com.example.gibson.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
    
import com.example.gibson.demo.model.*;

public interface RecordRepository extends MongoRepository<Records, String>{
    Records findByValue1(String value1);
}
