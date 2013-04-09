package com.rollingstone.orderprocessing.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.rollingstone.orderprocessing.dao.ICustomerDao;
import com.rollingstone.orderprocessing.model.Customer;
import com.rollingstone.orderprocessing.model.State;

@Service
public class CusrtomerServiceImpl implements ICustomerService{

	ICustomerDao customerDao;
	
	
	public ICustomerDao getCustomerDao() {
		return customerDao;
	}

	@Autowired
	@Required
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer addCustomer(Customer customer) throws Exception {
		return customerDao.addCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomer(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCsutomer(long customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer updateCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<State> getAllStates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByMemberSince(Date memberSince) {
		List<Customer> customers  = customerDao.findByMemberSince(memberSince);
		return customers;

	}

	@Override
	public List<Customer> findByZipCode(long zipCode) {
		List<Customer> customers  = customerDao.findByZipCode(zipCode);
		return customers;
	}

}
