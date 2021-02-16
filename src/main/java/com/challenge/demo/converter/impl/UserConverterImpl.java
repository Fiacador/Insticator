package com.challenge.demo.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.demo.converter.SiteConverter;
import com.challenge.demo.converter.UserConverter;
import com.challenge.demo.dto.UserDTO;
import com.challenge.demo.entity.SiteEntity;
import com.challenge.demo.entity.UserEntity;

@Component
public class UserConverterImpl implements UserConverter {

	@Autowired
	private SiteConverter siteConverter;
	
	@Override
	public UserEntity dtoToEntity(UserDTO dto, SiteEntity se) {
		UserEntity ue = new UserEntity();
		ue.setUserName(dto.getUserName());
		ue.setUserUUID(dto.getUserUUID());
		ue.setSite(se);
		return null;
	}

	@Override
	public UserDTO entityToDto(UserEntity entity) {
		UserDTO user = new UserDTO();
		user.setCreatedAt(entity.getCreatedAt());
		user.setSite(siteConverter.entityToDto(entity.getSite()));
		user.setUpdatedAt(entity.getUpdatedAt());
		user.setUserId(entity.getUserId());
		user.setUserName(entity.getUserName());
		return user;
	}

	@Override
	public List<UserDTO> entityToDto(List<UserEntity> users) {
		List<UserDTO> listUsers = new ArrayList<>();
		users.forEach(user -> listUsers.add(entityToDto(user)));
		return listUsers;
	}

}
