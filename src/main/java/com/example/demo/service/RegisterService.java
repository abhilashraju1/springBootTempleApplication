package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.LoginBean;
import com.example.demo.bean.RegisterBean;
import com.example.demo.entity.RegisterEntity;


@Service
public interface RegisterService {

	public void saveRegisterUser(RegisterBean registerBean);
	
	RegisterEntity validateLoginUser(LoginBean loginBean);

	public List<RegisterEntity> getALLUserDetails();

	public void updateUserDetails(RegisterBean registerBean);

	public RegisterEntity getUserById(Integer id);

	public void deleteUser(RegisterEntity details);
}
