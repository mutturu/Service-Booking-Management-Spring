package com.usermanagement.microservice.sericebookingmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.microservice.sericebookingmanagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
