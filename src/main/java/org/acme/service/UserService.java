package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.DTOs.request.UserRequest;
import org.acme.DTOs.response.UserResponse;
import org.acme.Model.User;
import org.bson.types.ObjectId;
import org.jboss.logging.Logger;

@ApplicationScoped
public class UserService {

    private static final Logger LOG = Logger.getLogger(UserService.class);

    public UserResponse createUser(UserRequest request) {

        User user = new User();
        user.name = request.name;
        user.age = request.age;
        user.email = request.email;

        user.persist();

        LOG.info("User saved with id: " + user.id);

        UserResponse response = new UserResponse();
        response.id = user.id.toString();
        response.name = user.name;
        response.age = user.age;
        response.email = user.email;

        return response;
    }

    public UserResponse getUserById(String id) {

        LOG.info("Arrived ID" + id);
        ObjectId objectId = new ObjectId(id);

        User user = User.findById(objectId);

        if (user == null) {
            LOG.info("Not Found");
            throw new RuntimeException("User not found");
        }

        UserResponse response = new UserResponse();
        response.id = user.id.toString();
        response.name = user.name;
        response.age = user.age;
        response.email = user.email;

        return response;
    }
}