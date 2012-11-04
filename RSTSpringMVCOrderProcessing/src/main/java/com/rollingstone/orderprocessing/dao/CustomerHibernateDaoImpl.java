package com.rollingstone.orderprocessing.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rollingstone.orderprocessing.model.Customer;

@Repository
public class CustomerHibernateDaoImpl implements ICustomerDao {

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		List<Customer> customers = new ArrayList<Customer>();
		for(int i=0;i<10;i++){
			Customer customer = new Customer();
			customers.add(customer);
			customer.setCustomerId(100+i);
			customer.setBalance(500+i);
			customer.setCustomerName("Customer - "+i);
		}
		
		return customers;
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
