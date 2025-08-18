package org.studystack.model;

import lombok.Data;

/**
 * The model for a request to view all the questions that have been asked in a specific group.
 */
@Data
public class ViewQuestionsInGroupRequest {

    /**
     * The group ID for which we want to view all the questions that have been asked.
     */
    private String groupId;
}
