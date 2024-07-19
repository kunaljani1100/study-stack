package org.studystack.database.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.studystack.database.connector.DBConnector;
import org.studystack.database.entity.UserEntity;

/**
 * This class perform the operations that are required to add a new user into the studystack database.
 */
public class UserRepository {

    /**
     * Create a record for the new studystack user.
     * @param userEntity The entity that contains all the information corresponding to the new user.
     */
    public void addNewUserToDatabase(UserEntity userEntity) {
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<UserEntity> mongoCollection = mongoDatabase.getCollection("Users", UserEntity.class);
        mongoCollection.insertOne(userEntity);
        dbConnector.closeConnection();
    }

    /**
     * This class checks if a user exists in the users database or not.
     * @param username The username that we are checking whether it exists or not.
     * @return True, if the username is found in the database, false if the username is not found in the database.
     */
    public boolean checkIfUserExists(String username) {
        boolean userExists = false;
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<UserEntity> mongoCollection = mongoDatabase.getCollection("Users", UserEntity.class);
        if (mongoCollection.countDocuments(Filters.eq("username", username)) > 0) {
            userExists = true;
        }
        return userExists;
    }
}
