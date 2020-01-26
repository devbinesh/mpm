package com.mypayrollmaster.dto;

import lombok.Data;

@Data
public class AppConfig {

	private String appName;
	private String appTheme;
	private String lang;
	private String dateFormat;
	private String username;
	private String apiAccessToken;
	private UserDto loginUser;
	private String account;
	
}
