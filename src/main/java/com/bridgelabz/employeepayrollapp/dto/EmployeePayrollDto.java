package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class EmployeePayrollDto {
	
	@NotEmpty(message = "Employee Name cannot be Null")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name Invalid")
	public String name;
	
	@Min(value = 500, message = "Min Wage should be more than 500")
	public long salary;
	
	public String gender;
    
    public String startDate;

    public String note;

    public String profilePic;

    public List<String> departments;

}
