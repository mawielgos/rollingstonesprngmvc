package com.rollingstone.orderprocessing.service;

import java.util.Date;
import java.util.List;

import com.rollingstone.orderprocessing.model.Customer;
import com.rollingstone.orderprocessing.model.State;

public interface ICustomerService {

	Customer addCustomer(Customer customer) throws Exception;
	
	List<Customer> getAllCustomers();
	
	Customer getCustomer(long customerId);
	
	boolean removeCustomer(int customerId) throws Exception;
	
	boolean updateCustomer(Customer customer) throws Exception;
	
	List<State> getAllStates();
	
	List<Customer> findByMemberSince(Date memberSince);
	
	List<Customer> findByZipCode(long zipCode);
	
}
