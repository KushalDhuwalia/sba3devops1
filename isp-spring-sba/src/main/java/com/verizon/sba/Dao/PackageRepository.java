package com.verizon.sba.Dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.verizon.sba.model.Plan;

@Repository
public interface PackageRepository extends JpaRepository<Plan, String> {
	
	boolean existsByTitle(String Title);
	Plan findByMaxSpeed(double maxSpeed);
	Plan findByMaxUsage(double maxUsage);
	Plan findByMaxCost(double maxCost);

	

}
