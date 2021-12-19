package com.bridgelabz.employeepayrollapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.employeepayrollapp.dto.ResponseDto;

import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {
	private static final String message = "Exception while processing REST Request";
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
		ResponseDto responseDto = new ResponseDto(message, errMsg);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDto> handleEmployeePayyrollException(EmployeePayrollException exception) {
		ResponseDto responseDto = new ResponseDto(message,exception.getMessage());
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
		log.error("Invalid Date Format", exception);
		ResponseDto responseDto = new ResponseDto(message, "Should have date in the format of dd MMM yyyy");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
