package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.LoginBean;
import com.example.demo.entity.UserDataEntity;



@Service
public interface UserService {

	public void saveUser(String username, String password);
	
	List<UserDataEntity> getALLUserDetails();
	
	public UserDataEntity getByUserId(Integer id);
	
/*	UserDataEntity validateLoginUser(LoginBean loginBean);*/

	public void updateUserDetails(UserDataEntity updateDetails);
}
