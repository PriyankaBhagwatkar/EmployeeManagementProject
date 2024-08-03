package com.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.employee.management.dto.ResponseDto;
import com.employee.management.model.EmployeeDetailsModel;
import com.employee.management.model.LoginModel;
import com.employee.management.service.EmployeeDetailsService;

@RestController
public class EmployeeDetailsController {
	@Autowired
	EmployeeDetailsService employeeDetailsService;
	@GetMapping("ListOfAllEmployeeDetails")
	public ResponseDto ListOfAllEmployeeDetails() {
		ResponseDto response = new ResponseDto();
		response.setStatus("fail");
		response.setMessage("Invalid Credentails");
		List<EmployeeDetailsModel> res = employeeDetailsService.getAllEmployeeDetails();
		if (res != null) {
			response.setStatus("success");
			response.setMessage("Data save!");
			response.setData(res);
		}
		return response;
			}
	
	
	@GetMapping("employeeDetail")
	public ResponseDto employeeDetailById(@RequestBody EmployeeDetailsModel request) {
		ResponseDto response = new ResponseDto();
		response.setStatus("fail");
		response.setMessage("Invalid Credentails");
		response.setData(employeeDetailsService.getEmployeeDetailsById(request.getId()));
		return response;
		
		
		
		
	}
		
	@PostMapping("saveEmployeesDetails")
	public ResponseDto saveEmployeesDetails(@RequestBody EmployeeDetailsModel request){
		ResponseDto response= new ResponseDto();
		response.setStatus("fail");
		response.setMessage("Invalid Credentails");
		EmployeeDetailsModel res = employeeDetailsService.saveData(request);
		if (res.getId() != null) {
			response.setStatus("success");
			response.setMessage("Data save!");
			response.setData(res);
		}
		return response;
			}
	@PostMapping("updateEmployeesDetails")
	public ResponseDto updateEmployeesDetails(@RequestBody EmployeeDetailsModel request){
		ResponseDto response= new ResponseDto();
		response.setStatus("fail");
		response.setMessage("Invalid Credentails");
		EmployeeDetailsModel res = employeeDetailsService.updateData(request).get();
		if (res.getId() != null) {
			response.setStatus("success");
			response.setMessage("Data save!");
			response.setData(res);
		}
		return response;
			}
	
	//Controller: Provide an endpoint to access the list of active users.
	@GetMapping("/active")
	public ResponseDto getActiveUsers(){
		ResponseDto response= new ResponseDto();
		response.setStatus("Success");
		response.setMessage("Total No Of Active User ");
		response.setData(employeeDetailsService.getActiveUsers());
		return response;
	}
	
	@GetMapping("/inactive")
	public ResponseDto getInactiveUsers(){
		ResponseDto response= new ResponseDto();
		response.setStatus("Success");
		response.setMessage("Total No Of Inactive User ");
		response.setData(employeeDetailsService.getInactiveUser());
		return response;
	}
	
	@GetMapping("/CountTotalEmployee")
	public ResponseDto getCountTotalemployee(){
		ResponseDto response= new ResponseDto();
		response.setStatus("Success");
		response.setMessage("Count of total employeee ");
		response.setData(employeeDetailsService.getCountTotalemployee());
		return response;
	}
	@GetMapping("/sumOfSalaries")
	public ResponseDto getTotalSumSalary(){
		ResponseDto response= new ResponseDto();
		response.setStatus("Success");
		response.setMessage("Count of total employeee ");
		response.setData(employeeDetailsService.getTotalSumSalary());
		return response;
	}
	
	


}
