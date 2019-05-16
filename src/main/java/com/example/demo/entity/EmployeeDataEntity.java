/**
 * 
 */
package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * @author Dheeraj.Kumar
 *
 */
@Entity
@Table(name="EMPLOYEE")
public class EmployeeDataEntity implements Serializable{
	
	private static final long serialVersionUID = 6166096818461545091L;

	@Id
	@Column(name="EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name="TEAM")
	private String team;
	
	@Column(name="DATE")
	private String date;
	
	@Column(name="ADDRESS")
	private String address;

	
	
	
	public EmployeeDataEntity() {
	
	}

	public EmployeeDataEntity(Integer id, String employeeName, String team, String date, String address) {
		this.id = id;
		this.employeeName = employeeName;
		this.team = team;
		this.date = date;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setADDRESS(String address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
