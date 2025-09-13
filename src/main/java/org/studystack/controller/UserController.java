package org.studystack.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.studystack.database.connector.DBConnector;
import org.studystack.database.entity.UserEntity;
import org.studystack.database.repository.UserRepository;
import org.studystack.model.*;

import java.util.ArrayList;

/**
 * UserController is responsible for handling user-related requests in the studystack application.
 * It allows users to create new accounts and retrieve user details based on their username.
 */
@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class UserController {

    /**
     * Create a new user for the studystack application.
     * @param request The request body submitted by the user client while creating a new user.
     * @return The response with the username of the newly created user.
     */
    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public CreateUserResponse createNewUser(@RequestBody CreateUserRequest request){

        // Populating the user entity.
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(request, userEntity);
        userEntity.set_id(request.getUsername());

        // Inserting the user record into the mongoDB database.
        UserRepository userRepository = new UserRepository();
        userRepository.addNewUserToDatabase(userEntity);

        //Creating the response indicating the newly created user.
        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setUsername(userEntity.getUsername());
        return createUserResponse;
    }

    /**
     * This method is used to get user details based on the username.
     * @param request The request body submitted by the user client while getting user details.
     * @return The response with the user details.
     */
    @RequestMapping(value = "/users/get", method = RequestMethod.POST)
    public GetUserResponse getUser(@RequestBody GetUserRequest request) {
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<Document> userCollection = mongoDatabase.getCollection("Users");
        Bson authenticationFilter = Filters.eq("username", request.getUsername());
        FindIterable<GetUserResponse> response = userCollection.find(authenticationFilter, GetUserResponse.class);
        return response.first();
    }
}
