package com.telusuko.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusuko.product.entity.ShortEndUrl;

public interface ShortEndRepo extends JpaRepository<ShortEndUrl, Integer>{

}
