package com.rollingstone.orderprocessing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rollingstone.orderprocessing.model.Order;
import com.rollingstone.orderprocessing.model.OrderItem;
import com.rollingstone.orderprocessing.service.IOrderService;

@Controller
public class OrderProcessingController implements IOrderProcessing{

	IOrderService orderService;
	
	public IOrderService getOrderService() {
		return orderService;
	}

	@Autowired
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	
	@ModelAttribute("states")
	public List<String> populateSportTypes() {
	        return orderService.getAllStates();
	}


	    
	@Override
    @RequestMapping("/order/add.htm")
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    @RequestMapping("/order/additem.htm")
	public Order addItem(long orderId, OrderItem orderItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    @RequestMapping("/order/getorder.htm")
	public Order getOrder(long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    @RequestMapping("/order/getall.htm")
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    @RequestMapping("/order/getallordercustomer.htm")
	public List<Order> getAllOrderForCustomer(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    @RequestMapping("/order/remove.htm")
	public boolean removeOrder(long orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
    @RequestMapping("/order/removeallcustomer.htm")
	public boolean removeAllOrderForCustomer(long customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
    @RequestMapping("/order/update.htm")
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
