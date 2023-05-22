package com.telusuko.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusuko.product.entity.Product;
import com.telusuko.product.repository.ProductRepo;

@Service
public class ProductServicde {
	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> getAllproducts(){
		return productRepo.findAll();
		
	}
	public List<Product> getByWarranty(int warranty){
		List<Product> products = productRepo.findByWarrantyLessThan(warranty);
		return products;	
	}
	public List<Product> getByPlace(String place){
		List<Product> products = productRepo.findByPlace(place);
		return products;	
	}
}
