package com.challenge.demo.converter;

import java.util.List;

import com.challenge.demo.dto.AnswerDTO;
import com.challenge.demo.entity.AnswerEntity;
import com.challenge.demo.entity.QuestionAnswerEntity;
import com.challenge.demo.entity.QuestionEntity;
import com.challenge.demo.entity.UserEntity;

public interface AnswerConverter {

	AnswerEntity dtoToEntity(UserEntity ue, QuestionEntity qe, QuestionAnswerEntity qae);

	AnswerDTO entityToDTO(List<AnswerEntity> list);

}
