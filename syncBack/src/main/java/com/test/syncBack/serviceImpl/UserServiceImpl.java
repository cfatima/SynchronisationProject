package com.test.syncBack.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.syncBack.model.AppUser;
import com.test.syncBack.repository.AppUserRepository;
import com.test.syncBack.service.IUserService;


@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
    private AppUserRepository appUserRepository;

	@Override
	public AppUser getUser(int id) {
		return appUserRepository.getOne(id);
	}

	@Override
	public void updateUser(int id, String name, String email) {
		
		AppUser user=AppUser.builder().id(id).name(name).email(email).build();
		
		appUserRepository.save(user);
		
	}

}
