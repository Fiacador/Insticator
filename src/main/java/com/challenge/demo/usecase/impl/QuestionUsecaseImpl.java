package com.challenge.demo.usecase.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.demo.converter.QuestionConverter;
import com.challenge.demo.converter.SiteConverter;
import com.challenge.demo.dto.QuestionAnswerDTO;
import com.challenge.demo.dto.QuestionDTO;
import com.challenge.demo.entity.QuestionAnswerEntity;
import com.challenge.demo.entity.QuestionEntity;
import com.challenge.demo.repository.QuestionAnswerRepository;
import com.challenge.demo.repository.QuestionRepository;
import com.challenge.demo.repository.SiteRepository;
import com.challenge.demo.usecase.QuestionUsecase;

@Component
public class QuestionUsecaseImpl implements QuestionUsecase {

	@Autowired
	SiteRepository siteRepository;

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	QuestionConverter questionConverter;

	@Autowired
	QuestionAnswerRepository questionAnswerRepository;

	@Autowired
	SiteConverter siteConverter;

	@Override
	public QuestionDTO createQuestion(QuestionDTO question) {
		return siteRepository.findById(question.getSiteId()).map(site -> {
			return questionConverter
					.entityToDto(questionRepository.save(questionConverter.dtoToEntity(question, site)));
		}).orElseGet(() -> null);
	}

	@Override
	public List<QuestionDTO> getSites() {
		return Optional.ofNullable(questionRepository.findAll())
				.map(questions -> questionConverter.entityToDto(questions)).orElseGet(() -> null);
	}

	@Override
	public QuestionDTO updateQuestion(Long id, QuestionDTO incomingQuestion) {
		return questionRepository.findById(id).map(question -> {
			question.setQuestion(incomingQuestion.getQuestion());
			question.setSite(siteConverter.dtoToEntity(incomingQuestion.getSite()));
			return questionConverter.entityToDto(questionRepository.save(question));
		}).orElseGet(() -> null);
	}

	@Override
	public QuestionDTO delete(Long questionId) {

		return questionRepository.findById(questionId).map(question -> {
			questionRepository.delete(question);
			return questionConverter.entityToDto(question);
		}).orElseGet(() -> null);
	}

	@Override
	public QuestionDTO getQuestionById(Long questionId) {

		return questionRepository.findById(questionId).map(question -> questionConverter.entityToDto(question))
				.orElseGet(() -> null);
	}

	@Override
	public QuestionAnswerDTO createQuestionAnswers(Long questionId, QuestionAnswerDTO newQADto) {
		QuestionEntity qe = questionRepository.findById(questionId).orElseGet(null);
		if (newQADto.getDirection() == null) {
			final QuestionAnswerEntity newQa = QuestionAnswerDTO.transform(newQADto, qe);
			return QuestionAnswerDTO.build(questionAnswerRepository.save(newQa));
		}
		if ("VERTICAL".equals(newQADto.getDirection())) {
			Optional.ofNullable(questionRepository.findByParentIdAndDirectionHorizontal(qe.getQuestionId()))
					.map(questionHorizontal -> {
						for (QuestionEntity questionEntity : questionHorizontal) {
							Long count = questionAnswerRepository.countByQuestionId(questionEntity.getQuestionId());
							if (count < questionEntity.getMaxQuestionAnswer()) {
								final QuestionAnswerEntity newQa = QuestionAnswerDTO.transform(newQADto,
										questionEntity);
								questionAnswerRepository.save(newQa);
							} else {
								return null;
							}
							
						}
						return null;
					});
		} else if ("HORIZONTAL".equals(newQADto.getDirection())) {
			Long count = questionRepository.countByParentId(qe.getQuestionId());
			if (count < qe.getMaxQuestionAnswer()) {
				QuestionEntity newQuestionChild = new QuestionEntity();
				newQuestionChild.setParentId(qe.getQuestionId());
				newQuestionChild.setQuestion(newQADto.getAnswer());
				//We have two answers the axis horizontal and the axis vertical
				newQuestionChild.setMaxResponseAnswer(2);
				//Is important add 1 to max question because must have the question self.
				newQuestionChild.setMaxQuestionAnswer(newQADto.getMaxQuestionAnswer()+1);
				newQuestionChild.setIsExact(false);
				newQuestionChild.setDirection(newQADto.getDirection());
				newQuestionChild.setSite(qe.getSite());
				final QuestionEntity newQuestion = questionRepository.save(newQuestionChild);
				final QuestionAnswerEntity newQa = QuestionAnswerDTO.transform(newQADto, newQuestion);
				return QuestionAnswerDTO.build(questionAnswerRepository.save(newQa));
			}
		} else {
			return null;
		}
		return null;
	}

	@Override
	public List<QuestionAnswerDTO> getQuestionAnswers(Long questionId) {
		return questionRepository.findById(questionId).map(question -> {
			return QuestionAnswerDTO.build(question.getAnswers());
		}).orElseGet(() -> null);

	}

	@Override
	public QuestionAnswerDTO createQuestionAnswersMultipleChoice(Long questionId, List<QuestionAnswerDTO> newQADto) {
		return null;
	}

}
