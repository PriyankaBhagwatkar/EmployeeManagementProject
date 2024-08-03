package com.employee.management.model;

import java.io.File;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.*;

@Entity
@Table(name = "employee_details")
@SqlResultSetMapping(name = "EmployeeDetailsMapping", classes = @ConstructorResult(targetClass = EmployeeDetailsModel.class, columns = {
		@ColumnResult(name = "id", type = Integer.class), @ColumnResult(name = "emp_id", type = Long.class),
		@ColumnResult(name = "full_name", type = String.class),
		@ColumnResult(name = "date_of_birth", type = String.class), @ColumnResult(name = "email", type = String.class),
		@ColumnResult(name = "address", type = String.class), @ColumnResult(name = "contact_no", type = String.class),
		@ColumnResult(name = "designation", type = String.class),
		@ColumnResult(name = "department", type = String.class),
		@ColumnResult(name = "leave_status", type = String.class), @ColumnResult(name = "status", type = String.class),
		@ColumnResult(name = "salary", type = String.class), @ColumnResult(name = "documents", type = String.class),
		@ColumnResult(name = "joining_date", type = String.class),
		@ColumnResult(name = "fileName", type = String.class), @ColumnResult(name = "fileType", type = String.class),
		@ColumnResult(name = "fileSize", type = Long.class) }))
@NamedNativeQuery(
	    name = "EmployeeDetailsModel.findAllEmployeeWithImage",
	    query = "SELECT ed.id, ed.emp_id, ed.full_name, ed.date_of_birth, ed.email, ed.address, ed.contact_no, "
	          + "ed.designation, ed.department, ed.leave_status, ed.status, ed.salary, ed.documents, ed.joining_date, "
	          + "fm.file_name AS fileName, fm.file_type AS fileType, fm.file_size AS fileSize "
	          + "FROM employee_details ed "
	          + "INNER JOIN file_met_data fm ON ed.id = fm.employee_id",
	    resultSetMapping = "EmployeeDetailsMapping"
	)
public class EmployeeDetailsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "emp_id")
	private Long empId;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	private String email;
	private String address;
	@Column(name = "contact_no")
	private String contactNo;
	private String designation;
	private String department;
	@Column(name = "leave_status")
	private String leaveStatus;
	private String status;
	private String salary;
	private String documents;
	@Column(name = "joining_date")
	private String joiningDate;

	@Transient
	private String fileName;
	@Transient
	private String fileType;
	@Transient
	private long fileSize;
	
	

	public EmployeeDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDetailsModel(Integer id, Long empId, String fullName, String dateOfBirth, String email,
			String address, String contactNo, String designation, String department, String leaveStatus, String status,
			String salary, String documents, String joiningDate, String fileName, String fileType, long fileSize) {
		this.id = id;
		this.empId = empId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.address = address;
		this.contactNo = contactNo;
		this.designation = designation;
		this.department = department;
		this.leaveStatus = leaveStatus;
		this.status = status;
		this.salary = salary;
		this.documents = documents;
		this.joiningDate = joiningDate;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

}
