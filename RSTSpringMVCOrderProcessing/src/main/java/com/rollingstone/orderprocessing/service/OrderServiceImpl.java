package com.rollingstone.orderprocessing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollingstone.orderprocessing.dao.IOderProcessingDao;
import com.rollingstone.orderprocessing.model.Order;
import com.rollingstone.orderprocessing.model.OrderItem;

@Service
public class OrderServiceImpl implements IOrderService {
 
	IOderProcessingDao orderProcessingDao;
	
	
	public IOderProcessingDao getOrderProcessingDao() {
		return orderProcessingDao;
	}

	@Autowired
	public void setOrderProcessingDao(IOderProcessingDao orderProcessingDao) {
		this.orderProcessingDao = orderProcessingDao;
	}

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		
		return orderProcessingDao.addOrder(order);
		
	}

	@Override
	public Order addItem(long orderId, OrderItem orderItem) {
		orderProcessingDao.getOrder(orderId).addItem(orderItem);
		return orderProcessingDao.getOrder(orderId);
	}

	@Override
	public Order getOrder(long orderId) {
	
		return orderProcessingDao.getOrder(orderId);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrderForCustomer(long customerId) {
	
		return orderProcessingDao.getAllOrderForCustomer(customerId);
	}

	@Override
	public boolean removeOrder(long orderId) {
	
		orderProcessingDao.removeOrder(orderId);
		
		return true;
	}

	@Override
	public boolean removeAllOrderForCustomer(long customerId) {
	
		orderProcessingDao.removeAllOrderForCustomer(customerId);
		
		return true;
	}

	@Override
	public Order updateOrder(Order order) {
	
		orderProcessingDao.updateOrder(order);
		
		return orderProcessingDao.getOrder(order.getOrderNumber());
	}

	@Override
	public List<String> getAllStates() {
		// TODO Auto-generated method stub
		return null;
	}

}
