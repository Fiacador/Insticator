package com.challenge.demo.converter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.challenge.demo.converter.AnswerConverter;
import com.challenge.demo.dto.AnswerDTO;
import com.challenge.demo.entity.AnswerEntity;
import com.challenge.demo.entity.QuestionAnswerEntity;
import com.challenge.demo.entity.QuestionEntity;
import com.challenge.demo.entity.UserEntity;

@Component
public class AnswerConverterImpl implements AnswerConverter {

	@Override
	public AnswerEntity dtoToEntity(UserEntity ue, QuestionEntity qe, QuestionAnswerEntity qae) {
		final AnswerEntity ae = new AnswerEntity();
		ae.setQuestions(qe);
		ae.setUser(ue);
		ae.setQuestionsAnswer(qae);
		return ae;
	}

	@Override
	public AnswerDTO entityToDTO(List<AnswerEntity> list) {
		AnswerDTO answerDTO = new AnswerDTO();
		Map<Long, List<Long>> map = new HashMap<>();
		
		for (AnswerEntity answerEntity : list) {
			answerDTO.setUserId(answerEntity.getUser().getUserId());
			List<Long> answers = map.get(answerEntity.getQuestions().getQuestionId());
			if(answers==null) {
				answers = new ArrayList<>();
			}
			answers.add(answerEntity.getQuestionsAnswer().getId());
			map.put(answerEntity.getQuestions().getQuestionId(), answers);
			answerDTO.setAnswers(map);
			
			
		}
		
		return answerDTO;
	}



	


}
