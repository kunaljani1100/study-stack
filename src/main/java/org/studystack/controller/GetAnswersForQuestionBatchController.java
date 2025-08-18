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
import org.studystack.model.GetAnswersForQuestionBatchRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to get answers for a batch of questions.
 */
@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class GetAnswersForQuestionBatchController {

    /**
     * This method is used to get answers for a batch of questions.
     * @param request The request body submitted by the user client while getting answers for a batch of questions.
     * @return A map where the key is the question ID and the value is a list of answers for that question.
     */
    @RequestMapping(value = "/answers/batch", method = RequestMethod.POST)
    public Map<String, List<Answer>> getAnswersForQuestionBatchResponse(@RequestBody GetAnswersForQuestionBatchRequest request) {
        List<String> questionIds = request.getQuestionIds();
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<Document> answerCollection = mongoDatabase.getCollection("Answers");
        FindIterable<Answer> answers = answerCollection.find(Filters.in("questionId", questionIds), Answer.class);
        List<Answer> answerList = new ArrayList<>();
        answers.iterator().forEachRemaining(answerList::add);
        Map<String, List<Answer>> answerMap = new HashMap<>();
        for (Answer answer : answerList) {
            String questionId = answer.getQuestionId();
            if (!answerMap.containsKey(questionId)) {
                answerMap.put(questionId, new ArrayList<>());
            }
            answerMap.get(questionId).add(answer);
        }
        return answerMap;
    }
}
