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
@Table(name="TEMPLE_ROLES")
public class RolesEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROLE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ROLE_NAME", nullable = false)
	private String roleName;
	
	@Column(name="ROLE_ACTIVE")
	private String roleActive;
	
	@Column(name="ROLE_DESC ")
	private String roleDescription;
	
	@Column(name="STATUS")
	private Boolean roleStatus;


	@OneToMany(mappedBy="rolesEntity",  fetch=FetchType.LAZY)
	private Set<RoleModuleEntity> roleModuleEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleActive() {
		return roleActive;
	}

	public void setRoleActive(String roleActive) {
		this.roleActive = roleActive;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Boolean getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(Boolean roleStatus) {
		this.roleStatus = roleStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<RoleModuleEntity> getRoleModuleEntity() {
		return roleModuleEntity;
	}

	public void setRoleModuleEntity(Set<RoleModuleEntity> roleModuleEntity) {
		this.roleModuleEntity = roleModuleEntity;
	}
	
}
