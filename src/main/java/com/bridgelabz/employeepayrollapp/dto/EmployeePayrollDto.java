package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
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
	
	@Pattern(regexp = "male|female", message ="Gender needs to be male or female")
	public String gender;
    
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	@NotNull(message = "Start Date should Not be empty")
//	@PastOrPresent (message = "Start Date should be past or today's date")
	public String startDate;
    
    @NotBlank(message = "Note cannot be Empty")
    public String note;
    
    @NotBlank(message = "Profile Picture cannot be Empty")
    public String profilePic;
    
    @NotNull(message = "Departments cannot not be empty")
    public List<String> departments;

	
}
