package com.example.demo.bean;

import java.util.List;

public class RoleCreationBean {
	
	private String roleName;
	private String roleDesc;
	private List<ModuleBean> moduleList;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public List<ModuleBean> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<ModuleBean> moduleList) {
		this.moduleList = moduleList;
	}
	
}
