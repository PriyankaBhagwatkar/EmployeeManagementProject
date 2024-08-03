package com.employee.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.management.model.EmployeeDetailsModel;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetailsModel, Integer> {
	 @Query(name = "EmployeeDetailsModel.findAllEmployeeWithImage", nativeQuery = true)
	    List<EmployeeDetailsModel> findAllEmployeeWithImage();
	 
	 @Query("select count(e) FROM EmployeeDetailsModel e WHERE e.status='Active'")
	 int findActiveUsers();
	 
	 @Query("select count(e) FROM EmployeeDetailsModel e WHERE e.status='Inactive'")
	 int findInactiveUsers();
	 
	 
	 @Query(value=" select Count(*) From employee_details",nativeQuery=true)
	 Long countTotalEmployees();
	 
	 @Query(value=" select Sum(salary) From employee_details", nativeQuery=true)
	 String sumTotalSalaries();
	 

}
