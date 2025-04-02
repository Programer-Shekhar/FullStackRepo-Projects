package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nit.entity.User;
import com.nit.repository.IUserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserMgmtServiceImpl implements IUserMgmtService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		String password =  passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		user.setRole("ROLE_USER");
		User newUser = userRepository.save(user);
		
		return newUser;
	}

	@Override
	public void removeSessionMessage() {
		HttpSession session = 	((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("msg");
	}
	
	
	
}
