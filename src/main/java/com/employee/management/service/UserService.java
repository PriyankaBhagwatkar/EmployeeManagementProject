package com.employee.management.service;

import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.employee.management.dto.ResponseDto;
import com.employee.management.model.LoginModel;
import com.employee.management.repository.LoginRepo;

@Service
public class UserService {
 @Autowired
 LoginRepo loginRepo;
 
	public LoginModel login(LoginModel request) {
		if(request.getUsername() != null && request.getPassword() !=null) {
			LoginModel loginModelDB =loginRepo.getUserDataWithPassword(request.getUsername(), request.getPassword());
			if (loginModelDB != null) {
				
				if(request.getUsername().equals(loginModelDB.getUsername()) && request.getPassword().equals(loginModelDB.getPassword())) {
					loginModelDB.setOtp(generateOTP1(6));
					return loginModelDB;
				}
				
			} else {
				return new LoginModel();
			}
		}
		return new LoginModel();
		
		
	}

		// Method to generate a random OTP of given length// Method to generate a random OTP of given length
	    public String generateOTP1(int length) {
	        // Define characters that can be used in OTP (here using numbers 0-9)
	        String numbers = "0123456789";

	        // Using Java 8 Stream to generate OTP of specified length
	        String otp = new Random().ints(length, 0, numbers.length())
	                                .mapToObj(numbers::charAt)
	                                .map(Object::toString)
	                                .collect(Collectors.joining());

	        return otp;
	      

	    }
	}

