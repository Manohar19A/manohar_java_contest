package com.telusuko.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.telusuko.product.entity.QuizEntity;
import com.telusuko.product.repo.QuizRepo;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepo repo;
	
	public QuizEntity addQuiz(QuizEntity quiz) {
		return repo.save(quiz);
		
	}
	public List<QuizEntity> getQuizes(){
		return repo.findAll();
	}
	public QuizEntity updateQuiz(QuizEntity quiz,int id) throws Exception {
		
//		QuizEntity uent =repo.findById(id).orElseThrow(() ->new Exception());
//		uent.setId(id);
//		uent.setQuestion(quiz.getQuestion());
//		uent.setTechnology(quiz.getTechnology());
//		uent.setOption1(quiz.getOption1());
//		uent.setAnswer(quiz.getAnswer());
//		uent.setOption2(quiz.getOption2());
//		uent.setOption3(quiz.getOption3());
//		uent.setOption4(quiz.getOption4());
		
		Optional<QuizEntity> quizdata = repo.findById(id);
		QuizEntity quizs = quizdata.orElse(new QuizEntity());
		quizs.setQuestion(quiz.getQuestion());
		return repo.save(quizs);
		
	}
	public void deleteQuizById(int id) {
		repo.deleteById(id);
    }

}
