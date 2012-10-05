package com.rollingstone.orderprocessing.controller;

import java.util.List;

import com.rollingstone.orderprocessing.model.Order;
import com.rollingstone.orderprocessing.model.OrderItem;

public interface IOrderProcessing {

	Order addOrder(Order order);
	
	Order addItem(long orderId, OrderItem orderItem);
	
	Order getOrder(long orderId);
	
	List<Order> getAllOrders();
	
	List<Order> getAllOrderForCustomer(long customerId);
	
	boolean removeOrder(long orderId);
	
	boolean removeAllOrderForCustomer(long customerId);
	
	Order updateOrder(Order order);
}
