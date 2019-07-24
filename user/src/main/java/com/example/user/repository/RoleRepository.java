package com.example.user.repository;

import com.example.user.model.Role;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Role findBy_id(ObjectId _id);

    Role findByRole(String role);
}