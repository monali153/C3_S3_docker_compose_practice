package com.example.s3_docker_practice.docker_practice.service;

import com.example.s3_docker_practice.docker_practice.domain.User;
import com.example.s3_docker_practice.docker_practice.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    public User addUser(User user);
    public User findByUserNameAndUserPassword(String userName, String userPassword) throws UserNotFoundException;
    public List<User> getAllUsers();
}
