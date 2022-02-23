package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the customer service
	@Autowired
	private CustomerService customerservice;
	
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		//get the customer from service layer
		List<Customer> theCustomers = customerservice.getCustomers();
		
		//add customers to the model
	    theModel.addAttribute("customers",theCustomers);
		
	    return "list-customers";}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer using our service
		customerservice.saveCustomer(theCustomer);
		
		return "redirect:/customer/list"; 
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		
		//get customer from the database
		Customer theCustomer = customerservice.getCustomers(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		//send over to acual form
		return "customer-form";
	}
	@GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("customerId") int theId,Model theModel) {
		
		//get customer from database
		Customer theCustomer = customerservice.getCustomers(theId);
		
		//delete object
		customerservice.deleteCustomer(theCustomer);
		//send over to acual form
		return "redirect:/customer/list"; 
	}	
}
