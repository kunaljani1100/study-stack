package org.studystack.database.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.studystack.database.connector.DBConnector;
import org.studystack.database.entity.UserEntity;

/**
 * This class perform the operations that are required to add a new user into the studystack database.
 */
public class UserRepository {

    public void insert(UserEntity userEntity) {
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<UserEntity> mongoCollection = mongoDatabase.getCollection("Users", UserEntity.class);
        mongoCollection.insertOne(userEntity);
        dbConnector.closeConnection();
    }
}
