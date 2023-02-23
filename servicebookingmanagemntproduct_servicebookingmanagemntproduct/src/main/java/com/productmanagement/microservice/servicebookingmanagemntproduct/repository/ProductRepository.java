package com.productmanagement.microservice.servicebookingmanagemntproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productmanagement.microservice.servicebookingmanagemntproduct.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
