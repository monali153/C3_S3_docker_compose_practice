package com.example.s3_docker_practice.docker_practice.controller;

import com.example.s3_docker_practice.docker_practice.domain.User;
import com.example.s3_docker_practice.docker_practice.exception.UserNotFoundException;
import com.example.s3_docker_practice.docker_practice.service.SecurityTokenGenerator;
import com.example.s3_docker_practice.docker_practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator){
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException {
        Map<String , String> map = null;
        try {
            User user1 = userService.findByUserNameAndUserPassword(user.getUserName(),user.getUserPassword());
            if(user1.getUserName().equals(user.getUserName())){
                map = securityTokenGenerator.generateToken(user);
            }
            return new ResponseEntity(map, HttpStatus.OK);

        }catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }catch (Exception ex){
            return new ResponseEntity<>("Try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> insertUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/userdata/v1/fetchusers")
    public ResponseEntity<?> getUser() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

}
