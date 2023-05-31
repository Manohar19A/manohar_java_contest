package com.telusuko.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusuko.product.entity.QuizEntity;
@Repository
public interface QuizRepo extends JpaRepository<QuizEntity, Integer> {

}
