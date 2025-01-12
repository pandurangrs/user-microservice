package com.usermicroservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

	private String uuid;

	private String name;

	private String email;

	private String about;
}
