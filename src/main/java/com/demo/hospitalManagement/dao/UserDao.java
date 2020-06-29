package com.demo.hospitalManagement.dao;

import java.util.Optional;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.hospitalManagement.model.User;

/**
 * @author Lahari,Haritha
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {

	/**
	 * This method is used to get User by userId
	 * 
	 * @param userId
	 * @return
	 */
	public Optional<User> findByUserId(Long userId);

	/**
	 * This method is used to authenticate User
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public Optional<User> findByUserNameAndPassword(String userName, String password);
}
