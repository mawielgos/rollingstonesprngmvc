package com.rollingstone.customer.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.ehcache.annotations.Cacheable;
import com.rollingstone.customer.model.Contact;
import com.rollingstone.customer.model.Customer;
import com.rollingstone.customer.utils.HibernateUtil;

@Repository
public class CustomerHibernateDaoImpl implements ICustomerDao {

	@Autowired
	HibernateUtil hbUtil;
	
	Logger logger = Logger.getLogger(CustomerHibernateDaoImpl.class);
	
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

	@Cacheable(cacheName = "getAllCustomer")
	public List<Customer> getAllCustomers(int pageNum, int pageSize) {
		SessionFactory sf = hbUtil.getSessionFactory();
        Session session = sf.openSession();

        Criteria c = session.createCriteria(Customer.class);
        
        int start = pageNum * pageSize;

        c.setMaxResults(pageSize);
        c.setFirstResult(start);
        List<Customer> customerList = c.list();

        session.close();

        return customerList;
	}

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

	public List<Customer> getSearchCustomers(int pageNum, int pageSize, String customerName, String houseNumber, String street) {
		SessionFactory sf = hbUtil.getSessionFactory();
        Session session = sf.openSession();

        Criteria c = session.createCriteria(Customer.class, "customer");
        
        int start = pageNum * pageSize;
        c.setMaxResults(pageSize);
        c.setFirstResult(start);
        
        c.createAlias("customer.customerAddress", "address");
        
        if (!customerName.isEmpty()){
        	c.add(Restrictions.ilike("customer.customerName", "%"+customerName+"%"));
        }
        
        if (!houseNumber.isEmpty()){
        	c.add(Restrictions.eq("address.houseNumber", Integer.parseInt(houseNumber)));
        }

        if (!street.isEmpty()){
        	c.add(Restrictions.ilike("address.street", "%"+street+"%"));
        }

        List<Customer> customerList = c.list();

        session.close();

        return customerList;
	}
}
