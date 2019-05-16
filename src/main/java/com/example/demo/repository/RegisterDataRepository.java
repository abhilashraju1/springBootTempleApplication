package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.RegisterEntity;



public interface RegisterDataRepository extends JpaRepository<RegisterEntity, Integer> {
	
	@Query(value = "select user from RegisterEntity user where user.userName =?1 and user.password =?2")
	RegisterEntity validateLoginUser(String userName,String password);

}
