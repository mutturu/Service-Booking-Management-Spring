package com.servicebooking.microservice.servicebookingmicroservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicebooking.microservice.servicebookingmicroservice.exception.ResourceNotFoundException;
import com.servicebooking.microservice.servicebookingmicroservice.model.Service;
import com.servicebooking.microservice.servicebookingmicroservice.repository.ServiceRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class ServiceController {

	@Autowired
	private ServiceRepository serviceRepository;
	
	// get all employees
	@GetMapping("/services")
	public List<Service> getAllServices(){
		return serviceRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/services")
	public Service createEmployee(@RequestBody Service service) {
		return serviceRepository.save(service);
	}
	
	// get user by id rest api
	@GetMapping("/services/{id}")
	public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
		Service service = serviceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Service not exist with id :" + id));
		return ResponseEntity.ok(service);
	}
	
	// update user rest api
	
	@PutMapping("/services/{id}")
	public ResponseEntity<Service> updateService(@PathVariable Long id, @RequestBody Service serviceDetails){
		Service service = serviceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Service not exist with id :" + id));
		
		service.setProductId(serviceDetails.getProductId());
		service.setUserId(serviceDetails.getUserId());
		service.setReqDate(serviceDetails.getReqDate());
		service.setProblem(serviceDetails.getProblem());
		service.setDescription(serviceDetails.getDescription());
		service.setStatus(serviceDetails.getStatus());
		
		Service updatedService = serviceRepository.save(service);
		return ResponseEntity.ok(updatedService);
	}
	
	// delete user rest api
	@DeleteMapping("/services/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		Service service = serviceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Service not exist with id :" + id));
		
		serviceRepository.delete(service);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
