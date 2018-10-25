package com.verizon.sba.service;

import java.util.List;



import com.verizon.sba.model.Plan;

public interface PackageService {

	List<Plan> getAllPackages();
	boolean existsByTitle(String Title);
	Plan findByMaxSpeed(double maxSpeed);
	Plan findByMaxUsage(double maxUsage);
	Plan findByMaxCost(double maxCost);

}
