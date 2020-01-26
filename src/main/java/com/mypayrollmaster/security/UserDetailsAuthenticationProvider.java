package com.mypayrollmaster.security;

import org.springframework.security.core.AuthenticationException;

import java.util.LinkedHashMap;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import com.mypayrollmaster.utils.TenantContextHolder;
 

public class UserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	 private static final String USER_NOT_FOUND_PASSWORD = "userNotFoundPassword";

	    /**
	     * For encoding and/or matching the encrypted password stored in the
	     * database with the user submitted password
	     */
	    private PasswordEncoder passwordEncoder;

	    private AccountUserDetailService userDetailsService;

	    /**
	     * The password used to perform
	     * {@link PasswordEncoder#matches(CharSequence, String)} on when the user is
	     * not found to avoid SEC-2056. This is necessary, because some
	     * {@link PasswordEncoder} implementations will short circuit if the
	     * password is not in a valid format.
	     */
	    private String userNotFoundEncodedPassword;

	    public UserDetailsAuthenticationProvider(
	            PasswordEncoder passwordEncoder,
	            AccountUserDetailService userDetailsService) {
	        this.passwordEncoder = passwordEncoder;
	        this.userDetailsService = userDetailsService;
	    }

	    /*
	     * (non-Javadoc)
	     * 
	     * @see org.springframework.security.authentication.dao.
	     * AbstractUserDetailsAuthenticationProvider#additionalAuthenticationChecks(
	     * org. springframework.security.core.userdetails.UserDetails,
	     * org.springframework.security.authentication.
	     * UsernamePasswordAuthenticationToken)
	     */
	    @Override
	    protected void additionalAuthenticationChecks(UserDetails userDetails,
	            UsernamePasswordAuthenticationToken authentication)
	            throws AuthenticationException {

	        if (authentication.getCredentials() == null) {
	            logger.debug("Authentication failed: no credentials provided");
	            throw new BadCredentialsException(messages.getMessage(
	                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
	                    "Bad credentials"));
	        }
	        // Get the password submitted by the end user
	        String presentedPassword = authentication.getCredentials().toString();

	        // If the password stored in the database and the user submitted
	        // password do not match, then signal a login error
	        if (!passwordEncoder.matches(presentedPassword,
	                userDetails.getPassword())) {
	            logger.debug(
	                    "Authentication failed: password does not match stored value");
	            throw new BadCredentialsException(messages.getMessage(
	                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
	                    "Bad credentials"));
	        }
	    }

	    @Override
	    protected void doAfterPropertiesSet() throws Exception {
	        Assert.notNull(this.userDetailsService,
	                "A UserDetailsService must be set");
	        this.userNotFoundEncodedPassword = this.passwordEncoder
	                .encode(USER_NOT_FOUND_PASSWORD);
	    }

	    /*
	     * (non-Javadoc)
	     * 
	     * @see org.springframework.security.authentication.dao.
	     * AbstractUserDetailsAuthenticationProvider#retrieveUser(java.lang.String,
	     * org.springframework.security.authentication.
	     * UsernamePasswordAuthenticationToken)
	     */
	    
	    protected final UserDetails retrieveUser(String username,
				UsernamePasswordAuthenticationToken authentication)
				throws AuthenticationException {
		//	prepareTimingAttackProtection();
			try {
				 String tenant = RegExUtils.replaceAll(username, "/[^a-zA-Z]+/", "");
	    		 TenantContextHolder.setTenantId(StringUtils.left(tenant, 4));
	    		String account = StringUtils.left(tenant, 4);
				UserDetails loadedUser = this.userDetailsService.loadUserByUsername(username,account);
				if (loadedUser == null) {
					throw new InternalAuthenticationServiceException(
							"UserDetailsService returned null, which is an interface contract violation");
				}
				return loadedUser;
			}
			catch (UsernameNotFoundException ex) {
				//mitigateAgainstTimingAttack(authentication);
				throw ex;
			}
			catch (InternalAuthenticationServiceException ex) {
				throw ex;
			}
			catch (Exception ex) {
				throw new InternalAuthenticationServiceException(ex.getMessage(), ex);
			}
		}
	    
}
