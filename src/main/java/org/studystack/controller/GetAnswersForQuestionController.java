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
import org.studystack.model.Answer;
import org.studystack.model.GetAnswersForQuestionRequest;
import org.studystack.model.GetAnswersForQuestionResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to get answers for a given question.
 */
@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class GetAnswersForQuestionController {

    /**
     * This method is used to get answers for a given question.
     * @param getAnswersForQuestionRequest The request body submitted by the user client while getting answers for a question.
     * @return The response with the list of answers for the given question.
     */
    @RequestMapping(value = "/question/answers", method = RequestMethod.POST)
    public GetAnswersForQuestionResponse getAnswersForQuestionResponse(@RequestBody GetAnswersForQuestionRequest getAnswersForQuestionRequest) {
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<Document> answerCollection = mongoDatabase.getCollection("Answers");
        FindIterable<Answer> answers = answerCollection.find(Filters.eq("questionId", getAnswersForQuestionRequest.getQuestionId()), Answer.class);
        List<Answer> answerList = new ArrayList<>();
        answers.iterator().forEachRemaining(answerList::add);
        GetAnswersForQuestionResponse answersForQuestionResponse = new GetAnswersForQuestionResponse();
        answersForQuestionResponse.setAnswers(answerList);
        return answersForQuestionResponse;
    }
}
