package com.rollingstone.orderprocessing.dao;

import java.util.Date;
import java.util.List;

import com.rollingstone.orderprocessing.model.Customer;

public interface ICustomerDao {

	Customer addCustomer(Customer customer);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomer(long customerId);
	
	boolean removeCsutomer();
	
	Customer updateCustomer();
	
	List<Customer> findByMemberSince(Date memberSince);
	
	List<Customer> findByZipCode(long zipCode);
	
}
