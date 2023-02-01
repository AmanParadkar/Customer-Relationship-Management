package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query 
		Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
		
		//execute query and get the result list
		List<Customer> customer = theQuery.getResultList();
 		
		//return the result
		return customer;
		
	}


	@Override
	//@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		//save the object
		currentSession.saveOrUpdate(theCustomer); 
	}


	@Override
	//@Transactional
	public Customer getCustomer(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
					
		//get the object
		Customer theCustomer = currentSession.get(Customer.class,theId);
		
		return theCustomer;
	}


	@Override
	//@Transactional
	public void deleteCustomer(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
					
		//get the object
		Customer theCustomer = currentSession.get(Customer.class,theId);
				
		//delete the customer
		currentSession.delete(theCustomer); 
		
	}

}
