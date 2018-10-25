package com.verizon.sba.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sba.Dao.OrderRepository;
import com.verizon.sba.model.Order;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepo;
	
	@Override
	public Order getOrderById(long orderId) {
		Order order=null;
		Optional<Order> optOrder = orderRepo.findById(orderId);
			if(optOrder.isPresent()) {
				order = optOrder.get();
			}
		return order;
	}

	@Override
	public Order addOrder(Order order) {
		return orderRepo.save(order);
	}

}
