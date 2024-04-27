package com.dailycodebuffer.departmentservice.controller;

import com.dailycodebuffer.departmentservice.client.EmployeeClient;
import com.dailycodebuffer.departmentservice.model.Department;
import com.dailycodebuffer.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
@Slf4j
public class DepartmentController {
    private DepartmentRepository departmentRepository;
    private EmployeeClient employeeClient;

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        log.info("Department added: {}", department);
        Department savedDepartment = departmentRepository.addDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        log.info("Departments fetched");
        return new ResponseEntity<>(departmentRepository.findAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("departmentId") Long departmentId) {
        log.info("Department fetched for the id {}", departmentId);
        return new ResponseEntity<>(departmentRepository.getDepartmentById(departmentId), HttpStatus.OK);
    }

    @GetMapping("/with-employees")
    public ResponseEntity<List<Department>> getAllDepartmentsWithEmployees() {
        log.info("Departments with employees fetched");
        List<Department> departments = departmentRepository.findAllDepartments();
        departments.forEach(department -> department
                .setEmployees(employeeClient
                        .findByDepartmentId(department.getId()).getBody()));
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
}
