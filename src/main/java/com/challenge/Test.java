package com.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.challenge.demo.dto.AnswerDTO;
import com.challenge.demo.dto.UserDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test {
	
	public static void main(String[] args) {
		Gson g = new GsonBuilder().create();
		UserDTO user = new UserDTO();
		user.setSiteId(1L);
		user.setUserName("Jonh Jones");
		
		AnswerDTO answerDTO = new AnswerDTO();
		answerDTO.setUserId(1L);
		Map<Long, List<Long>> map = new HashMap<>();
		List<Long> list = new ArrayList<>();
		list.add(3L);
		list.add(1L);
		map.put(2L, list);
		answerDTO.setAnswers(map);
		System.out.println(g.toJson(answerDTO));
	}

}
