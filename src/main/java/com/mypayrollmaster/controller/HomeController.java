package com.mypayrollmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypayrollmaster.service.UserService;

@Controller
@CrossOrigin(origins="*", maxAge=3600)
public class HomeController {
 
	@Autowired
	UserService uService;
	@RequestMapping("/test")
	public String index() {
		System.out.println("HI");
		uService.findByUsernameAndTenantname("DEMO12611", "DEMO");
		return "HI";
	}
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
