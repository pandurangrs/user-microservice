package com.usermicroservice.controller;

import javax.crypto.interfaces.DHPublicKey;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usermicroservice.constant.AppConstant;
import com.usermicroservice.constant.UrlMapping;
import com.usermicroservice.dto.UserDto;
import com.usermicroservice.model.UserModel;
import com.usermicroservice.model.UserResponse;
import com.usermicroservice.payload.ApiResponse;
import com.usermicroservice.service.UserService;

@RestController
@RequestMapping(UrlMapping.BASE_URL)
public class Usercontroller {

	private UserService userService;

	public Usercontroller(UserService userService) {
		this.userService = userService;
	}

	// Save User
	@PostMapping(UrlMapping.USERS)
	public ResponseEntity<UserModel> saveUser(@RequestBody UserDto userDto) {
		UserModel userModel = userService.saveUser(userDto);
		return new ResponseEntity<>(userModel, HttpStatus.CREATED);
	}

	// Get User List Using Pagination
	@GetMapping(UrlMapping.USERS)
	public ResponseEntity<UserResponse> getUserList(
			@RequestParam(defaultValue = AppConstant.USER_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstant.USER_PAGE_NUMBER, required = false) int pageNumber) {

		UserResponse userRespponse = userService.getUserList(pageSize, pageNumber);
		return new ResponseEntity<>(userRespponse, HttpStatus.OK);
	}

	// Get User Using Uuid
	@GetMapping(UrlMapping.USER_UUID)
	public ResponseEntity<UserModel> getUserUsingUuid(@PathVariable String userUuid) {
		UserModel userModel = userService.getUserUsingUuid(userUuid);
		return new ResponseEntity<>(userModel, HttpStatus.OK);
	}

	// Update User
	
	@PutMapping(UrlMapping.USER_UUID)
	public ResponseEntity<UserModel> updateUser(@PathVariable String userUuid, @RequestBody UserDto userDto) {
		UserModel userModel = this.userService.updateUser(userUuid, userDto);
		return new ResponseEntity<>(userModel, HttpStatus.OK);
	}

	// Delete User
	@DeleteMapping(UrlMapping.USER_UUID)
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userUuid) {
		this.userService.deleteUser(userUuid);
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}
}
