package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE_MODULE")
public class RoleModuleEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ROLE_MODULE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ENABLED")
	private String roleEnabled;
	
	@Column(name="DISPLAY_NAME")
	private String displayName;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ROLE_ID",updatable=false,nullable = false)
	private RolesEntity rolesEntity;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MODULE_ID",updatable=false,nullable = false)
	private ModuleEntity moduleEntity;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleEnabled() {
		return roleEnabled;
	}

	public void setRoleEnabled(String roleEnabled) {
		this.roleEnabled = roleEnabled;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ModuleEntity getModuleEntity() {
		return moduleEntity;
	}

	public void setModuleEntity(ModuleEntity moduleEntity) {
		this.moduleEntity = moduleEntity;
	}
	
	public RolesEntity getRolesEntity() {
		return rolesEntity;
	}

	public void setRolesEntity(RolesEntity rolesEntity) {
		this.rolesEntity = rolesEntity;
	}
}
