package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.LoginBean;
import com.example.demo.entity.UserDataEntity;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
    public UserService userService;
	/*
	@RequestMapping(value = "/saveUsers/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<UserDataEntity> updateUserDetails(@PathVariable("username") String username, @PathVariable("password") String password) {
		UserDataEntity updateDetails  = userService.validateLoginUser(username, password);
		return new ResponseEntity<UserDataEntity>(updateDetails, HttpStatus.OK);
	}*/
	
		/*@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/saveUsers", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
		public void saveUserDetails(@RequestBody Map<String, String> userDetails, HttpServletRequest request) {
			
			String username = userDetails.get("username");
			String password = userDetails.get("password");
			System.out.println("UserName" +username);
			System.out.println("Password" +password);
			
			userService.saveUser(username, password);
	
		}*/
		
		/*@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/saveUsers", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
		public void saveUserDetails(@RequestBody LoginBean loginBean, HttpServletRequest request) {
			
			System.out.println("UserName" +loginBean.getUserName());
			System.out.println("Password" +loginBean.getPassword());
			
			userService.validateLoginUser(loginBean);
	
		}
		*/
		@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<UserDataEntity> getUserDetails(HttpServletRequest request) {

			List<UserDataEntity> userdetails  = userService.getALLUserDetails();
			return userdetails;
			
	 
		}
		
		@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/updateUsers/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
		public UserDataEntity updateUserDetails(@PathVariable Integer id,  HttpServletRequest request,@RequestBody Map<String, String> userDetails) {
			UserDataEntity updateDetails  = userService.getByUserId(id);
			
			String username = userDetails.get("username");
			String password = userDetails.get("password");
			
			updateDetails.setUserName(username);
			updateDetails.setPassword(password);
			userService.updateUserDetails(updateDetails);
			
			return updateDetails;
		}
	
}
