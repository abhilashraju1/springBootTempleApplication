/**
 * 
 */
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.LoginBean;
import com.example.demo.entity.UserDataEntity;
import com.example.demo.repository.UserDataRepository;
import com.example.demo.service.UserService;


@Component
public class UserDataServiceImpl implements UserService {

	
	@Autowired
	public UserDataRepository userDataRepository;

	@Override
	public void saveUser(String username, String password) {
		
		UserDataEntity userEntity = new UserDataEntity();
		userEntity.setUserName(username);
		userEntity.setPassword(password);
		userDataRepository.save(userEntity);
		
	}
	
	@Override
	public List<UserDataEntity> getALLUserDetails() {
		
		List<UserDataEntity> entity = userDataRepository.findAll();
		return entity;
	}

	@Override
	public UserDataEntity getByUserId(Integer id) {
		UserDataEntity entity = userDataRepository.findByUserId(id);
		return entity;
	}

	@Override
	public void updateUserDetails(UserDataEntity updateDetails) {
		userDataRepository.save(updateDetails);
		
	}

	/*@Override
	public UserDataEntity validateLoginUser(LoginBean loginBean) {
		UserDataEntity user =  userDataRepository.validateLoginUser(loginBean.getUserName(),loginBean.getPassword());
		return user;
	}
	*/
}
