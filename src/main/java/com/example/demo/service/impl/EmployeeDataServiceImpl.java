/**
 * 
 */
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.EmployeeBean;
import com.example.demo.entity.EmployeeDataEntity;
import com.example.demo.repository.EmployeeDataRepository;
import com.example.demo.service.EmployeeService;



/**
 * @author Dheeraj.Kumar
 *
 */
@Component
public class EmployeeDataServiceImpl implements EmployeeService {

	
	@Autowired
	public EmployeeDataRepository employeeDataRepository;
	
	@Override
	public List<EmployeeDataEntity> getALLEmployeeData() {
		
		List<EmployeeDataEntity> entity = employeeDataRepository.findAll();
		return entity;
	}

	@Override
	public EmployeeDataEntity getByEmployeeId(Integer id) {
		//Optional<EmployeeDataEntity> entity = employeeDataRepository.findById(id);
		EmployeeDataEntity entity = employeeDataRepository.getOne(id);
		return entity;
	}

	@Override
	public void saveEmployeeDetails(EmployeeBean employeeBean) {
		EmployeeDataEntity employeeDataEntity = new EmployeeDataEntity();
		employeeDataEntity.setEmployeeName(employeeBean.getEmployeeName());
		employeeDataEntity.setADDRESS(employeeBean.getAddress());
		employeeDataEntity.setTeam(employeeBean.getTeam());
		employeeDataEntity.setDate(employeeBean.getDate());
		employeeDataRepository.save(employeeDataEntity);
		
	}
	
	@Override
	public void updateEmployeeDetails(EmployeeBean employeeBean) {
		EmployeeDataEntity employeeDataEntity = new EmployeeDataEntity();
		employeeDataEntity.setId(employeeBean.getId());
		employeeDataEntity.setEmployeeName(employeeBean.getEmployeeName());
		employeeDataEntity.setADDRESS(employeeBean.getAddress());
		employeeDataEntity.setTeam(employeeBean.getTeam());
		employeeDataEntity.setDate(employeeBean.getDate());
		employeeDataRepository.save(employeeDataEntity);
		
	}

	@Override
	public void deleteEmployee(EmployeeDataEntity details) {
		employeeDataRepository.delete(details);
		
	}
	
}
