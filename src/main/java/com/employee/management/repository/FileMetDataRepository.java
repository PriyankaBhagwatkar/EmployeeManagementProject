package com.employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.model.FileMetData;

@Repository
public interface FileMetDataRepository extends JpaRepository<FileMetData, Long> {

}
