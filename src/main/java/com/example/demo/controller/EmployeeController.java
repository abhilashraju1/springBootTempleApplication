package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.EmployeeBean;
import com.example.demo.entity.EmployeeDataEntity;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
    public EmployeeService employeeService;
	
	
		@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/saveEmployeeDetails", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
		public void saveEmployeeDetails(@RequestBody EmployeeBean employeeBean, HttpServletRequest request) {
			
			System.out.println("EmployeeName" +employeeBean.getEmployeeName());
			System.out.println("Address" +employeeBean.getAddress());
			System.out.println("Team" +employeeBean.getTeam());
			System.out.println("Date" +employeeBean.getDate());
			
			employeeService.saveEmployeeDetails(employeeBean);
	
		}
		
		@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/updateEmployeeDetails", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
		public void updateEmployeeDetails(@RequestBody EmployeeBean employeeBean, HttpServletRequest request) {
			
			System.out.println("EmployeeName" +employeeBean.getEmployeeName());
			System.out.println("Address" +employeeBean.getAddress());
			System.out.println("Team" +employeeBean.getTeam());
			System.out.println("Date" +employeeBean.getDate());
			
			employeeService.updateEmployeeDetails(employeeBean);
	
		}
		
		@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/getAllDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<EmployeeDataEntity> getEmployeeDetails(HttpServletRequest request) {

			List<EmployeeDataEntity> details  = employeeService.getALLEmployeeData();
			return details;
			
		}
		
		@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/getEmployeeDetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public EmployeeBean getEmployeeDetailsById(@PathVariable Integer id,HttpServletRequest request) {

			EmployeeDataEntity details  = employeeService.getByEmployeeId(id);
			EmployeeBean bean = new EmployeeBean();
			bean.setId(details.getId());
			bean.setEmployeeName(details.getEmployeeName());
			bean.setTeam(details.getTeam());
			bean.setDate(details.getDate());
			bean.setAddress(details.getAddress());
			return bean;
	 
		}
		
		@ResponseStatus(value = HttpStatus.OK)
		@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
		public void deleteEmployee(@PathVariable Integer id,HttpServletRequest request) {
			EmployeeDataEntity details  = employeeService.getByEmployeeId(id);
			employeeService.deleteEmployee(details);
		}
	
		

}
