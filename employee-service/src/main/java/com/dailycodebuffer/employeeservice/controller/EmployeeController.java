package com.dailycodebuffer.employeeservice.controller;

import com.dailycodebuffer.employeeservice.model.Employee;
import com.dailycodebuffer.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@AllArgsConstructor
@Slf4j
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.addEmployee(employee);
        log.info("Employee is created {}", employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        log.info("fetching all the employees");
        return new ResponseEntity<>(employeeRepository.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        log.info("Finding the employee by the id {}", id);
        return new ResponseEntity<>(employeeRepository.findById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Employee>> findByDepartmentId(@PathVariable Long departmentId) {
        log.info("Finding the employee by the department id {}", departmentId);
        return new ResponseEntity<>(employeeRepository.findByDepartmentId(departmentId), HttpStatus.ACCEPTED);
    }
}
