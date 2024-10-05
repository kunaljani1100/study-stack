package org.studystack.controller;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.studystack.database.connector.DBConnector;
import org.studystack.model.ViewUsersInGroupRequest;
import org.studystack.model.ViewUsersInGroupResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the logic to view the users that are a part of a particular group.
 */
@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class ViewUsersInGroupController {

    @RequestMapping(value = "/groups/users/view", method = RequestMethod.POST)
    public ViewUsersInGroupResponse viewUsersInGroup(@RequestBody ViewUsersInGroupRequest request) {
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        List<Bson> aggregateList = new ArrayList<>();
        aggregateList.add(Aggregates.lookup("Users", "usernames", "username", "users"));
        AggregateIterable<ViewUsersInGroupResponse> iterable =  mongoDatabase.getCollection("Groups").aggregate(aggregateList, ViewUsersInGroupResponse.class);
        ViewUsersInGroupResponse viewUsersInGroupResponse = iterable.first();
        return viewUsersInGroupResponse;
    }
}
