package com.servicebooking.microservice.servicebookingmicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicereports")
public class Servicereport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "serreqdate")
	private String serReqDate;

	@Column(name = "reportdate")
	private String reportDate;
	
	@Column(name = "servicetype")
	private String serviceType;
	
	@Column(name = "actiontaken")
	private String actionTaken;
	
	@Column(name = "diagnosisdetails")
	private String diagnosisDetails;
	@Column(name = "ispaid")
	private String isPaid;
	
	@Column(name = "visitfees")
	private String visitFees;
	
	@Column(name = "repairdetails")
	private String repairDetails;
	
	
	public Servicereport() {
		
	}
	
	public Servicereport(String serReqDate, String reportDate, String serviceType,String actionTaken,String diagnosisDetails,String isPaid,String visitFees,String repairDetails) {
		super();
		this.serReqDate=serReqDate;
		this.reportDate = reportDate;
		this.serviceType= serviceType;
		this.actionTaken=actionTaken;
		this.diagnosisDetails=diagnosisDetails;
		this.isPaid=isPaid;
		this.visitFees=visitFees;
		this.repairDetails=repairDetails;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSerReqDate() {
		return serReqDate;
	}

	public void setSerReqDate(String serReqDate) {
		this.serReqDate = serReqDate;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getDiagnosisDetails() {
		return diagnosisDetails;
	}

	public void setDiagnosisDetails(String diagnosisDetails) {
		this.diagnosisDetails = diagnosisDetails;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public String getVisitFees() {
		return visitFees;
	}

	public void setVisitFees(String visitFees) {
		this.visitFees = visitFees;
	}

	public String getRepairDetails() {
		return repairDetails;
	}

	public void setRepairDetails(String repairDetails) {
		this.repairDetails = repairDetails;
	}


	
}
