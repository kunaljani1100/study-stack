package org.studystack.database.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.studystack.database.connector.DBConnector;
import org.studystack.database.entity.GroupEntity;
import org.studystack.database.entity.UserEntity;

/**
 * This class performs the operations that are required to add a new studystack group into the database.
 */
public class GroupRepository {

    /**
     * Create a new studystack group in the database.
     * @param groupEntity The entity that contains all the information corresponding to the group.
     */
    public void addNewGroupToDatabase(GroupEntity groupEntity) {
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<GroupEntity> mongoCollection = mongoDatabase.getCollection("Groups", GroupEntity.class);
        mongoCollection.insertOne(groupEntity);
        dbConnector.closeConnection();
    }

    /**
     * This function checks if a group with the given associated group ID exists in the database.
     * @param groupId The group identifier with the group name and the date when the group was created.
     * @return True if the group exists, false if the group does not exist.
     */
    public boolean checkIfGroupExists(String groupId) {
        boolean groupExists = false;
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = dbConnector.getMongoDatabase();
        MongoCollection<GroupEntity> mongoCollection = mongoDatabase.getCollection("Groups", GroupEntity.class);
        if (mongoCollection.countDocuments(Filters.eq("groupId", groupId)) > 0) {
            groupExists = true;
        }
        return groupExists;
    }
}
