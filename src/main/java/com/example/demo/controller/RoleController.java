package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ModuleBean;
import com.example.demo.bean.RoleCreationBean;
import com.example.demo.bean.RolesBean;
import com.example.demo.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	public RoleService roleService;
	
	@ResponseStatus(value = HttpStatus.OK)
	
	@RequestMapping(value="/saveRoleDetails",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public void saveRoleDetails(@RequestBody RoleCreationBean rolesCreationBean, HttpServletRequest request)
	{
		roleService.saveRoleDetails(rolesCreationBean);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/modules", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ModuleBean> getModuleDetails(HttpServletRequest request) {

		List<ModuleBean> details  = roleService.getALLModuleList();
		return details;
		
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RolesBean> getRoleDetails(HttpServletRequest request) {

		List<RolesBean> details  = roleService.getALLRolesList();
		return details;
		
	}
}
