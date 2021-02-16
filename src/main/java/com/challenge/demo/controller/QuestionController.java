package com.challenge.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.demo.dto.QuestionAnswerDTO;
import com.challenge.demo.dto.QuestionDTO;
import com.challenge.demo.usecase.QuestionUsecase;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	
	@Autowired
	QuestionUsecase usecase;

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<QuestionDTO> createQuestion(@RequestBody QuestionDTO incomingQuestion) {
		return new ResponseEntity<QuestionDTO>(usecase.createQuestion(incomingQuestion), HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<QuestionDTO>> getSites() {
		return new ResponseEntity<List<QuestionDTO>>(usecase.getSites(), HttpStatus.OK);

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<QuestionDTO> updateQuestion(@RequestBody QuestionDTO incomingQuestion,
			@PathVariable(value = "id") Long questionId) {
		return new ResponseEntity<QuestionDTO>(usecase.updateQuestion(questionId, incomingQuestion), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<QuestionDTO> deleteQuestion(@PathVariable(value = "id") Long questionId) {
		return new ResponseEntity<QuestionDTO>(usecase.delete(questionId), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable(value = "id") Long questionId) {
		return new ResponseEntity<QuestionDTO>(usecase.getQuestionById(questionId), HttpStatus.OK);
	}

	@PostMapping("/{id}/answers")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<QuestionAnswerDTO> createQuestionAnswers(@PathVariable(value = "id") Long questionId,
			@RequestBody QuestionAnswerDTO newQADto) {
		return new ResponseEntity<QuestionAnswerDTO>(usecase.createQuestionAnswers(questionId, newQADto),
				HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}/answersmultiplechoice")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<QuestionAnswerDTO> createQuestionAnswersMultipleChoice(@PathVariable(value = "id") Long questionId,
			@RequestBody List<QuestionAnswerDTO> newQADto) {
		return new ResponseEntity<QuestionAnswerDTO>(usecase.createQuestionAnswersMultipleChoice(questionId, newQADto),
				HttpStatus.CREATED);
	}

	@GetMapping("/{id}/answers")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<QuestionAnswerDTO>> getQuestionAnswers(@PathVariable(value = "id") Long questionId) {

		return new ResponseEntity<List<QuestionAnswerDTO>>(usecase.getQuestionAnswers(questionId), HttpStatus.OK);

	}
}