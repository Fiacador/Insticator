package com.challenge.demo.usecase;

import com.challenge.demo.dto.AnswerDTO;

public interface AnswerUsecase {

	AnswerDTO createAnswer(AnswerDTO incomingQuestion);

	AnswerDTO getAnswersByUser(Long userId);


}
