package com.learning.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springdemo.dao.CustomerDAO;
import com.learning.springdemo.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		// delegate the call to the DAO
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int customerId) {

		return customerDAO.getCustomerById(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {

		customerDAO.deleteCustomer(customerId);
	}
}
