package com.challenge.demo.converter;

import java.util.List;

import com.challenge.demo.dto.UserDTO;
import com.challenge.demo.entity.SiteEntity;
import com.challenge.demo.entity.UserEntity;

public interface UserConverter {
	
	UserEntity dtoToEntity(UserDTO dto,SiteEntity se);
	UserDTO entityToDto(UserEntity entity);
	List<UserDTO> entityToDto(List<UserEntity> users);


}
