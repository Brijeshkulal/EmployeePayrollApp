package com.bridgelabz.employeepayrollapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayRollController {
	
	@RequestMapping(value={"","/","/get"})
	public ResponseEntity<ResponseDto> getEmployeePayrollData() {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDto("Bijju", 40000));
		ResponseDto responseDTO = new ResponseDto("Get Call Success", employeePayrollData);
		return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
	}
    
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId") int employeeId) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDto("Brijesh", 60000));
		ResponseDto responseDTO = new ResponseDto("Get Call  For ID Successfull", employeePayrollData);
		return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
	}
    
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
		ResponseDto responseDTO = new ResponseDto("Created Employee Pyroll Data Successfully", employeePayrollData);
		return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDto empPayrollDTO){
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(empId,empPayrollDTO);
		ResponseDto respDTO = new ResponseDto("Update Employee PayrollData Successful:",employeePayrollData);
		return new ResponseEntity<ResponseDto>(respDTO,HttpStatus.OK);
	}
    
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("employeeId") int employeeId) {
		ResponseDto responseDTO = new ResponseDto("Deleted Sucessfully", "Deleted Id: " + employeeId);
		return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
	}
}
