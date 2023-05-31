package com.telusuko.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="quiz")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuizEntity {
//	Quiz App (No Login) UI : Admin -> CRUD with Questions (id, question, opt1.. opt4, ans, tech), Create Quiz (tech), verify answer USer -> play the quiz
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;
	private String technology;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	

}
