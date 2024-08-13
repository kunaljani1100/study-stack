package org.studystack.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.studystack.database.entity.GroupEntity;
import org.studystack.database.repository.GroupRepository;
import org.studystack.model.CreateGroupRequest;
import org.studystack.model.CreateGroupResponse;
import org.studystack.model.Question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class GroupController {

    /**
     * Create a new group for the studystack application.
     * @param request The request body submitted by the user client while creating a new user.
     * @return The response with the username of the newly created user.
     */
    @RequestMapping(value = "/groups/create", method = RequestMethod.POST)
    public CreateGroupResponse createNewGroup(@RequestBody CreateGroupRequest request){

        // Populating the group entity.
        GroupEntity groupEntity = new GroupEntity();
        BeanUtils.copyProperties(request, groupEntity);
        groupEntity.setGroupId(request.getGroupName() + "::" + LocalDateTime.now().toString());
        groupEntity.setUsernames(new ArrayList<>());

        // Setting the questions as an empty questions list for a new group that has been created.
        groupEntity.setQuestions(new ArrayList<>());

        // Inserting the group record into the mongoDB database.
        GroupRepository groupRepository = new GroupRepository();
        groupRepository.addNewGroupToDatabase(groupEntity);

        //Creating the response indicating the newly created group.
        CreateGroupResponse createGroupResponse = new CreateGroupResponse();
        createGroupResponse.setGroupId(groupEntity.getGroupId());
        return createGroupResponse;
    }
}
