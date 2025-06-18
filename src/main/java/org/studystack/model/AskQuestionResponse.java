package org.studystack.model;

import lombok.Data;

/**
 * The response returned when a question has been posted in a group.
 */
@Data
public class AskQuestionResponse {

    /**
     * The identifier that is corresponding to the question that is being asked.
     */
    private String questionId;
}
