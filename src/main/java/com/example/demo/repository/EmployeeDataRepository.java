/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.EmployeeDataEntity;

/**
 * @author Dheeraj.Kumar
 *
 */

public interface EmployeeDataRepository extends JpaRepository<EmployeeDataEntity, Integer>{


	
}
