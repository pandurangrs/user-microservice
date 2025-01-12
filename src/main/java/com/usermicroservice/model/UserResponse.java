package com.usermicroservice.model;

import java.util.List;

import com.usermicroservice.payload.PaginationResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends PaginationResponse{

	private List<UserModel> userModels;
	
}
