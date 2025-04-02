package com.nit.service;

import com.nit.entity.User;

public interface IUserMgmtService {

	public User saveUser(User user);
	
	public void removeSessionMessage();
}
