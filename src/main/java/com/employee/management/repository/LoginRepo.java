package com.employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.management.model.LoginModel;
@Repository
public interface LoginRepo extends JpaRepository<LoginModel, Long>{
	@Query(value="SELECT * FROM login where username = ?1 AND password=?2",nativeQuery = true)
	LoginModel getUserDataWithPassword(String username,String password);

	

	

}
