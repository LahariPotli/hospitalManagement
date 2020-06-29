package com.demo.hospitalManagement.service;

import com.demo.hospitalManagement.dto.LoginDto;
import com.demo.hospitalManagement.dto.UserDto;

/**
 * @author Lahari,Haritha
 *
 */
public interface UserService {

	/**
	 * 
	 * This method is used to register User
	 * @param userDto
	 */
	public void addUser(UserDto userDto);

	/**
	 * This method is used to authenticate User
	 * 
	 * @param loginDto
	 * @return boolean true if an authenticated User else false
	 */
	public boolean authenticateUser(LoginDto loginDto);
}
