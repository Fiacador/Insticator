package com.challenge.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.demo.dto.AnswerDTO;
import com.challenge.demo.usecase.AnswerUsecase;

@RestController
@RequestMapping("/answers")
public class AnswerController {
	
	@Autowired
	AnswerUsecase answerUsecase;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AnswerDTO> createQuestion(@RequestBody AnswerDTO incomingQuestion) {
		return new ResponseEntity<AnswerDTO>(answerUsecase.createAnswer(incomingQuestion), HttpStatus.OK);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<AnswerDTO> getAnswersByUser(@PathVariable(value = "id") Long userId) {
		return new ResponseEntity<AnswerDTO>(answerUsecase.getAnswersByUser(userId), HttpStatus.OK);

	}
	
	
	
	

}
