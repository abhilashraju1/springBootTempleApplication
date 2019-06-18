package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MODULE")
public class ModuleEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MODULE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="MODULE_NAME")
	private String moduleName;
	
	@OneToMany(mappedBy="moduleEntity",  fetch=FetchType.LAZY)
	private Set<RoleModuleEntity> roleModuleEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Set<RoleModuleEntity> getRoleModuleEntity() {
		return roleModuleEntity;
	}

	public void setRoleModuleEntity(Set<RoleModuleEntity> roleModuleEntity) {
		this.roleModuleEntity = roleModuleEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
