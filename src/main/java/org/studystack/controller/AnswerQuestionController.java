package org.studystack.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.studystack.database.connector.DBConnector;
import org.studystack.database.entity.AnswerEntity;
import org.studystack.model.AnswerQuestionRequest;
import org.studystack.model.AnswerQuestionResponse;

import java.util.Random;

/**
 * AnswerQuestionController is responsible for handling requests related to answering questions in the StudyStack application.
 * It allows users to submit answers to specific questions.
 */
@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class AnswerQuestionController {

    /**
     * This method is used to answer a question.
     * @param request The request body submitted by the user client while answering a question.
     * @return The response with the answer ID.
     */
    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public AnswerQuestionResponse answer(@RequestBody AnswerQuestionRequest request) {
        AnswerEntity answerEntity = new AnswerEntity();
        Random random = new Random();
        answerEntity.setAnswerId("answer-"+ random.ints(97, 122));
        answerEntity.setUsername(request.getUsername());
        answerEntity.setAnswer(request.getAnswer());
        answerEntity.setQuestionId(request.getQuestionId());

        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<AnswerEntity> mongoCollection = mongoDatabase.getCollection("Answers", AnswerEntity.class);
        mongoCollection.insertOne(answerEntity);

        AnswerQuestionResponse answerQuestionResponse = new AnswerQuestionResponse();
        answerQuestionResponse.setAnswerId(answerEntity.getAnswerId());
        return answerQuestionResponse;
    }
}
