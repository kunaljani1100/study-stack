package org.studystack.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.studystack.database.connector.DBConnector;
import org.studystack.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewQuestionsInGroupController is responsible for handling requests to view questions in a specific group.
 * It retrieves questions associated with a given group ID from the database.
 */
@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class ViewQuestionsInGroupController {

    /**
     * Handles the request to view questions in a group.
     *
     * @param request The request body containing the group ID for which questions are to be retrieved.
     * @return A response containing the list of questions in the specified group.
     */
    @RequestMapping(value = "/groups/questions/view", method = RequestMethod.POST)
    public ViewQuestionsInGroupResponse viewUsersInGroup(@RequestBody ViewQuestionsInGroupRequest request) {
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<Document> questionCollection = mongoDatabase.getCollection("Questions");
        FindIterable<Question> questions = questionCollection.find(Filters.eq("groupId", request.getGroupId()), Question.class);
        List<Question> questionList = new ArrayList<>();
        questions.iterator().forEachRemaining(questionList::add);
        ViewQuestionsInGroupResponse viewQuestionsInGroupResponse = new ViewQuestionsInGroupResponse();
        viewQuestionsInGroupResponse.setQuestions(questionList);
        return viewQuestionsInGroupResponse;
    }
}
