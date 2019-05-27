package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.LoginBean;
import com.example.demo.bean.RegisterBean;
import com.example.demo.entity.RegisterEntity;
import com.example.demo.entity.UserDataEntity;
import com.example.demo.service.RegisterService;

@RestController
public class RegisterContoller {
	
	@Autowired
    public RegisterService registerService;
	
	
		@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/saveRegisterUsers", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
		public void saveUserDetails(@RequestBody RegisterBean registerBean, HttpServletRequest request) {
			
			System.out.println("UserName" +registerBean.getUserName());
			System.out.println("Password" +registerBean.getPassword());
			System.out.println("confirmPassword" +registerBean.getConfirmPassword());
			System.out.println("email" +registerBean.getEmail());
			
			registerService.saveRegisterUser(registerBean);
	
		}

		@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/validateUsers", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
		public ResponseEntity saveUserDetails(@RequestBody LoginBean loginBean, HttpServletRequest request) {
			
			System.out.println("UserName" +loginBean.getUserName());
			System.out.println("Password" +loginBean.getPassword());
			RegisterEntity  registerEntity = registerService.validateLoginUser(loginBean);
			if(registerEntity == null)
			{
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			return null;
		}
		
		@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/getUsersList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<RegisterEntity> getUserDetails(HttpServletRequest request) {

			List<RegisterEntity> userdetails  = registerService.getALLUserDetails();
			return userdetails;
			
	 
		}
		
}
