package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeData{
    private static List<Employee> employeeList = new ArrayList<>();

    public static List<Employee> getAllEmployees() {
        return employeeList;
    }

    public static Employee getEmployeeByUuid(UUID uuid) {
        return employeeList.stream()
            .filter(employee -> employee.getUuid().equals(uuid))
            .findFirst()
            .orElse(null);
    }

    public static void saveEmployee(Employee employee) {
        employeeList.add(employee);
    }
}
