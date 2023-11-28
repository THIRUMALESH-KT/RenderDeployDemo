package com.aws.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.entity.Employee;
import com.aws.repo.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class controller {

	@Autowired
	private EmployeeRepo repo;
	   @GetMapping(value = "/welcome", produces = "application/json")
	    public ResponseEntity<Map<String, Object>> welcome() {
	        Map<String, Object> map = new LinkedHashMap<>();

	        map.put("result", "success");
	        map.put("body", "This is welcome pagee");
	        map.put("status", HttpStatus.OK);

	        return ResponseEntity.ok(map);
	    }
	
	@GetMapping("/insert")
	public ResponseEntity<Map<String , Object>> insert(@RequestBody Employee ob){
		Map<String , Object> map=new LinkedHashMap<>();
		map.put("result", "sucess");
		map.put("body",repo.save(ob) );
		map.put("status ",HttpStatus.OK);
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/read")
	public ResponseEntity<Map<String , Object>> read(){
		Map<String , Object> map=new LinkedHashMap<>();
		map.put("result", "sucess");
		map.put("body",repo.findAll() );
		map.put("status ",HttpStatus.OK);
		return ResponseEntity.ok(map);
	}
}
