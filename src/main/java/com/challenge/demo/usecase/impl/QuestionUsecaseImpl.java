package com.challenge.demo.usecase.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.demo.converter.QuestionAnswerConverter;
import com.challenge.demo.converter.QuestionConverter;
import com.challenge.demo.converter.SiteConverter;
import com.challenge.demo.dto.QuestionAnswerDTO;
import com.challenge.demo.dto.QuestionDTO;
import com.challenge.demo.entity.QuestionAnswerEntity;
import com.challenge.demo.entity.QuestionEntity;
import com.challenge.demo.exception.QuestionException;
import com.challenge.demo.repository.QuestionAnswerRepository;
import com.challenge.demo.repository.QuestionRepository;
import com.challenge.demo.repository.SiteRepository;
import com.challenge.demo.usecase.QuestionUsecase;
import com.challenge.utils.UtilsJson;

@Component

public class QuestionUsecaseImpl implements QuestionUsecase {

	Logger log = LoggerFactory.getLogger(QuestionUsecaseImpl.class);
	@Autowired
	SiteRepository siteRepository;

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	QuestionConverter questionConverter;
	
	@Autowired
	QuestionAnswerConverter questionAnswerConverter;

	@Autowired
	QuestionAnswerRepository questionAnswerRepository;

	@Autowired
	SiteConverter siteConverter;

	@Override
	public QuestionDTO createQuestion(QuestionDTO question) throws QuestionException {
		return siteRepository.findById(question.getSiteId()).map(site -> {
			return questionConverter
					.entityToDto(questionRepository.save(questionConverter.dtoToEntity(question, site)));
		}).orElseThrow(() -> {
			log.error("Error to save question {}", UtilsJson.create(question));
			return new QuestionException("Error to save question");

		});
	}

	@Override
	public List<QuestionDTO> getSites() throws QuestionException {
		return Optional.ofNullable(questionRepository.findAll())
				.map(questions -> questionConverter.entityToDto(questions)).orElseThrow(() -> {
					log.error("Error to get questions");
					return new QuestionException("Error to get questions");
				});
	}

	@Override
	public QuestionDTO updateQuestion(Long id, QuestionDTO incomingQuestion) throws QuestionException {
		return questionRepository.findById(id).map(question -> {
			question.setQuestion(incomingQuestion.getQuestion());
			question.setSite(siteConverter.dtoToEntity(incomingQuestion.getSite()));
			return questionConverter.entityToDto(questionRepository.save(question));
		}).orElseThrow(() -> {
			log.error("Error to update question {}", UtilsJson.create(incomingQuestion));
			return new QuestionException("Error to update question");

		});
	}

	@Override
	public QuestionDTO delete(Long questionId) throws QuestionException{ 

		return questionRepository.findById(questionId).map(question -> {
			questionRepository.delete(question);
			return questionConverter.entityToDto(question);
		}).orElseThrow(() -> {
			log.error("Error to delete question {}", UtilsJson.create(""+questionId));
			return new QuestionException("Error to delete question");
			
		});
	}

	@Override
	public QuestionDTO getQuestionById(Long questionId) throws QuestionException{ 

		return questionRepository.findById(questionId).map(question -> questionConverter.entityToDto(question))
				.orElseThrow(() -> {
					log.error("Error to get questionId {}", UtilsJson.create(""+questionId));
					return new QuestionException("Error to save question");
					
				});
	}

	@Override
	public QuestionAnswerDTO createQuestionAnswers(Long questionId, QuestionAnswerDTO newQADto) throws QuestionException {
		QuestionEntity qe = questionRepository.findById(questionId).orElseThrow(() -> {
			log.error("Error to get questionId {}", UtilsJson.create(""+questionId));
			return new QuestionException("Error to save question");
			
		});
		if (newQADto.getDirection() == null) {
			final QuestionAnswerEntity newQa = questionAnswerConverter.dtoToEntity(newQADto, qe);
			return questionAnswerConverter.entityToDTO(questionAnswerRepository.save(newQa));
		}
		if ("VERTICAL".equals(newQADto.getDirection())) {
			Optional.ofNullable(questionRepository.findByParentIdAndDirectionHorizontal(qe.getQuestionId()))
					.map(questionHorizontal -> {
						
						for (QuestionEntity questionEntity : questionHorizontal) {
							Long count = questionAnswerRepository.countByQuestionId(questionEntity.getQuestionId());
							if (count < questionEntity.getMaxQuestionAnswer()) {
								final QuestionAnswerEntity newQa = questionAnswerConverter.dtoToEntity(newQADto, qe);
								questionAnswerRepository.save(newQa);
							}
							
							
						}
						
						return questionHorizontal;
					}).orElseThrow(() -> {
						log.error("Error to get questionId {}", UtilsJson.create(""+questionId));
						return new QuestionException("Error to save question");
						
					});
		} else if ("HORIZONTAL".equals(newQADto.getDirection())) {
			Long count = questionRepository.countByParentId(qe.getQuestionId());
			if (count < qe.getMaxQuestionAnswer()) {
				QuestionEntity newQuestionChild = new QuestionEntity();
				newQuestionChild.setParentId(qe.getQuestionId());
				newQuestionChild.setQuestion(newQADto.getAnswer());
				// We have two answers the axis horizontal and the axis vertical
				newQuestionChild.setMaxResponseAnswer(2);
				// Is important add 1 to max question because must have the question self.
				newQuestionChild.setMaxQuestionAnswer(newQADto.getMaxQuestionAnswer() + 1);
				newQuestionChild.setIsExact(false);
				newQuestionChild.setDirection(newQADto.getDirection());
				newQuestionChild.setSite(qe.getSite());
				final QuestionEntity newQuestion = questionRepository.save(newQuestionChild);
				final QuestionAnswerEntity newQa =questionAnswerConverter.dtoToEntity(newQADto, newQuestion);
				return questionAnswerConverter.entityToDTO(questionAnswerRepository.save(newQa));
			}
		}
		 log.error("Direction invalid {}", UtilsJson.create(newQADto));
		throw new QuestionException("Direction invalid");
	}

	@Override
	public List<QuestionAnswerDTO> getQuestionAnswers(Long questionId) throws QuestionException {
		return questionRepository.findById(questionId).map(question -> {
			return questionAnswerConverter.entityToDTO(question.getAnswers());
		}).orElseThrow(() -> {
			log.error("Error to get questions");
			return new QuestionException("Error to get questions");
		});

	}


}
