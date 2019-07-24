package com.example.user.model;

import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    @Id
    private ObjectId _id;

    private String name;
    private String password;
    private Set<Role> roles;

    public User() {
    }

    public ObjectId getId() {
        return this._id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRole() {
        return this.roles;
    }

    public void setRole(Set<Role> roles) {
        this.roles = roles;
    }
}