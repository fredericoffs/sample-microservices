package com.fredericoffs.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fredericoffs.hroauth.entities.User;
import com.fredericoffs.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient feignClient;

//	// Buscar no microserviço de user
	public User findByEmail(String email) {
		User user = feignClient.findByEmail(email).getBody();
		if (user == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found!");
		}
		logger.info("Email found: " + email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = feignClient.findByEmail(username).getBody();
		if (user == null) {
			logger.error("Email not found: " + username);
			throw new UsernameNotFoundException("Email not found!");
		}
		logger.info("Email found: " + username);
		return user;
	}

}
