package com.dailycodebuffer.departmentservice.repository;

import com.dailycodebuffer.departmentservice.model.Department;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Getter
@Repository
public class DepartmentRepository {
    private final List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public List<Department> findAllDepartments() {
        return departments;
    }

    public Department getDepartmentById(Long id) {
        return getDepartments().stream().filter(x -> x.getId().equals(id)).findFirst().orElseThrow(NoSuchElementException::new);
    }
}
