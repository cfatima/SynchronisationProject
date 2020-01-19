package com.test.syncBack.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.syncBack.exception.AppException;
import com.test.syncBack.model.AppUser;
import com.test.syncBack.rest.dto.UserDTO;
import com.test.syncBack.rest.dto.request.UpdateUserRequest;
import com.test.syncBack.rest.dto.response.UpdateUserResponse;
import com.test.syncBack.rest.dto.response.getUserResponse;
import com.test.syncBack.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
    private IUserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/users/{id}")
    public ResponseEntity<getUserResponse> getUser(
    		@PathVariable final int id,
    		HttpServletRequest request) throws AppException{
		
            AppUser user = userService.getUser(id);
            
            UserDTO userDTO= UserDTO.builder()
            		.id(user.getId())
            		.email(user.getEmail())
            		.name(user.getName())
            		.avatarId(user.getAvatarId())
            		.build();
          
            return new ResponseEntity<getUserResponse>(getUserResponse.builder().user(userDTO).build(), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST, value ="/users/{id}")
    public ResponseEntity<UpdateUserResponse> updateUser(
    		@PathVariable final int id,
    		@RequestBody final UpdateUserRequest body,
    		HttpServletRequest request) throws AppException{
		
            AppUser user= userService.updateUser(id, body.getName(), body.getEmail(),body.getAvatarId());
            
            UserDTO userDTO= UserDTO.builder()
            		.id(user.getId())
            		.email(user.getEmail())
            		.name(user.getName())
            		.avatarId(user.getAvatarId())
            		.build();
          
            return new ResponseEntity<UpdateUserResponse>(UpdateUserResponse.builder().user(userDTO).build(), HttpStatus.OK);
    }

}
