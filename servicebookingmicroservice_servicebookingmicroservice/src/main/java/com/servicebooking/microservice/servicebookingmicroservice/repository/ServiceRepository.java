package com.servicebooking.microservice.servicebookingmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicebooking.microservice.servicebookingmicroservice.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{

}