package com.rollingstone.customer.service;

import java.util.List;

import com.rollingstone.customer.model.Customer;

public interface ICustomerService {

	Customer addCustomer(Customer customer) throws Exception;
	
	List<Customer> getAllCustomers(int pageNum, int pageSize);
	
	boolean removeCustomer(int customerId) throws Exception;
	
	boolean updateCustomer(Customer customer) throws Exception;

	List<Customer> getSearchCustomers(int pageNum, int pageSize,
			String customerName, String houseNumber, String street);
}
