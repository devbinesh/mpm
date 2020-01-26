package com.mypayrollmaster.utils;

import java.util.Map;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Component;
 
@Component
public class AuthUtils {
	 
	 
	public  String getAccountFromUsername(String username) {
		 String tenant = RegExUtils.replaceAll(username, "/[^a-zA-Z]+/", "");
		return StringUtils.left(tenant, 4);
	}
	 
	
}
