package com.learning.springdemo.service;

import java.util.List;

import com.learning.springdemo.entity.Customer;


public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int customerId);

	public void deleteCustomer(int customerId);
}
