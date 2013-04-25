package com.rollingstone.orderprocessing.dao;

import java.util.Date;
import java.util.List;

import com.rollingstone.orderprocessing.model.Customer;

public interface ICustomerDao {

	Customer addCustomer(Customer customer) throws Exception;
	
	List<Customer> getAllCustomers();
	
	Customer getCustomer(long customerId);
	
	boolean removeCustomer(int customerId) throws Exception;
	
	boolean updateCustomer(Customer customer) throws Exception;
	
	List<Customer> findByMemberSince(Date memberSince);
	
	List<Customer> findByZipCode(long zipCode);
	
}
