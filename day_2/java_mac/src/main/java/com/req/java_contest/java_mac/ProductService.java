package com.req.java_contest.java_mac;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductService {
	List<Product> products = new ArrayList<>();
	ProductDB db = new ProductDB();
	
	public void addProduct(Product p) {
//		products.add(p);
		db.save(p);
		
	}
	public List<Product> getAllProducts(){
		return products;
	}
	public Product getProduct(String name) {
		for(Product p:products) {
			if(p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	public List<Product> getProductWithText(String text){
		String str = text.toLowerCase();
//		List<Product> prods = new ArrayList<Product>();
		List<Product> filteredList = products.stream()
			    .filter(obj -> obj.getPlace().toLowerCase().contains(str)|| obj.getName().toLowerCase().contains(str) ||obj.getType().toLowerCase().contains(str))
			    .collect(Collectors.toList());
//		for(Product p:products) {
//			String name = p.getName().toLowerCase();
//			String type = p.getType().toLowerCase();
//			String place = p.getPlace().toLowerCase();
//			if(name.contains(str)|| type.contains(str)|| place.contains(str)) {
//				prods.add(p);
//			}
//			
//		}
//		return prods;
		return filteredList;
	}
	public List<Product> getProductByPlace(String text){
		String str = text.toLowerCase();
		
//		List<Product> prods = new ArrayList<Product>();
		List<Product> filteredList = products.stream()
			    .filter(obj -> obj.getPlace().toLowerCase().contains(str))
			    .collect(Collectors.toList());
//		for(Product p:products) {
//		
//			String place = p.getPlace().toLowerCase();
//			if(place.contains(str)) {
//				prods.add(p);
//			}
//		}
//		return prods;
		return filteredList;
		
	}
	public List<Product> getProductByWarranty(int year){
//		List<Product> prods = new ArrayList<Product>();
		List<Product> filteredList = products.stream()
			    .filter(obj -> obj.getWarranty() >= year)
			    .collect(Collectors.toList());
//		List<Product> data = prods.stream().map(n->n.getWarranty() >= year);
//		Stream<Product> prod = Stream<Product>
		
//		for(Product p:products) {
//			if(p.getWarranty()>= year) {
//				prods.add(p);
//			}
//		}
//		return prods;
		return filteredList;
		
	}
 
}
