package com.challenge.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.demo.dto.UserDTO;
import com.challenge.demo.usecase.UserUsecase;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserUsecase userUsecase;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public  ResponseEntity<UserDTO>  createUser(@RequestBody UserDTO createUser) {
		return new ResponseEntity<>(userUsecase.createUser(createUser), HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<UserDTO>> getUsers() {
		return new ResponseEntity<>(userUsecase.getUsers(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO updatedUser, @PathVariable(value = "id") Long userId) {
		return new ResponseEntity<>(userUsecase.updateUser(updatedUser, userId), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable(value = "id") Long userId) {
		return new ResponseEntity<>(userUsecase.deleteUser(userId), HttpStatus.OK); 
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long userId) {
		return new ResponseEntity<>(userUsecase.getUserById(userId), HttpStatus.OK); 
	}

}
