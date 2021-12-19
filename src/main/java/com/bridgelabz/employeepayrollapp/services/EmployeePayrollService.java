package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
	
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
		return employeePayrollList.stream().filter(employeePayrollData -> employeePayrollData.getEmployeeId() == employeeId).findFirst().orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, employeePayrollDto);
		employeePayrollList.add(employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDto employeePayrollDto) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(employeeId);
        empData.setName(employeePayrollDto.name);
        empData.setSalary(employeePayrollDto.salary);
        employeePayrollList.set(employeeId-1, empData);
        return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int employeeId) {
		employeePayrollList.remove(employeeId-1);
	}
}
