package com.rollingstone.customer.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rollingstone.customer.model.Customer;
import com.rollingstone.customer.service.ICustomerService;

@Controller
public class CustomerController {
	Logger logger = Logger.getLogger(CustomerController.class);
	
	private ICustomerService customerService;

	public ICustomerService getCustomerService() {
		return customerService;
	}

	@Autowired
	@Required
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value="/customer/add.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public boolean addCustomer(@RequestBody Customer customer) throws Exception {
		customerService.addCustomer(customer);
		return true;
	}

	@RequestMapping(value = { "/customer/remove.do", "/customer/delete.do" }, method = RequestMethod.GET)
	@ResponseBody
	public boolean removeCustomer(@RequestParam("customerId") int customerId)  throws Exception  {
		System.out.println("Inside removeCustomer");
		customerService.removeCustomer(customerId);
		return true;
	}
	
	@RequestMapping(value = "/customer/update.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean updateCustomer(@RequestBody Customer customer)  throws Exception  {
		customerService.updateCustomer(customer);
		return true;
	}

	@RequestMapping(value="/customer/list.view", method = RequestMethod.GET)
	public @ResponseBody List<Customer> listCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		
        return customers;
	}
}
