package com.verizon.sba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sba.Dao.PackageRepository;

import com.verizon.sba.model.Plan;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	private PackageRepository packageRepo;
	
	@Override
	public List<Plan> getAllPackages() {
		return packageRepo.findAll();
	}

	@Override
	public boolean existsByTitle(String Title) {
		return packageRepo.existsByTitle(Title);
		
	}

	@Override
	public Plan findByMaxSpeed(double maxSpeed) {
		return packageRepo.findByMaxSpeed(maxSpeed);
		
	}

	@Override
	public Plan findByMaxUsage(double maxUsage) {
		return packageRepo.findByMaxUsage(maxUsage);
	}

	@Override
	public Plan findByMaxCost(double maxCost) {
		return packageRepo.findByMaxCost(maxCost);
	}
	

}
