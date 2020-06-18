package com.learning.springdemo.dao;

import java.util.List;

import com.learning.springdemo.entity.Customer;


public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int customerId);

	public void deleteCustomer(int customerId);
		
}
