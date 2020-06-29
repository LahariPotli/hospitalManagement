package com.demo.hospitalManagement.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.hospitalManagement.dao.UserDao;
import com.demo.hospitalManagement.dto.LoginDto;
import com.demo.hospitalManagement.dto.UserDto;
import com.demo.hospitalManagement.model.User;
import com.demo.hospitalManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addUser(@RequestBody UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		userDao.save(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean authenticateUser(LoginDto loginDto) {
		Optional<User> user = userDao.findByUserNameAndPassword(loginDto.getUserName(), loginDto.getPassword());
		if (user.isPresent())
			return true;
		else {
			return false;
		}

	}

}