package com.rollingstone.orderprocessing.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.rollingstone.orderprocessing.model.Address;
import com.rollingstone.orderprocessing.model.Contact;
import com.rollingstone.orderprocessing.model.CreditCard;
import com.rollingstone.orderprocessing.model.Customer;
import com.rollingstone.orderprocessing.utils.HibernateUtil;

@Repository
public class CustomerHibernateDaoImpl implements ICustomerDao {

	Logger logger = Logger.getLogger(CustomerHibernateDaoImpl.class);
	
	@Override
	public Customer addCustomer(Customer customer) throws Exception {
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        try {
        	Address addr = customer.getCustomerAddress();
        	CreditCard crCard = customer.getDefaultCard();
//        	Contact contact = customer.getContacts();
        	List<Contact> contacts = (List<Contact>) customer.getContacts();
        	logger.debug(contacts);

        	session.save(addr);
        	session.save(crCard);

        	/** Need to ask ... 
        	 * If i dont put the following 2 lines
        	 * then the server gives error at saving ....
        	 * Some transient value error **/
//        	customer.setCustomerAddress(addr);
//        	customer.setDefaultCard(crCard);
        	
        	session.save(customer);

        	for (Iterator<Contact> contactItr = contacts.iterator(); contactItr.hasNext(); ){
        		Contact contact = contactItr.next();
        		contact.setCustomer(customer);
        		session.save(contact);
        	}
        	
        	session.getTransaction().commit();
        }catch(Exception e){
        	session.getTransaction().rollback();
        	logger.error(e.getMessage());
        	throw e;
        }finally{
            session.close();
            HibernateUtil.closeSessionFactory();
        }
        
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
