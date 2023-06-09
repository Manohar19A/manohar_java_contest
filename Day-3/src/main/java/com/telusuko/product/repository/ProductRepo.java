package com.telusuko.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusuko.product.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
public List<Product> findByWarrantyLessThan(Integer warranty);
public List<Product> findByPlace(String place);
}
