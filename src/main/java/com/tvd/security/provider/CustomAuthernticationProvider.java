package com.tvd.security.provider;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;

import com.tvd.security.dao.SecDaoImp;

@Controller
public class CustomAuthernticationProvider implements AuthenticationProvider {

	@Autowired
	private SecDaoImp dao;
	
	final Logger log = Logger.getLogger(CustomAuthernticationProvider.class);
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username=authentication.getName();
		String password=authentication.getCredentials().toString();
		
		System.err.println(username+"---"+password);
		
		List<GrantedAuthority> list=new ArrayList<>();
		Integer userid=0;
		try {
			userid=dao.getUserId(username,password);
			
			if(userid>0){
				list.add(new SimpleGrantedAuthority("ROLE_USER"));
				Authentication auth=new UsernamePasswordAuthenticationToken(username,password,list);
				return auth;
			}
			
			else{
				return null;
			}
		} catch (Exception e) {
			throw new BadCredentialsException("Invalid Username");
		}
		
		
	}

	@Override
	public boolean supports(Class<?> cust) {
		return cust.equals(UsernamePasswordAuthenticationToken.class);
	}

}
