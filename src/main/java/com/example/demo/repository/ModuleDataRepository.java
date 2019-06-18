package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ModuleEntity;

public interface ModuleDataRepository extends JpaRepository<ModuleEntity, Integer>{

	ModuleEntity findByModuleName(String moduleName);
}
