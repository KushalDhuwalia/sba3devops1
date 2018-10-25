package com.verizon.sba.restapi;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.verizon.sba.model.Order;
import com.verizon.sba.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderApi {
	
	@Autowired
	private OrderService service;

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") long orderId){
		ResponseEntity<Order> resp;
		Order c= service.getOrderById(orderId);
		if(c==null)
			resp= new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp= new ResponseEntity<>(c,HttpStatus.OK);
		return resp;
	}
	
	 @PostMapping
	   public ResponseEntity<Order> addOrder(@RequestBody Order order){
		   
		   ResponseEntity<Order> resp=null;
		   LocalDate date= LocalDate.now();
		   order.setDateOfRequest(date);
		     Order c= service.addOrder(order);
			   if(c==null)
				   resp=new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
			   else
				   resp=new ResponseEntity<Order>(c,HttpStatus.OK);
		   
		   return resp;
	   }

}
