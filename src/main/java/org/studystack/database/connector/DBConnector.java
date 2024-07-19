package org.studystack.database.connector;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.studystack.database.repository.UserRepository;

/**
 * Utility class to connect to a database.
 */
public class DBConnector {
    private MongoClient mongoClient;
    private CodecRegistry pojoCodecRegistry;
    private CodecRegistry codecRegistry;
    private MongoClientSettings clientSettings;

    /**
     * Connect to the database with a given url
     * @param url url of the database.
     */
    public void connect(String url){
        pojoCodecRegistry= CodecRegistries.fromProviders(PojoCodecProvider
                .builder()
                .register(UserRepository.class)
                .automatic(true)
                .build());
        codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        clientSettings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(url))
                .codecRegistry(codecRegistry)
                .build();
        mongoClient = MongoClients.create(clientSettings);
    }

    /**
     * Get the mongodatabase.
     * @return the database object.
     */
    public MongoDatabase getMongoDatabase(){
        return mongoClient.getDatabase("StudyStack");
    }

    /**
     * Close the connection to the database.
     */
    public void closeConnection() {
        mongoClient.close();
    }
}
