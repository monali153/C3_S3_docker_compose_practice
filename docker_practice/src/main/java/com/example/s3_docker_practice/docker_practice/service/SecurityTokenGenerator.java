package com.example.s3_docker_practice.docker_practice.service;

import com.example.s3_docker_practice.docker_practice.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);
}
