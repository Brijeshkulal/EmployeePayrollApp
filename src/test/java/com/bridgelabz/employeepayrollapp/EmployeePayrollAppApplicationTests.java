package com.bridgelabz.employeepayrollapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import com.bridgelabz.employeepayrollapp.services.EmployeePayrollService;

@SpringBootTest
class EmployeePayrollAppApplicationTests {

	@InjectMocks
	private EmployeePayrollService employeePayrollService;
	
	@Mock
	private EmployeePayrollRepository employeePayrollRepository;
	
	
	List<EmployeePayrollData> employeePayrollDataList = null;
	List<String> department = new ArrayList<String>();
	EmployeePayrollData empData;
	EmployeePayrollDto employeePayrollDto;
	
	@BeforeEach
	public void getUser(){
		department.add("HR");
		department.add("Engineering");
		employeePayrollDto = new EmployeePayrollDto("Brijesh",900000, "male", "21 Jan 2020",
				"Hii how", "this pic",department);
		empData = new EmployeePayrollData(employeePayrollDto);
		employeePayrollDataList = Arrays.asList(empData);
	}

	@Test
	public void getEmployeePayrollDataTest() {
		when(employeePayrollRepository.findAll()).thenReturn(employeePayrollDataList);
		assertEquals(employeePayrollDataList,employeePayrollService.getEmployeePayrollData());
	}
	
	
	@Test
	public void getEmployeePayrollDataTest_ReturnSize() {
		when(employeePayrollRepository.findAll()).thenReturn(employeePayrollDataList);
		assertEquals(1,employeePayrollService.getEmployeePayrollData().size());
	}
	
	@Test
	public void createEmployeePayrollDataTest() {
        when(employeePayrollRepository.save(empData)).thenReturn(empData);
       assertEquals(empData,employeePayrollService.createEmployeePayrollData(employeePayrollDto));
	}
	

	@Test
	public void getEmployeeDepartmentTest() {
		when(employeePayrollRepository.findEmployeeByDepartment("Development"))
				.thenReturn(employeePayrollDataList);
		assertEquals(1, employeePayrollService.getEmployeesByDepartment("Development").size());
	}
	
	@Test
	public void getEmployeePayrollDataByIdTest() {
		when(employeePayrollRepository.findById(1)).thenReturn(Optional.of(empData));
		assertEquals(empData, employeePayrollService.getEmployeePayrollDataById(1));
	}
	
	
	@Test
	public void deleteEmployeePayrollDataTest() {
		when(employeePayrollRepository.existsById(1)).thenReturn(true);
		assertEquals(true,employeePayrollRepository.existsById(1));
	}
	
	@Test
	public void updateEmployeePayrollDataTest() {
		when(employeePayrollRepository.findById(1)).thenReturn(Optional.of(empData));
		EmployeePayrollData emp = employeePayrollService.updateEmployeePayrollData(1, employeePayrollDto);
		assertEquals(emp,employeePayrollRepository.save(empData));
	}
}
