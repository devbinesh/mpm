package com.mypayrollmaster.security;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mypayrollmaster.model.AccountUser;

import com.mypayrollmaster.service.UserService;
import com.mypayrollmaster.utils.AuthUtils;

@Service
public class AccountUserDetailService implements UserDetailsService {

	@Autowired
	UserService uService;
	
	@Autowired
	AuthUtils auth;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		String account  = auth.getAccountFromUsername(username);
		AccountUser accountUser = uService.findByUsernameAndTenantname(username, account);
		 if (accountUser == null) {
	            throw new UsernameNotFoundException(
	                    String.format(
	                            "Username not found for domain, "
	                                    + "username=%s, tenant=%s",
	                            username, account));
	        }
	        AccountUserDetails aud = new AccountUserDetails();
	        
	        BeanUtils.copyProperties(accountUser, aud);
		return aud;
	}
	 
	public UserDetails loadUserByUsername(String username,String account) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
	 
		AccountUser accountUser = uService.findByUsernameAndTenantname(username, account);
		 if (accountUser == null) {
	            throw new UsernameNotFoundException(
	                    String.format(
	                            "Username not found for domain, "
	                                    + "username=%s, tenant=%s",
	                            username, account));
	        }
	        AccountUserDetails aud = new AccountUserDetails();
	        
	        BeanUtils.copyProperties(accountUser, aud);
		return aud;
	}
}
