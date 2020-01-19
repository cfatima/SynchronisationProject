package com.test.syncBack.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.syncBack.exception.AppException;
import com.test.syncBack.exception.AppExceptionType;
import com.test.syncBack.model.AppUser;
import com.test.syncBack.repository.AppUserRepository;
import com.test.syncBack.service.IUserService;


@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
    private AppUserRepository appUserRepository;

	@Override
	public AppUser getUser(int id) {
		
		AppUser user= appUserRepository.getOne(id);
		return user;
		
	}

	@Override
	public AppUser updateUser(int id, String name, String email, String avatarId) {
		
		AppUser user=AppUser.builder().id(id).name(name).email(email).avatarId(avatarId).build();
		
		appUserRepository.save(user);
		
		return appUserRepository.getOne(id);
		
	}

}
