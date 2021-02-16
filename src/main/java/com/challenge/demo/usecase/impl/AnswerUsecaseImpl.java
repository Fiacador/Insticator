package com.challenge.demo.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.demo.converter.AnswerConverter;
import com.challenge.demo.dto.AnswerDTO;
import com.challenge.demo.entity.AnswerEntity;
import com.challenge.demo.entity.QuestionAnswerEntity;
import com.challenge.demo.entity.QuestionEntity;
import com.challenge.demo.entity.UserEntity;
import com.challenge.demo.repository.AnswerRepository;
import com.challenge.demo.repository.QuestionAnswerRepository;
import com.challenge.demo.repository.QuestionRepository;
import com.challenge.demo.repository.UserRepository;
import com.challenge.demo.usecase.AnswerUsecase;

@Component
public class AnswerUsecaseImpl implements AnswerUsecase{
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private UserRepository userRespository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionAnswerRepository questionAnswerRepository;
	
	@Autowired
	private AnswerConverter answerConverter;
	

	@Override
	public AnswerDTO createAnswer(AnswerDTO incomingAnswer) {
		UserEntity ue = userRespository.findById(incomingAnswer.getUserId()).orElseGet(null);
		List<AnswerEntity> list = new ArrayList<>();
		incomingAnswer.getAnswers().forEach((k,v) ->{
			QuestionEntity qe = questionRepository.findById(k).orElseGet(null);
			for(Long idQuestionAnswer : v) {
				QuestionAnswerEntity qae = questionAnswerRepository.findById(idQuestionAnswer).orElseGet(null);
				AnswerEntity ae = answerConverter.dtoToEntity(ue, qe, qae);
				list.add(answerRepository.save(ae));
			}
			
		});
		AnswerDTO answer =answerConverter.entityToDTO(list);
		return answer;
	}

	@Override
	public AnswerDTO getAnswersByUser(Long userId) {
		List<AnswerEntity> list = answerRepository.findByUserId(userId);
		return answerConverter.entityToDTO(list);
	}

}
