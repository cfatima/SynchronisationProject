package com.test.syncBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.syncBack.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	
	

}
