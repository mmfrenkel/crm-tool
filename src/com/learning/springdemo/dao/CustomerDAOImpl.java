package com.learning.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; 

import com.learning.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;  // recall this sessionFactory bean configured in spring mvc .xml file
	 
	@Override 
	public List<Customer> getCustomers() {
		
		// get the current session
		Session session = sessionFactory.getCurrentSession();
		
		// query should pull all customers
		Query<Customer> query = session.createQuery("from Customer order by lastName", 
				Customer.class);
		
		// get results and return them
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// add customer to db or update the customer if it already exists
		session.saveOrUpdate(customer);	
	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// retrieve customer object by id (primary key)
		return session.get(Customer.class, customerId);
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// delete customer by their id, pk
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", customerId);
		
		query.executeUpdate();
	}

}
