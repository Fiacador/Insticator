package com.challenge.demo.usecase;

import java.util.List;

import com.challenge.demo.dto.UserDTO;

public interface UserUsecase {

	UserDTO createUser(UserDTO createUser);

	List<UserDTO> getUsers();

	UserDTO updateUser(UserDTO updatedUser, Long userId);

	UserDTO deleteUser(Long userId);

	UserDTO getUserById(Long userId);

}
