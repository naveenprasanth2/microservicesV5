package com.dailycodebuffer.employeeservice.repository;

import com.dailycodebuffer.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return employees;
    }

    public Employee findById(Long id) {
        return employees.stream().filter(x -> x.id().equals(id)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    public List<Employee> findByDepartmentId(Long departmentId) {
        return employees.stream().filter(x -> x.departmentId().equals(departmentId)).toList();
    }
}
