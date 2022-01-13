package com.bridgelabz.employeepayrollapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
	
	@Autowired
	private EmployeePayrollRepository employeeRepository;
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepository.findAll();
	}

//	@Override
//	public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
//		Optional<EmployeePayrollData> empData = employeeRepository.findById(employeeId);//.orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
//		if(empData.isPresent()) {
//			empData.get();
//		}
//		return null;
//	}
	
	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
		return employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
		EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(employeePayrollDto);
		log.debug("Employee Payroll Data: " + empData.toString());
		return employeeRepository.save(empData);
	}


	@Override
	public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDto employeePayrollDto) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
		employeePayrollData.updateEmployeePayrollData(employeePayrollDto);
		return employeeRepository.save(employeePayrollData);
	}

//	@Override
//	public void deleteEmployeePayrollData(int employeeId) {
//		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
//		employeeRepository.delete(employeePayrollData);
//	}
	
	@Override
	public String deleteEmployeePayrollData(int employeeId) {
		if (employeeRepository.existsById(employeeId)) {
			employeeRepository.deleteById(employeeId);
			return "Employee data deleted with ID ; " + employeeId;
		}
		else {
			throw new EmployeePayrollException("Employee Data is not present with ID"+ employeeId);
		}
	}

	@Override
	public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
		return employeeRepository.findEmployeeByDepartment(department);
	}
}
