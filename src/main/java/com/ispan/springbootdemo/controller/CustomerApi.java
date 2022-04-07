package com.ispan.springbootdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.springbootdemo.model.Customer;
import com.ispan.springbootdemo.model.CustomerRepository;

@RestController
public class CustomerApi {

	@Autowired
	private CustomerRepository dao;

	@PostMapping(value = "customer/insert")
	public Customer insertCustomer() {
		Customer cus = new Customer("Will", 5);
		Customer resCus = dao.save(cus);

		return resCus;
	}

	@PostMapping(value = "customer/insert2")
	public Customer insertCustomer(@RequestBody Customer cus) {
		Customer resCus = dao.save(cus);
		return resCus;
	}

	@PostMapping(value = "customer/insertAll")
	public List<Customer> insertCustomer(@RequestBody List<Customer> cus) {
		List<Customer> responseList = dao.saveAll(cus);
		return responseList;
	}

	@GetMapping(value = "customer/get/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
		Optional<Customer> responseCus = dao.findById(id);

		if (responseCus.isPresent()) {
			return responseCus.get();
		}

		return null;
	}

	@GetMapping(value = "customer/get")
	public Customer getCustomerById2(@RequestParam Integer id) {
		Optional<Customer> responseCus = dao.findById(id);

		if (responseCus.isPresent()) {
			return responseCus.get();
		}

		return null;
	}
	
	@GetMapping(value="customer/page/{pageNumber}")
	public List<Customer> findByPage(@PathVariable Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber-1, 3,Sort.Direction.ASC,"id");
		Page<Customer> page = dao.findAll(pgb);
		List<Customer> list = page.getContent();
		return list;
	}
	
	@GetMapping(value="customer/findByName")
	public List<Customer> findByName(@RequestParam String name){
		return dao.findCustomerByName(name);
	}
	
	@GetMapping(value="customer/findByName2")
	public List<Customer> findByName2(@RequestParam String name){
		return dao.findCustomerByName2(name);
	}
	
	@GetMapping(value="customer/delete/{id}")
	public boolean deleteCustomer(@PathVariable Integer id) {
		dao.deleteCustomerById(id);
		return true;
	}
	
	@GetMapping(value="customer/level/{level}")
	public List<Customer> findByLevel(@PathVariable Integer level){
		return dao.findByLevelOrderByName(level);
	}

	
}
