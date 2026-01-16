package org.acme.Model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "users")
public class User extends PanacheMongoEntity {

    public String name;
    public int age;
    public String email;
    public String password;   // hashed
    public String role;
}