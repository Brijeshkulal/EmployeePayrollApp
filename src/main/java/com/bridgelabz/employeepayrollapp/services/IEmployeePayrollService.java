package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	
	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataById(int employeeId);
	
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto);

	EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDto employeePayrollDTO);

	String deleteEmployeePayrollData(int employeeId);
	
	List<EmployeePayrollData> getEmployeesByDepartment(String department);

}
