package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;

public class EmployeePayrollData {
	
	private int employeeId;
	private String name;
	private long salary;
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getSalary() {
		return salary;
	}
	
	public void setSalary(long salary) {
		this.salary = salary;
	}

	public EmployeePayrollData() {
		
	}

	public EmployeePayrollData(int employeeId, EmployeePayrollDto employeePayrollDto) {
		this.employeeId = employeeId;
		this.name = employeePayrollDto.name;
		this.salary = employeePayrollDto.salary;
    }
}
