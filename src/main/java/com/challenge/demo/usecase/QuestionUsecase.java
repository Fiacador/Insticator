package com.challenge.demo.usecase;

import java.util.List;

import com.challenge.demo.dto.QuestionAnswerDTO;
import com.challenge.demo.dto.QuestionDTO;

public interface QuestionUsecase {
	
	QuestionDTO createQuestion(QuestionDTO question);
	
	List<QuestionDTO> getSites();
	
	QuestionDTO updateQuestion(Long id, QuestionDTO question);

	QuestionDTO delete(Long questionId);
	
	QuestionDTO getQuestionById(Long questionId);
	
	QuestionAnswerDTO createQuestionAnswers(Long questionId, QuestionAnswerDTO newQADto);
	
	List<QuestionAnswerDTO> getQuestionAnswers(Long questionId);

	QuestionAnswerDTO createQuestionAnswersMultipleChoice(Long questionId, List<QuestionAnswerDTO> newQADto);

}
