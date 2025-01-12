package com.usermicroservice.constant;

public class UrlMapping {

	
	public UrlMapping() {
		super();
	}
	
	
	public static final String BASE_URL="/microservice-v1/";
	
	
	//User
	public static final String USERS="users";
	public static final String USER_UUID=USERS+"/{userUuid}";
}
