package com.usermicroservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private String uuid;

	private String name;

	private String email;

	private String about;
	
	private boolean isActive=true;
}
