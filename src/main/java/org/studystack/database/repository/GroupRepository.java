package org.studystack.database.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.studystack.database.connector.DBConnector;
import org.studystack.database.entity.GroupEntity;

/**
 * This class performs the operations that are required to add a new studystack group into the database.
 */
public class GroupRepository {

    public void insert(GroupEntity groupEntity) {
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<GroupEntity> mongoCollection = mongoDatabase.getCollection("Groups", GroupEntity.class);
        mongoCollection.insertOne(groupEntity);
        dbConnector.closeConnection();
    }
}
