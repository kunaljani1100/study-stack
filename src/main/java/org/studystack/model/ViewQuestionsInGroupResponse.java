package org.studystack.model;

import lombok.Data;

import java.util.List;

/**
 * The model for a response containing questions in a specific group.
 */
@Data
public class ViewQuestionsInGroupResponse {

    private List<Question> questions;
}
