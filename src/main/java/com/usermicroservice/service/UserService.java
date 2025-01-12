package com.usermicroservice.service;

import com.usermicroservice.dto.UserDto;
import com.usermicroservice.model.UserModel;
import com.usermicroservice.model.UserResponse;

public interface UserService {

	// save user
	UserModel saveUser(UserDto userDto);

	// get UserList
	UserResponse getUserList(int pagesize,int pageNumber);

	// get userUsing Uuid
	UserModel getUserUsingUuid(String userUuid);

	// update User
	UserModel updateUser(String userUuid, UserDto userDto);

	// delete User
	void deleteUser(String userUuid);
}
