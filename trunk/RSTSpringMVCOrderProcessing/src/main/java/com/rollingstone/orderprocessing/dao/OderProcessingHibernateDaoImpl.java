package com.rollingstone.orderprocessing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rollingstone.orderprocessing.model.Order;
import com.rollingstone.orderprocessing.model.OrderItem;

@Repository
public class OderProcessingHibernateDaoImpl implements IOderProcessingDao {

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order addItem(long orderId, OrderItem orderItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder(long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrderForCustomer(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeOrder(long orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllOrderForCustomer(long customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
