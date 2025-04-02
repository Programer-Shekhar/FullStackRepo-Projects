package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String emaill);
}
