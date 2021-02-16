package com.challenge.demo.usecase.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.demo.converter.UserConverter;
import com.challenge.demo.dto.UserDTO;
import com.challenge.demo.entity.SiteEntity;
import com.challenge.demo.repository.SiteRepository;
import com.challenge.demo.repository.UserRepository;
import com.challenge.demo.usecase.UserUsecase;

@Component
public class UserUsecaseImpl implements UserUsecase{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserConverter userConverter;
	
	@Autowired
	SiteRepository siteRepository;
	
	public UserDTO createUser( UserDTO createUser) {
		createUser.setUserUUID(UUID.randomUUID());
		SiteEntity se = siteRepository.findById(createUser.getSiteId()).orElseGet(null);
		return userConverter.entityToDto(userRepository.save(userConverter.dtoToEntity(createUser,se)));
	}
	
	@Override
	public List<UserDTO> getUsers() {
		return Optional
		.ofNullable(userRepository.findAll())
		.map(users -> userConverter.entityToDto(users))
		.orElseGet(() -> null);
		
		
	}

	@Override
	public UserDTO updateUser(UserDTO updatedUser, Long userId) {
		return userRepository
				.findById(userId)
				.map(user -> {
					user.setUserName(updatedUser.getUserName());
					return userConverter.entityToDto(userRepository.save(user));
				})
				.orElseGet(() ->null);
	}

	@Override
	public UserDTO deleteUser(Long userId) {
		return userRepository
				.findById(userId)
				.map(user -> {
					userRepository.delete(user);
					return userConverter.entityToDto(user);
				})
				.orElseGet(() -> null);
	}

	@Override
	public UserDTO getUserById(Long userId) {
		return userRepository
				.findById(userId)
				.map(user -> userConverter.entityToDto(user))
				.orElseGet(() -> null);
	}

}
