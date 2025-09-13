package org.studystack.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.studystack.database.connector.DBConnector;
import org.studystack.database.entity.AnswerEntity;
import org.studystack.model.AnswerQuestionRequest;
import org.studystack.model.AnswerQuestionResponse;
import com.theokanning.openai.service.OpenAiService;

import java.util.List;
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
//        String apiKey = "your_api_key";
//        OpenAiService service = new OpenAiService(apiKey);
//        ChatMessage userMessage = new ChatMessage();
//        userMessage.setRole("user");
//        userMessage.setContent("Question: "+ question +" Answer: "+ answer +" Can you please generate an accuracy score from 0 to 100 for this question and answer? The answer should be only an integer and should contain no other text.");
//        ChatCompletionRequest request = ChatCompletionRequest.builder()
//                .model("gpt-3.5-turbo")
//                .messages(List.of(userMessage))
//                .build();
//
//        String response = service.createChatCompletion(request)
//                .getChoices()
//                .get(0)
//                .getMessage()
//                .getContent();

        Random random = new Random();
        return random.nextInt(101);
    }
}
