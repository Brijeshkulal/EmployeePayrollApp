package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private long salary;
	@Column(name = "gender")
	private String gender;
	@Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "note")
    private String note;
    @Column(name = "profile_pic")
    private String profilePic;
    
    @ElementCollection
    @CollectionTable(name = "employee_department",
            joinColumns = @JoinColumn(name ="id"))
    @Column(name = "departments")
    private List<String> departments;
    
    public EmployeePayrollData() {
    }
    public EmployeePayrollData(EmployeePayrollDto employeePayrollDto){
        this.updateEmployeePayrollData(employeePayrollDto);
    }

    public void updateEmployeePayrollData( EmployeePayrollDto employeePayrollDto) {
        this.name = employeePayrollDto.name;
        this.salary = employeePayrollDto.salary;
        this.gender = employeePayrollDto.gender;
        this.note = employeePayrollDto.note;
        this.startDate = employeePayrollDto.startDate;
        this.profilePic = employeePayrollDto.profilePic;
        this.departments = employeePayrollDto.departments;

    }
}
