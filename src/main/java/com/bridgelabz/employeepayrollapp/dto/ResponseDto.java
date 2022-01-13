package com.bridgelabz.employeepayrollapp.dto;

import java.util.List;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import lombok.Data;

@Data
public class ResponseDto {
	private String message;
	private List<EmployeePayrollData> employeePayrollDataList;
    private Object data;

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResponseDto(String message, List<EmployeePayrollData> employeePayrollDataList) {
        this.message = message;
        this.employeePayrollDataList = employeePayrollDataList;
    }
	
}
