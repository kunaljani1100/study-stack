package org.studystack.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.studystack.database.connector.DBConnector;
import org.studystack.model.Answer;
import org.studystack.model.AuthenticateUserResponse;
import org.studystack.model.AuthenticateUserRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * AuthenticateUserController is responsible for handling user authentication requests.
 * It checks if the provided username and password match any user in the database.
 */
@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class AuthenticateUserController {

    /**
     * Authenticate a user based on the provided username and password.
     * @param authenticateUserRequest The request body containing the username and password.
     * @return An AuthenticateUserResponse indicating whether the authentication was successful or not.
     */
    @RequestMapping("users/authenticate")
    public AuthenticateUserResponse authenticateUserResponse(@RequestBody AuthenticateUserRequest authenticateUserRequest) {
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<Document> answerCollection = mongoDatabase.getCollection("Users");
        Bson authenticationFilter = Filters.and(Filters.eq("username", authenticateUserRequest.getUsername()),
                Filters.eq("password", authenticateUserRequest.getPassword()));
        FindIterable<Answer> answers = answerCollection.find(authenticationFilter, Answer.class);
        List<Answer> answerList = new ArrayList<>();
        answers.iterator().forEachRemaining(answerList::add);
        AuthenticateUserResponse authenticateUserResponse = new AuthenticateUserResponse();
        if (answerList.isEmpty()) {
            authenticateUserResponse.setResult("Failure");
        } else {
            authenticateUserResponse.setResult("Success");
        }
        return authenticateUserResponse;
    }
}
