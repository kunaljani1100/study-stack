package org.studystack.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.studystack.database.entity.UserEntity;
import org.studystack.database.repository.UserRepository;
import org.studystack.model.CreateUserRequest;
import org.studystack.model.CreateUserResponse;

@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class UserController {

    /**
     * Create a new user for the studystack application.
     * @param request The request body submitted by the user client while creating a new user.
     * @return The response with the username of the newly created user.
     */
    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public CreateUserResponse createNewUser(@RequestBody CreateUserRequest request){

        // Populating the user entity.
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(request, userEntity);
        userEntity.set_id(request.getUsername());

        // Inserting the user record into the mongoDB database.
        UserRepository userRepository = new UserRepository();
        userRepository.insert(userEntity);

        //Creating the response indicating the newly created user.
        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setUsername(userEntity.getUsername());
        return createUserResponse;
    }
}
