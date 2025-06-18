package org.studystack.model;

import lombok.Data;

@Data
public class ViewQuestionsInGroupRequest {

    /**
     * The group ID for which we want to view all the questions that have been asked.
     */
    private String groupId;
}
