package com.test.syncBack.service;


import com.test.syncBack.model.AppUser;


public interface IUserService {
	
	public AppUser getUser(int id);
	
	public AppUser updateUser(int id, String name, String email, String avatarId);
	
	

}
