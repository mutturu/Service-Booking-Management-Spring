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
import com.servicebooking.microservice.servicebookingmicroservice.model.Servicereport;
import com.servicebooking.microservice.servicebookingmicroservice.repository.ServicereportRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class ServicereportController {

	@Autowired
	private ServicereportRepository servicereportRepository;
	
	// get all employees
	@GetMapping("/servicereports")
	public List<Servicereport> getAllServicereports(){
		return servicereportRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/servicereports")
	public Servicereport createServiceReport(@RequestBody Servicereport servicereport) {
		return servicereportRepository.save(servicereport);
	}
	
	// get user by id rest api
	@GetMapping("/servicereports/{id}")
	public ResponseEntity<Servicereport> getServicereportById(@PathVariable Long id) {
		Servicereport servicereport = servicereportRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Servicereport not exist with id :" + id));
		return ResponseEntity.ok(servicereport);
	}
	
	// update user rest api
	
	@PutMapping("/servicereports/{id}")
	public ResponseEntity<Servicereport> updateServicereport(@PathVariable Long id, @RequestBody Servicereport servicereportDetails){
		Servicereport servicereport = servicereportRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Servicereport not exist with id :" + id));
		
		servicereport.setSerReqDate(servicereportDetails.getSerReqDate());
		servicereport.setReportDate(servicereportDetails.getReportDate());
		servicereport.setServiceType (servicereportDetails.getServiceType());
		servicereport.setActionTaken(servicereportDetails.getActionTaken());
		servicereport.setDiagnosisDetails(servicereportDetails.getDiagnosisDetails());
		servicereport.setIsPaid(servicereportDetails.getIsPaid());
		servicereport.setVisitFees(servicereportDetails.getVisitFees());
		servicereport.setRepairDetails(servicereportDetails.getRepairDetails());

		
		Servicereport updateServicereport = servicereportRepository.save(servicereport);
		return ResponseEntity.ok(updateServicereport);
	}
	
	// delete user rest api
	@DeleteMapping("/servicereports/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		Servicereport service = servicereportRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Service not exist with id :" + id));
		
		servicereportRepository.delete(service);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}