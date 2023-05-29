package com.telusuko.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusuko.product.entity.Product;
import com.telusuko.product.service.ProductServicde;

@RestController
@RequestMapping("/prod")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	private ProductServicde productServicde;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllproducts(){
		return new ResponseEntity<List<Product>>(productServicde.getAllproducts(),HttpStatus.OK);
		
	}

	@GetMapping("/is/{warranty}")
	public ResponseEntity<List<Product>> getProductsByWarranty(@PathVariable int warranty){
		return new ResponseEntity<List<Product>>(productServicde.getByWarranty(warranty),HttpStatus.OK);
	}
	@GetMapping("/place/{place}")
	public ResponseEntity<List<Product>> getProductByPlace(@PathVariable String place){
		return new ResponseEntity<List<Product>>(productServicde.getByPlace(place),HttpStatus.OK);
	}
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product p) {
		
		return productServicde.addProduct(p);
		
	}
	@GetMapping("/pagination")
	public ResponseEntity<List<Product>> getRecords(@RequestParam Integer pageNumber, Integer pageSize ){
		return new ResponseEntity<List<Product>>(productServicde.getRecords(pageNumber,pageSize),HttpStatus.OK);
		
	}
	}

