package com.aws.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aws.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
