package com.example.s3_docker_practice.docker_practice.repository;

import com.example.s3_docker_practice.docker_practice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUserNameAndUserPassword(String userName, String userPassword);
}
