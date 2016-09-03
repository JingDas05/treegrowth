package com.treegrowth.repository;


import com.treegrowth.model.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
