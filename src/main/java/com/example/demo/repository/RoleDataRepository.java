package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RolesEntity;

public interface RoleDataRepository extends JpaRepository<RolesEntity, Integer>{
	
	RolesEntity findByRoleName(String roleName);

}
