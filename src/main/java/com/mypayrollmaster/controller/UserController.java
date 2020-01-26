package com.mypayrollmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypayrollmaster.dto.UserDto;
import com.mypayrollmaster.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
    @RequestMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
    @RequestMapping("/user/userinfo")
    public ResponseEntity<UserDto> userinfo(Principal principal) {
    	 
        return ResponseEntity.ok(userService.getLoginUser());
    }
    @RequestMapping("/user/also-me")
    public String test(Principal user) {
        return "The principal's name is: " + user.getName();
    }
}
