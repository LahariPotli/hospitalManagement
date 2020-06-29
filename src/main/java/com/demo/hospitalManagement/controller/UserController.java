package com.demo.hospitalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hospitalManagement.dto.LoginDto;
import com.demo.hospitalManagement.dto.UserDto;
import com.demo.hospitalManagement.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String registerUser(@RequestBody UserDto userDto) {
		userService.addUser(userDto);
		return "user added successfully";
	}

	@PostMapping("/users/login")
	public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
		if (userService.authenticateUser(loginDto))
			return new ResponseEntity<String>("logged in successfully", HttpStatus.OK);
		else {
			return new ResponseEntity<String>("Incorrect credentials", HttpStatus.UNAUTHORIZED);
		}
	}
}