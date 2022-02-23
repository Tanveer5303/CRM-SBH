package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//@Transactional //remove this annotation because we have put this in service layer
	public List<Customer> getCustomers() {
		
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get the query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);
		
				
		//execute query and get result list
	    List<Customer> customers = theQuery.getResultList();
		
		//return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		
		currentSession.saveOrUpdate(theCustomer);
		
		
		
		
	}

	@Override
	public Customer getCustomers(int theId) {
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		//retrive the data using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete the data using primary key
		currentSession.delete(theCustomer);
				
		
	}
	
	

}
