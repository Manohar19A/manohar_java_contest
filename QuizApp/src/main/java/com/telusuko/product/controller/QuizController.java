package com.telusuko.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusuko.product.entity.QuizEntity;
import com.telusuko.product.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://localhost:3001")
public class QuizController {
	
	@Autowired
	private QuizService service;
	@PostMapping
	public QuizEntity addQuiz(@RequestBody QuizEntity quiz) {
		return service.addQuiz(quiz);
		
	}
	@GetMapping
	public List<QuizEntity> getQuies(){
		return service.getQuizes();
	}
	@PutMapping("/{id}")
	public QuizEntity updateQuiz(@RequestBody QuizEntity quiz,@PathVariable("id")int id) throws Exception {
		return service.updateQuiz(quiz, id);
		
	}
	@DeleteMapping("/{id}")
	public void deleteQuiz(@PathVariable("id") int id) {
		service.deleteQuizById(id);
	}

}
