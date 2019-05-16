package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.UserDataEntity;


public interface UserDataRepository extends JpaRepository<UserDataEntity, Integer>{

	@Query(value = "select im from UserDataEntity im where im.id =?1")
	UserDataEntity findByUserId(Integer id);
	
	/*@Query(value = "select user from UserDataEntity user where user.username =?1 and user.password =?2")
	UserDataEntity validateLoginUser(String userName,String password);*/
	
}
