package com.dailycodebuffer.departmentservice.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public final class Department {
    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();
}
