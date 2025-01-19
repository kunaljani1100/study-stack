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

@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class ViewQuestionsInGroupController {

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
