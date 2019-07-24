package com.example.user.repository;

import com.example.user.model.User;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findBy_id(ObjectId _id);

    User findByName(String name);
}