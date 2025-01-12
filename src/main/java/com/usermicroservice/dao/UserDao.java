package com.usermicroservice.dao;

import org.springframework.data.domain.Page;

import com.usermicroservice.entity.User;

public interface UserDao {

	
	//save User
	User saveUser(User user);
	
	//get UserList using pagination
	Page<User> getUserList(int pageSize,int pageNumber);
	
	//get user using uuid
	User getUserUsingUuid(String userUuid);
	
	//delete user using uuid
	void deleteUser(User user);
}
