package com.aws.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exceptionhandle {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String , Object>> handle(Exception ex){
		Map<String , Object> map=new HashMap<>();
		map.put("result ", "failed");
		map.put("message ", ex.getMessage());
		map.put("status code", HttpStatus.BAD_REQUEST
				);
		return ResponseEntity.badRequest().body(map);
	}
}
