package com.challenge.demo.converter.impl;

import java.util.ArrayList;
import java.util.List;

import com.challenge.demo.converter.QuestionAnswerConverter;
import com.challenge.demo.dto.QuestionAnswerDTO;
import com.challenge.demo.entity.QuestionAnswerEntity;
import com.challenge.demo.entity.QuestionEntity;

public class QuestionAnswerConverterImpl implements QuestionAnswerConverter {

	@Override
	public QuestionAnswerDTO entityToDTO(QuestionAnswerEntity entity) {
		final QuestionAnswerDTO newQaDto = new QuestionAnswerDTO();

		newQaDto.setId(entity.getId());
		newQaDto.setAnswer(entity.getAnswer());
		newQaDto.setIsCorrectAnswer(entity.isCorrectAnswer());
		newQaDto.setCreatedAt(entity.getCreatedAt());
		newQaDto.setUpdatedAt(entity.getUpdatedAt());
		newQaDto.setQuestionId(entity.getQuestion().getQuestionId());

		return newQaDto;
	}

	@Override
	public QuestionAnswerEntity dtoToEntity(final QuestionAnswerDTO newQADto, final QuestionEntity question) {
		final QuestionAnswerEntity newQa = new QuestionAnswerEntity();
		newQa.setAnswer(newQADto.getAnswer());
		newQa.setIsCorrectAnswer(newQADto.getIsCorrectAnswer());
		newQa.setQuestion(question);

		return newQa;
	}
	
	@Override
	public  List<QuestionAnswerDTO> entityToDTO(final List<QuestionAnswerEntity> answers) {
		final List<QuestionAnswerDTO> ret = new ArrayList<>();
		for (QuestionAnswerEntity qa : answers) {
			ret.add(entityToDTO(qa));
		}
		return ret;
	}
	
	
}
