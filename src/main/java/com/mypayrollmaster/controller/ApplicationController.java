package com.mypayrollmaster.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypayrollmaster.dto.AppConfig;
import com.mypayrollmaster.security.AccountUserDetails;
import com.mypayrollmaster.service.UserService;

@RestController
@RequestMapping("/api")
public class ApplicationController {
 
	@Autowired
	UserService uService;
	@GetMapping("/loadconfig")
	public ResponseEntity<AppConfig> loadConfig(Principal principal){
		
		AccountUserDetails aud = (AccountUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		AppConfig appConfig = new AppConfig();
		appConfig.setAppName("MPM");
		appConfig.setAppTheme("default");
		appConfig.setDateFormat("DD/MM/YYYY");
		appConfig.setUsername(principal.getName());
		appConfig.setLoginUser(uService.getLoginUser());
		return ResponseEntity.ok(appConfig);
	}
}
