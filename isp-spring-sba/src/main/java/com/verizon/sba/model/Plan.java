package com.verizon.sba.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="Plans")
public class Plan {
	
	@Id
	@NotEmpty(message="firstName can not be empty")
	@Size(min=5,max=15,message="firstName must be of 5 to 15 chars")
	private String title;
	
	
	@NotNull(message="Speed can not be empty")
	private double maxSpeed;
	
	
	@NotNull(message="Usage can not be empty")
	private double maxUsage;
	
	
	@NotNull(message="Cost can not be empty")
	private double maxCost;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getMaxSpeed() {
		return maxSpeed;
	}


	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	public double getMaxUsage() {
		return maxUsage;
	}


	public void setMaxUsage(double maxUsage) {
		this.maxUsage = maxUsage;
	}


	public double getMaxCost() {
		return maxCost;
	}


	public void setMaxCost(double maxCost) {
		this.maxCost = maxCost;
	}
	
}
