package org.studystack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * This is the starting point for the study stack application.
 */
@SpringBootApplication(exclude = MongoAutoConfiguration.class,
        scanBasePackages="org.studystack.controller")
public class StudyStackApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyStackApplication.class, args);
    }
}
