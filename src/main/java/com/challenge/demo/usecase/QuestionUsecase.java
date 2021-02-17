package com.challenge.demo.usecase;

import java.util.List;

import com.challenge.demo.dto.QuestionAnswerDTO;
import com.challenge.demo.dto.QuestionDTO;
import com.challenge.demo.exception.QuestionException;

public interface QuestionUsecase {
	
	QuestionDTO createQuestion(QuestionDTO question) throws QuestionException;
	
	List<QuestionDTO> getSites() throws QuestionException;
	
	QuestionDTO updateQuestion(Long id, QuestionDTO question) throws QuestionException;

	QuestionDTO delete(Long questionId) throws QuestionException;
	
	QuestionDTO getQuestionById(Long questionId) throws QuestionException;
	
	QuestionAnswerDTO createQuestionAnswers(Long questionId, QuestionAnswerDTO newQADto) throws QuestionException;
	
	List<QuestionAnswerDTO> getQuestionAnswers(Long questionId) throws QuestionException;


}
