package com.rollingstone.orderprocessing.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rollingstone.orderprocessing.model.Contact;
import com.rollingstone.orderprocessing.model.Customer;
import com.rollingstone.orderprocessing.utils.HibernateUtil;

@Repository
public class CustomerHibernateDaoImpl implements ICustomerDao {

	@Autowired
	HibernateUtil hbUtil;
	
	Logger logger = Logger.getLogger(CustomerHibernateDaoImpl.class);
	
	@Override
	public Customer addCustomer(Customer customer) throws Exception {
		SessionFactory sf = hbUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        try {
        	List<Contact> contacts = (List<Contact>) customer.getContacts();

        	customer.getCustomerAddress().setCustomer(customer);
        	customer.getDefaultCard().setCustomer(customer);
        	for (Iterator<Contact> contactItr = contacts.iterator(); contactItr.hasNext(); ){
        		Contact contact = contactItr.next();
        		contact.setCustomer(customer);
        	}
        	
        	session.save(customer);

        	session.getTransaction().commit();
        }catch(Exception e){
        	session.getTransaction().rollback();
        	logger.error(e.getMessage());
        	throw e;
        }finally{
            session.close();
        }
        
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		SessionFactory sf = hbUtil.getSessionFactory();
        Session session = sf.openSession();

        Criteria c = session.createCriteria(Customer.class);
        List<Customer> customerList = c.list();

        session.close();

        return customerList;
	}

	@Override
	public Customer getCustomer(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCustomer(int customerId) throws Exception {
		SessionFactory sf = hbUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        try{
    		Customer customer = (Customer) session.get(Customer.class, customerId);
    		session.delete(customer);
    		session.getTransaction().commit();
        }catch(Exception e){
        	session.getTransaction().rollback();
        	logger.error(e.getMessage());
        	throw e;
        }finally{
            session.close();
        }

        return true;
	}

	@Override
	public boolean updateCustomer(Customer customer) throws Exception {
		SessionFactory sf = hbUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        try {
        	List<Contact> contacts = (List<Contact>) customer.getContacts();

        	customer.getCustomerAddress().setCustomer(customer);
        	customer.getDefaultCard().setCustomer(customer);
        	for (Iterator<Contact> contactItr = contacts.iterator(); contactItr.hasNext(); ){
        		Contact contact = contactItr.next();
        		contact.setCustomer(customer);
        	}
        	
        	session.update(customer);

        	session.getTransaction().commit();
        }catch(Exception e){
        	session.getTransaction().rollback();
        	logger.error(e.getMessage());
        	throw e;
        }finally{
            session.close();
        }
        
		return true;
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
