package com.nit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.nit.entity.User;
import com.nit.repository.IUserRepository;

@Component
public class CustomeUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;

    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found...");
		}else {
			return new CustomeUser(user);
		}
	}
}

