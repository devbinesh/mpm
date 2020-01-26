package com.mypayrollmaster.sso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import com.mypayrollmaster.utils.AuthUtils;

 


public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("rootDatasource")
	private DataSource dataSource;

	@Value("${security.jwt.key-store}")
	Resource keyStore;
	
	@Value("${security.jwt.key-store-password}")
	String keyStorePassword;
	
	@Value("${security.jwt.key-pair-alias}")
	String keyPairAlias;
	
	@Value("${security.jwt.key-pair-password}")
	String keyPairPassword;
	
    
   
    @Autowired
    private UserApprovalHandler userApprovalHandler;

    @Autowired
    private AuthenticationManager authenticationManager;

    
    JwtAccessTokenConverter jwtAccessTokenConverter;

	TokenEnhancerChain tokenEnhancer;
	
	@Autowired
	AuthUtils authUtil;
	
    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    
        
    	endpoints.authenticationManager(authenticationManager) 
   //     .userApprovalHandler(userApprovalHandler)
		.tokenEnhancer(tokenEnhancerChain())
		 .accessTokenConverter(jwtAccessTokenConverter())
				.tokenStore(tokenStore()).reuseRefreshTokens(false);
    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
    	
        clients.inMemory()
                .withClient("SampleClientId")
                .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("secret"))
                .authorizedGrantTypes("authorization_code", "password", "client_credentials")
                .scopes("user_info", "read", "write")
                .accessTokenValiditySeconds(3600)
                .autoApprove(true)
                //.redirectUris("http://localhost:8082/client/login/oauth2/code/custom")
        ;
    }

    @Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter()); //new JdbcTokenStore(dataSource);
	}
    @Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		
		if(jwtAccessTokenConverter != null) {
			return jwtAccessTokenConverter;
		}
		
		KeyStoreKeyFactory keyStoreKeyFactory = keyStoreKeyFactory();
		
		jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setKeyPair(keyStoreKeyFactory.getKeyPair(keyPairAlias, keyPairPassword.toCharArray()));
		return jwtAccessTokenConverter;
	}
	 
	public KeyStoreKeyFactory keyStoreKeyFactory() {
		KeyStoreKeyFactory keyFactory = new KeyStoreKeyFactory(keyStore, keyStorePassword.toCharArray());
	 
		return keyFactory;
	}
	 @Bean
	 public DefaultTokenServices tokenServices(final TokenStore tokenStore,
	                                              final ClientDetailsService clientDetailsService) {
	        DefaultTokenServices tokenServices = new DefaultTokenServices();
	        tokenServices.setSupportRefreshToken(true);
	        tokenServices.setTokenStore(tokenStore);
	        tokenServices.setTokenEnhancer(tokenEnhancerChain());
	        tokenServices.setClientDetailsService(clientDetailsService);
	        tokenServices.setAuthenticationManager(this.authenticationManager);
	      
	        return tokenServices;
	    }
	 @Bean
     public TokenEnhancerChain tokenEnhancerChain(){
		 if(tokenEnhancer == null) {
			 tokenEnhancer  = new TokenEnhancerChain();
         
         List<TokenEnhancer> delegates = new ArrayList<TokenEnhancer>();
         delegates.add(new CustomTokenEnhancer());
         delegates.add(jwtAccessTokenConverter());
       //  ArrayList<>
         tokenEnhancer.setTokenEnhancers(delegates);
         }
         return tokenEnhancer;
     }
	
	 
	 public class CustomTokenEnhancer implements TokenEnhancer{

		@Override
		public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
			// TODO Auto-generated method stub
			
		Map<String,String>	params =  authentication.getOAuth2Request().getRequestParameters();
		String usergrp = params.get("usergroup");
		String username = params.get("username");
		
		
		HashMap<String, Object> addInfo = new HashMap<>();
		addInfo.put("usergroup",usergrp );
		addInfo.put("account",authUtil.getAccountFromUsername(username) );
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(
		          addInfo);
		
		return accessToken;
	
		}
		 
	 }
}
