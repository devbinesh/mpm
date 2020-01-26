package com.mypayrollmaster.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import com.mypayrollmaster.dto.UserDto;
import com.mypayrollmaster.model.AccountUser;
import com.mypayrollmaster.repository.UserRepository;
import com.mypayrollmaster.security.AccountUserDetails;

@Service
public class UserService {
    private static final Logger LOG = LoggerFactory
            .getLogger(UserService.class);

	 @Autowired
	 private UserRepository userRepository;

	 @Autowired
	 @Lazy
	 TokenStore tokenStore;
	 public AccountUser findByUsernameAndTenantname(String username, String tenant) {
	    	
		 
    	 LOG.info("Found user with username:" + username
         + " from tenant:" + tenant);
    	  
     AccountUser user =  userRepository.findByUsernameAndTenant(username,tenant);
     System.out.println("HI "+user.getUsername());
    //    LOG.info("Found user with username:" + user.getUsername()
     //           + " from tenant:" + user.getTenant());
        return user;
    }
	 
	 public UserDto getLoginUser() {
		    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    AccountUserDetails aud = (AccountUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
		/*
		 * String token = ((OAuth2AuthenticationDetails)
		 * authentication.getDetails()).getTokenValue(); OAuth2AccessToken accessToken =
		 * tokenStore.readAccessToken(token); Map<String,Object> addInfo =
		 * accessToken.getAdditionalInformation(); String account =
		 * addInfo.containsKey("account")?addInfo.get("account").toString():"";
		 */
			UserDto userDto = new UserDto();
			userDto.setUsername(authentication.getName());
			userDto.setAccount(aud.getTenant());
			return userDto;
			
	 }

}
