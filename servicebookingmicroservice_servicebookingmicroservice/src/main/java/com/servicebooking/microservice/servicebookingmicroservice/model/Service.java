package com.servicebooking.microservice.servicebookingmicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "services")
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "productid")
	private String productId;

	@Column(name = "userid")
	private String userId;
	
	@Column(name = "reqdate")
	private String reqDate;
	
	@Column(name = "problem")
	private String problem;
	
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private String status;
	
	
	public Service() {
		
	}
	
	public Service(String productId, String userId, String reqDate,String problem,String description,String status) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.reqDate = reqDate;
		this.problem=problem;
		this.description=description;
		this.status=status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
