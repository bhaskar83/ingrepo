package com.ing.login.loan.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.ing.login.loan.dao.UserDao;

import java.util.ArrayList;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	 @Override
	    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
	        return new User("bhaskar", "ing",
	                new ArrayList<>());

	        
	 }
	        

	  	
}

