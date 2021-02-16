package com.challenge.demo.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.challenge.demo.converter.QuestionConverter;
import com.challenge.demo.dto.QuestionDTO;
import com.challenge.demo.entity.QuestionEntity;
import com.challenge.demo.entity.SiteEntity;

@Component
public class QuestionConverterImpl implements QuestionConverter{

	@Override
	public QuestionDTO entityToDto(QuestionEntity entity) {
		QuestionDTO obj = new QuestionDTO();
		obj.setSiteId(entity.getSite().getSiteId());
		obj.setQuestionId(entity.getQuestionId());
		obj.setQuestion(entity.getQuestion());
		obj.setUpdatedAt(entity.getUpdatedAt());
		obj.setCreatedAt(entity.getCreatedAt());
		return obj;
	}

	@Override
	public QuestionEntity dtoToEntity(QuestionDTO dto, SiteEntity siteEntity) {
		QuestionEntity entity = new QuestionEntity();
		entity.setIsExact(dto.getIsExact());
		entity.setMaxQuestionAnswer(dto.getMaxQuestionAnswer());
		entity.setMaxResponseAnswer(dto.getMaxResponseAnswer());
		entity.setQuestion(dto.getQuestion());
		entity.setSite(siteEntity);
		return entity;
	}
	
	@Override
	public  List<QuestionDTO> entityToDto(List<QuestionEntity> questions) {
		final List<QuestionDTO> ret = new ArrayList<>();
		questions.forEach(question -> 
			ret.add(entityToDto(question)));
		return ret;
	}


}
