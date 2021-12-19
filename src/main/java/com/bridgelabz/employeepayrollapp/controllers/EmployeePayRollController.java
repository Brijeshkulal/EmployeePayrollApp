package com.bridgelabz.employeepayrollapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayRollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	@RequestMapping(value={"","/","/get"})
	public ResponseEntity<ResponseDto> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.getEmployeePayrollData();
		ResponseDto responseDTO = new ResponseDto("Get Call Success", empDataList);
		return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
	}
    
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId") int employeeId) {
		EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(employeeId);
		ResponseDto responseDTO = new ResponseDto("Get Call  For ID Successfull", employeePayrollData);
		return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
	}
    
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> addEmployeePayrollData(
			@Valid @RequestBody EmployeePayrollDto employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
		ResponseDto responseDTO = new ResponseDto("Created Employee Pyroll Data Successfully", employeePayrollData);
		return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
	}
	
	
	 @PutMapping("/update/{empId}")
	    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable("empId") int empId,
	    		@Valid @RequestBody EmployeePayrollDto empPayrollDTO){
	        EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
	        ResponseDto respDTO = new ResponseDto("Update Employee PayrollData Successful:",employeePayrollData);
	        return new ResponseEntity<ResponseDto>(respDTO,HttpStatus.OK);
	}
    
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("emppId") int employeeId) {
		employeePayrollService.deleteEmployeePayrollData(employeeId);
		ResponseDto responseDTO = new ResponseDto("Deleted Sucessfully", "Deleted Id: " + employeeId);
		return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
	}
}
