package com.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.dto.ResponseDto;
import com.employee.management.model.LoginModel;
import com.employee.management.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("login")
	public ResponseDto login(@RequestBody LoginModel request) {
		ResponseDto response = new ResponseDto();
		response.setStatus("fail");
		response.setMessage("Invalid Credentails");
		LoginModel res = userService.login(request);
		if (res.getId() != null) {
			response.setStatus("success");
			response.setMessage("login done!");
			response.setData(res);
		}
		
		return response;

	}

}
