package com.rollingstone.orderprocessing.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rollingstone.orderprocessing.model.Customer;

public class CustomerHibernateDaoImpl implements ICustomerDao {

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCsutomer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer updateCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByMemberSince(Date memberSince) {
		List<Customer> customers = new ArrayList<Customer>();
		
		customers.add(new Customer());
		customers.add(new Customer());
		customers.add(new Customer());
		
		return customers;

	}

	@Override
	public List<Customer> findByZipCode(long zipCode) {
		List<Customer> customers = new ArrayList<Customer>();
		
		customers.add(new Customer());
		customers.add(new Customer());
		customers.add(new Customer());
		
		return customers;
	}

	
}
