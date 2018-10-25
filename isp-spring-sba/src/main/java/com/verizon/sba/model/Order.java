package com.verizon.sba.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name="Ordernew")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderId;
	
	
	
	@NotEmpty(message="Name can not be empty")
	private String name;
	
	
	@Column(name="mno")
	@Size(min=10,max=10,message="Mobile must be of 5 to 20 chars")
	private String mobileNumber;
	
	@NotEmpty(message="Address can not be empty")
	@Size(min=5,max=40,message="Address must be of 5 to 40 chars")
	private String address;
	
	@NotEmpty(message="Time Slot can not be empty")
	@Size(min=5,max=40,message="TIme Slot must be of 5 to 40 chars")
	private String timeSlot;
	
	@Column(name="dor")
	private LocalDate dateOfRequest;
	
	
	@NotEmpty(message="title can not be empty")
	//@Size(min=5,max=15,message="title must be of 5 to 15 chars")
	private String title;


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTimeSlot() {
		return timeSlot;
	}


	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}


	public LocalDate getDateOfRequest() {
		return dateOfRequest;
	}


	public void setDateOfRequest(LocalDate dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
		
}
