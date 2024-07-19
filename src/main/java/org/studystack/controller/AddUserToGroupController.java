package org.studystack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.studystack.database.repository.GroupRepository;
import org.studystack.database.repository.UserRepository;
import org.studystack.model.AddUserToGroupRequest;
import org.studystack.model.AddUserToGroupResponse;

@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class AddUserToGroupController {

    /**
     * Add a new user to a studystack group.
     * @param request The request body with the group ID and the username.
     * @return The message indicating the status of the operation.
     */
    @RequestMapping(value = "/groups/users/create", method = RequestMethod.POST)
    public AddUserToGroupResponse addUserToGroup(@RequestBody AddUserToGroupRequest request) {
        AddUserToGroupResponse response = new AddUserToGroupResponse();
        String username = request.getUsername();
        String groupId = request.getGroupId();
        UserRepository userRepository = new UserRepository();
        GroupRepository groupRepository = new GroupRepository();
        if (userRepository.checkIfUserExists(username)) {
            if (groupRepository.checkIfGroupExists(groupId)) {
                groupRepository.addUserToGroup(groupId, username);
                userRepository.addGroupForUser(groupId, username);
                response.setMessage("User added to group.");
            } else {
                response.setMessage("User found but group not found.");
            }
        } else {
            response.setMessage("User not found");
        }
        return response;
    }

}
