package org.studystack.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.studystack.database.connector.DBConnector;
import org.studystack.database.entity.QuestionEntity;
import org.studystack.model.AskQuestionRequest;
import org.studystack.model.AskQuestionResponse;

import java.util.ArrayList;
import java.util.Random;

@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class AskQuestionController {

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public AskQuestionResponse askQuestion(@RequestBody AskQuestionRequest request) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestion(request.getQuestion());
        questionEntity.setGroupId(request.getGroupId());
        questionEntity.setUsername(request.getUsername());
        questionEntity.setAnswers(new ArrayList<>());

        Random random = new Random();
        String questionId = "question-" + random.ints(97, 122)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        questionEntity.setQuestionId(questionId);

        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<QuestionEntity> mongoCollection = mongoDatabase.getCollection("Questions", QuestionEntity.class);
        mongoCollection.insertOne(questionEntity);

        AskQuestionResponse askQuestionResponse = new AskQuestionResponse();
        askQuestionResponse.setQuestionId(questionId);
        return askQuestionResponse;
    }
}
