package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.ModuleBean;
import com.example.demo.bean.RoleCreationBean;
import com.example.demo.bean.RolesBean;
import com.example.demo.entity.ModuleEntity;

@Service
public interface RoleService {

	public void saveRoleDetails(RoleCreationBean rolesCreationBean);

	public List<ModuleBean> getALLModuleList();
	
	public List<RolesBean> getALLRolesList();

}
