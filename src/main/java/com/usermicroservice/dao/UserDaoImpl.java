package com.usermicroservice.dao;

import org.hibernate.ResourceClosedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.usermicroservice.entity.User;
import com.usermicroservice.exception.ResourceNotFoundException;
import com.usermicroservice.repo.UserRepo;

@Repository
public class UserDaoImpl implements UserDao {

	private UserRepo userRepo;

	public UserDaoImpl(UserRepo userRepo) {

		this.userRepo = userRepo;
	}

	// save User
	@Override
	public User saveUser(User user) {

		return userRepo.save(user);
	}

	// get UserList Using Pagination
	@Override
	public Page<User> getUserList(int pageSize, int pageNumber) {

		return userRepo.findByIsActiveTrue(PageRequest.of(--pageNumber, pageSize));
	}

	// get User using Uuid
	@Override
	public User getUserUsingUuid(String userUuid) {
		return userRepo.findByUuid(userUuid).orElseThrow(() -> new ResourceNotFoundException());
	}

	
	//delete user using uuid
	@Override
	public void deleteUser(User user) {
		try {
			userRepo.delete(user);
		} catch (Exception e) {
			throw new ResourceNotFoundException("An error occuring while attempting to delete the data. ",
					HttpStatus.NOT_FOUND);
		}

	}

}
