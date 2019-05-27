package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.LoginBean;
import com.example.demo.bean.RegisterBean;
import com.example.demo.entity.RegisterEntity;
import com.example.demo.entity.UserDataEntity;
import com.example.demo.repository.RegisterDataRepository;
import com.example.demo.service.RegisterService;

@Component
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	public RegisterDataRepository registerDataRepository;

	@Override
	public void saveRegisterUser(RegisterBean registerBean) {
		RegisterEntity registerEntity = new RegisterEntity();
		registerEntity.setUserName(registerBean.getUserName());
		registerEntity.setPassword(registerBean.getPassword());
		registerEntity.setConfirmPassword(registerBean.getConfirmPassword());
		registerEntity.setEmail(registerBean.getEmail());
		registerEntity.setPhoneNumber(registerBean.getPhoneNumber());
		registerDataRepository.save(registerEntity);
		
	}


	@Override
	public RegisterEntity validateLoginUser(LoginBean loginBean) {
		RegisterEntity user =  registerDataRepository.validateLoginUser(loginBean.getUserName(),loginBean.getPassword());
		return user;
	}

	@Override
	public List<RegisterEntity> getALLUserDetails() {
		List<RegisterEntity> entity = registerDataRepository.findAll();
		return entity;
	}
}
