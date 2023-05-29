package com.telusuko.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Product addProduct(Product p) {
		
		return productRepo.save(p);
	}
	public List<Product> getRecords(Integer pageNumber, Integer pageSize) {
		Pageable  p = PageRequest.of(pageNumber, pageSize);
		Page<Product> pageProducts = productRepo.findAll(p);
//		List<Product> allProducts = pageProducts.getContent();
		List<Product> list = new ArrayList<>();
		pageProducts.forEach(product ->{
			Product pr = new Product();
			pr.setId(product.getId());
			pr.setName(product.getName());
			pr.setType(product.getType());
			pr.setPlace(product.getPlace());
			pr.setWarranty(product.getWarranty());
			list.add(pr);
		});
		
				
		return list;
		
	}
}
