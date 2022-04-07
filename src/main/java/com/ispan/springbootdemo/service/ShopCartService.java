package com.ispan.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ispan.springbootdemo.model.ShopCartRepository;
import com.ispan.springbootdemo.model.shopCart;

@Service
public class ShopCartService {
	
	@Autowired
	private ShopCartRepository shopCartDao;

	public void insert(shopCart cart) {
		shopCartDao.save(cart);
	}
	
	public shopCart findById(Integer id) {
		Optional<shopCart> option = shopCartDao.findById(id);
		
		if(option.isPresent()) {
			return option.get();
		}
		return null;
	}
	public void deleteById(Integer id) {
		shopCartDao.deleteById(id);
	}
	
	public List<shopCart> findAllCart(){
		return shopCartDao.findAll();
	}
	
	public Page<shopCart> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10,Sort.Direction.DESC);
		
		Page<shopCart> page = shopCartDao.findAll(pgb);
		
		return page;
	}
	
//	public shopCart getLastest() {
//		return shopCartDao.findFirstByOrderByAddedDesc();
//	}
}
