package com.rollingstone.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.rollingstone.customer.dao.ICustomerDao;
import com.rollingstone.customer.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService{

	ICustomerDao customerDao;
	
	public ICustomerDao getCustomerDao() {
		return customerDao;
	}

	@Autowired
	@Required
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public Customer addCustomer(Customer customer) throws Exception {
		return customerDao.addCustomer(customer);
	}

	public List<Customer> getAllCustomers(int pageNum, int pageSize) {
		return customerDao.getAllCustomers(pageNum, pageSize);
	}

	public boolean removeCustomer(int customerId) throws Exception {
		return customerDao.removeCustomer(customerId);
	}

	public boolean updateCustomer(Customer customer) throws Exception {
		return customerDao.updateCustomer(customer);
	}

	public List<Customer> getSearchCustomers(int pageNum, int pageSize, String customerName, String houseNumber, String street) {
		if (customerName == null){
			customerName = "";
		}
		if (houseNumber == null){
			houseNumber = "";
		}
		if (street == null){
			street = "";
		}
		
		return customerDao.getSearchCustomers(pageNum, pageSize, customerName, houseNumber, street);
	}
}
