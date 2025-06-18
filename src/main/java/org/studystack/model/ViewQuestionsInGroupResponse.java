package org.studystack.model;

import lombok.Data;

import java.util.List;

@Data
public class ViewQuestionsInGroupResponse {

    private List<Question> questions;
}
