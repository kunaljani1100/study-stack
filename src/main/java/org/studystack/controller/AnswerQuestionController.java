package org.studystack.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.studystack.database.connector.DBConnector;
import org.studystack.database.entity.AnswerEntity;
import org.studystack.model.AnswerQuestionRequest;
import org.studystack.model.AnswerQuestionResponse;
import com.anthropic.client.AnthropicClient;
import com.anthropic.client.okhttp.AnthropicOkHttpClient;
import com.anthropic.models.messages.Message;
import com.anthropic.models.messages.MessageCreateParams;
import com.anthropic.models.messages.Model;
import com.anthropic.models.messages.ContentBlock;

import java.util.List;
import java.util.Map;
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
        answerEntity.setAccuracy(getAccuracy(request.getQuestion(), request.getAnswer()));

        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<AnswerEntity> mongoCollection = mongoDatabase.getCollection("Answers", AnswerEntity.class);
        mongoCollection.insertOne(answerEntity);

        AnswerQuestionResponse answerQuestionResponse = new AnswerQuestionResponse();
        answerQuestionResponse.setAccuracy(answerEntity.getAccuracy());
        answerQuestionResponse.setAnswerId(answerEntity.getAnswerId());
        return answerQuestionResponse;
    }

    private int getAccuracyWithGemini(String question, String answer) {
        return new Random().nextInt(101); // Returns a random accuracy score between 0 and 100
    }

    private int getAccuracy(String question, String answer) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", "ENTER_KEY");
        headers.set("anthropic-version", "2023-06-01");

        Map<String, Object> message = Map.of(
                "role", "user",
                "content", "Question: " + question + " Answer: " + answer +
                        " Can you please generate an accuracy score from 0 to 100 for this question and answer? " +
                        "The answer should be only an integer and should contain no other text."
        );

        Map<String, Object> requestBody = Map.of(
                "model", "claude-sonnet-5",
                "max_tokens", 10,
                "messages", List.of(message)
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                "https://api.anthropic.com/v1/messages", request, Map.class);

        List<Map<String, Object>> content = (List<Map<String, Object>>) response.getBody().get("content");
        String text = (String) content.get(0).get("text");

        return Integer.parseInt(text.trim());
    }
}
