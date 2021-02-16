package com.challenge.demo.converter;

import java.util.List;

import com.challenge.demo.dto.QuestionDTO;
import com.challenge.demo.entity.QuestionEntity;
import com.challenge.demo.entity.SiteEntity;

public interface QuestionConverter {

	QuestionDTO entityToDto(QuestionEntity entity);
	QuestionEntity dtoToEntity(QuestionDTO dto, SiteEntity siteEntity);
	List<QuestionDTO> entityToDto(List<QuestionEntity> questions);
}
