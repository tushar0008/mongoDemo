package com.example.MongoDBDemo.repository;

import com.example.MongoDBDemo.model.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Books, Integer> {
}
