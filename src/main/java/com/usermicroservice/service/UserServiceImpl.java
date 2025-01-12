package com.usermicroservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.usermicroservice.dao.UserDao;
import com.usermicroservice.dto.UserDto;
import com.usermicroservice.entity.User;
import com.usermicroservice.mapper.Mapper;
import com.usermicroservice.model.UserModel;
import com.usermicroservice.model.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	private Mapper mapper;

	private UserDao userDao;

	public UserServiceImpl(Mapper mapper, UserDao userDao) {
		this.mapper = mapper;
		this.userDao = userDao;
	}

	// Save User
	@Override
	public UserModel saveUser(UserDto userDto) {

		User user = mapper.convert(userDto, User.class);
		user.setUuid(UUID.randomUUID().toString());
		user.setActive(true);
		return mapper.convert(userDao.saveUser(user), UserModel.class);
	}

	@Override
	public UserResponse getUserList(int pagesize, int pageNumber) {

		UserResponse userResponse = new UserResponse();
		Page<User> pagePost = userDao.getUserList(pagesize, pageNumber);

		List<User> users = pagePost.getContent();

		List<UserModel> usermodels = mapper.convertToList(users, UserModel.class);

		userResponse.setUserModels(usermodels);
		buildPaginationResponse(userResponse, pagePost);

		return userResponse;
	}

	private void buildPaginationResponse(UserResponse userResponse, Page<User> pagePost) {
		userResponse.setLastPage(pagePost.isLast());
		userResponse.setPageNumber(pagePost.getNumber());
		userResponse.setPageSize(pagePost.getSize());
		userResponse.setTotalElements(pagePost.getTotalElements());
		userResponse.setTotalPages(pagePost.getTotalPages());

	}

	@Override
	public UserModel getUserUsingUuid(String userUuid) {
		return mapper.convert(userDao.getUserUsingUuid(userUuid), UserModel.class);
	}

	@Override
	public UserModel updateUser(String userUuid, UserDto userDto) {

		User user = userDao.getUserUsingUuid(userUuid);
		user.setAbout(userDto.getAbout());
		user.setActive(userDto.isActive());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		return mapper.convert(userDao.saveUser(user), UserModel.class);
	}

	@Override
	public void deleteUser(String userUuid) {

		User user = userDao.getUserUsingUuid(userUuid);
		userDao.deleteUser(user);

	}

}
