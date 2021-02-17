package com.challenge.demo.converter;

import java.util.List;

import com.challenge.demo.dto.QuestionAnswerDTO;
import com.challenge.demo.entity.QuestionAnswerEntity;
import com.challenge.demo.entity.QuestionEntity;

public interface QuestionAnswerConverter {
	
	QuestionAnswerDTO entityToDTO(QuestionAnswerEntity entity);
	QuestionAnswerEntity dtoToEntity(QuestionAnswerDTO dto, QuestionEntity entity);
	List<QuestionAnswerDTO> entityToDTO(List<QuestionAnswerEntity> answers);


}
