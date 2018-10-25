package com.verizon.sba.service;



import com.verizon.sba.model.Order;

public interface OrderService {
	Order getOrderById(long orderId);
	Order addOrder(Order order);
	
}
