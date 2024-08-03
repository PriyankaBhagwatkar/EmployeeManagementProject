package com.employee.management.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.model.EmployeeDetailsModel;
import com.employee.management.repository.EmployeeDetailsRepo;
import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

@Service

public class EmployeeDetailsService {
	@Autowired
	EmployeeDetailsRepo employeeDetailsRepo;
	
	public List<EmployeeDetailsModel> getAllEmployeeDetails(){
		for(EmployeeDetailsModel emp:employeeDetailsRepo.findAllEmployeeWithImage()) {
			System.out.println(emp);
		}
		
		return employeeDetailsRepo.findAllEmployeeWithImage();
		
	}
	
	public EmployeeDetailsModel getEmployeeDetailsById(int id) {
		Optional<EmployeeDetailsModel> employee = employeeDetailsRepo.findById(id);
		return employee.get();
	}
	
	public EmployeeDetailsModel saveData(EmployeeDetailsModel request) {
			request.setEmpId(Long.valueOf( generateEmpId()));
			return employeeDetailsRepo.save(request);
			}
	
	
	public Optional<EmployeeDetailsModel> updateData(EmployeeDetailsModel request) {
		// Find the existing employee by ID
		return employeeDetailsRepo.findById(request.getId())
	     .map(existingEmployee ->{
			// Update fields with the request data
			existingEmployee.setFullName(request.getFullName());
			existingEmployee.setDateOfBirth(request.getDateOfBirth());
			existingEmployee.setEmail(request.getEmail());
			existingEmployee.setAddress(request.getAddress());
			existingEmployee.setContactNo(request.getContactNo());
			existingEmployee.setDesignation(request.getDesignation());
			existingEmployee.setDepartment(request.getDepartment());
			existingEmployee.setLeaveStatus(request.getLeaveStatus());
			existingEmployee.setStatus(request.getStatus());
			existingEmployee.setSalary(request.getSalary());
			existingEmployee.setDocuments(request.getDocuments());
			
			existingEmployee.setJoiningDate(request.getJoiningDate());

            // Optionally, you may want to update empId or other fields
            // Ensure not to overwrite empId if it is not meant to be changed
            // existingEmployee.setEmpId(request.getEmpId());

            // Save and return the updated employee
            return employeeDetailsRepo.save(existingEmployee);
		
	     });
	     }
	public String generateEmpId() {
        String numbers = "0123456789";

	    // Using Java 8 Stream to generate OTP of specified length
        String empId = new Random().ints(4, 0, numbers.length())
                .mapToObj(numbers::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        return empId;
}
	//Service: Call the repository method to get the list of active users.
	public int getActiveUsers()
	{
		return employeeDetailsRepo.findActiveUsers();
	}
	 public int getInactiveUser() {
		 return employeeDetailsRepo.findInactiveUsers();
	 }
	 
	 public long getCountTotalemployee() {
		 return employeeDetailsRepo.countTotalEmployees();
	 }
	 
	 public String getTotalSumSalary() {
		 return employeeDetailsRepo.sumTotalSalaries();
		 }
	

}
