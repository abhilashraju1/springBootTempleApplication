/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.EmployeeBean;
import com.example.demo.entity.EmployeeDataEntity;



/**
 * @author Dheeraj.Kumar
 *
 */
@Service
public interface EmployeeService {

	public List<EmployeeDataEntity> getALLEmployeeData();

	public EmployeeDataEntity getByEmployeeId(Integer id);

	public void saveEmployeeDetails(EmployeeBean employeeBean);
	
	public void updateEmployeeDetails(EmployeeBean employeeBean);
	
	public void deleteEmployee(EmployeeDataEntity details);
}
