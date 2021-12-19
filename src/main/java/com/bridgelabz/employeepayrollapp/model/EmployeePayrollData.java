package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeePayrollData {
	
	private int employeeId;
	private String name;
	private long salary;
	private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;
    
	public EmployeePayrollData() {
		
	}

	public EmployeePayrollData(int employeeId, EmployeePayrollDto employeePayrollDto) {
		this.employeeId = employeeId;
		this.name = employeePayrollDto.name;
		this.salary = employeePayrollDto.salary;
		this.gender=employeePayrollDto.gender;
	    this.startDate=employeePayrollDto.startDate;
	    this.note=employeePayrollDto.note;
	    this.profilePic=employeePayrollDto.profilePic;
	    this.departments=employeePayrollDto.departments;
    }
}
