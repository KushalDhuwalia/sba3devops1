package com.verizon.sba.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.verizon.sba.model.Plan;
import com.verizon.sba.service.PackageService;

@CrossOrigin
@RestController
@RequestMapping("/package")
public class Pacakgeapi {
	
	@Autowired
	private PackageService packservice;
	
	@GetMapping
	public ResponseEntity<List<Plan>> getAllplans(){
		return new ResponseEntity<>(
				packservice.getAllPackages(),HttpStatus.OK);
	}
	@GetMapping("/{field}/{srhValue}")
		public ResponseEntity<List<Plan>> getAllPlans(
				@PathVariable("field") String fieldBy,
				@PathVariable("srhValue") double searchValue){
		   
		   List<Plan> results=null;
		   ResponseEntity<List<Plan>> resp;
		   switch(fieldBy) {
		   case "maxSpeed":
			   Plan planBySpeed= packservice.findByMaxSpeed(searchValue);
			   if(planBySpeed!=null) {
				   results=Collections.singletonList(planBySpeed);
			   }
			   break;
		   case "maxUsage":
			   Plan planByUsage= packservice.findByMaxUsage(searchValue);
			   if(planByUsage!=null) {
				   results=Collections.singletonList(planByUsage);
			   }
			   break;
		   case "maxCost":
			   Plan planByCost= packservice.findByMaxCost(searchValue);
			   if(planByCost!=null) {
				   results=Collections.singletonList(planByCost);
			   break;
		   }
		   }
		  
		   
		   if(results==null)
			   resp= new ResponseEntity<List<Plan>>(HttpStatus.BAD_REQUEST);
		   else
			   resp=new ResponseEntity<List<Plan>>(results,HttpStatus.OK);
		   return resp;
		
	   }
		

}
