package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.ModuleBean;
import com.example.demo.bean.RoleCreationBean;
import com.example.demo.bean.RolesBean;
import com.example.demo.entity.ModuleEntity;
import com.example.demo.entity.RoleModuleEntity;
import com.example.demo.entity.RolesEntity;
import com.example.demo.repository.ModuleDataRepository;
import com.example.demo.repository.RoleDataRepository;
import com.example.demo.repository.RoleModuleDataRepository;
import com.example.demo.service.RoleService;

@Component
public class RoleServiceImpl implements RoleService {

	@Autowired
	public RoleDataRepository roleDataRepository;
	
	@Autowired
	public ModuleDataRepository moduleDataRepository;
	
	@Autowired
	public RoleModuleDataRepository roleModuleDataRepository;
	
	@Override
	public void saveRoleDetails(RoleCreationBean rolesCreationBean) {
		
	RolesEntity roleEntity = new RolesEntity();
	roleEntity.setRoleName(rolesCreationBean.getRoleName());
	roleEntity.setRoleDescription(rolesCreationBean.getRoleDesc());
	
	
	RolesEntity getRole = roleDataRepository.findByRoleName(rolesCreationBean.getRoleName());
	List<RoleModuleEntity> roleModuleEntity = new ArrayList<>();
	for(ModuleBean mBean : rolesCreationBean.getModuleList())
	{
		ModuleEntity getModule = moduleDataRepository.findByModuleName(mBean.getModuleName());
		if(mBean.getChecked())
		{
			RoleModuleEntity rModuleEntity = new RoleModuleEntity();
			rModuleEntity.setRolesEntity(getRole);
			rModuleEntity.setModuleEntity(getModule);
			roleModuleEntity.add(rModuleEntity);
		}
	}
	roleModuleDataRepository.saveAll(roleModuleEntity);
	}
	
	@Override
	public List<ModuleBean> getALLModuleList() {
		
		List<ModuleEntity> moduleEntity = moduleDataRepository.findAll();
		List<ModuleBean> moduleBean = new ArrayList<>();
		for(ModuleEntity m : moduleEntity )
		{
			ModuleBean mBean = new ModuleBean();
			mBean.setModuleId(m.getId());
			mBean.setModuleName(m.getModuleName());
			moduleBean.add(mBean);
		}
		return moduleBean;
	}

	@Override
	public List<RolesBean> getALLRolesList() {
		List<RolesEntity> roleEntity = roleDataRepository.findAll();
		List<RolesBean> roleBean = new ArrayList<>();
		for(RolesEntity r : roleEntity)
		{
			RolesBean rBean = new RolesBean();
			rBean.setRoleId(r.getId());
			rBean.setRoleName(r.getRoleName());
			rBean.setRoleActive(r.getRoleActive());
			rBean.setRoleDesc(r.getRoleDescription());
			rBean.setRoleStatus(r.getRoleStatus());
			roleBean.add(rBean);
		}
		return roleBean;
	}
	
	@Override
	public RoleCreationBean getCreateRolesList() {
		List<ModuleEntity> moduleEntity = moduleDataRepository.findAll();
		List<ModuleBean> modulebean = new ArrayList<>();
			RoleCreationBean rBean = new RoleCreationBean();
			for(ModuleEntity r: moduleEntity )
			{
				ModuleBean modulebean1 = new ModuleBean();
				modulebean1.setModuleName(r.getModuleName());
				modulebean1.setModuleId(r.getId());
				modulebean1.setChecked(false);
				modulebean.add(modulebean1);
			}
			rBean.setModuleList(modulebean);
			return rBean;
	}

	@Override
	public void updateRoleDetails(RolesBean rolesBean) {
		
		RolesEntity rolesEntity = new RolesEntity();
		rolesEntity.setRoleName(rolesBean.getRoleName());
		rolesEntity.setRoleDescription(rolesBean.getRoleDesc());
		
	}

	@Override
	public RolesEntity getRoleById(Integer id) {
		RolesEntity entity = roleDataRepository.getOne(id);
		return entity;
	}

}
