package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeCreator; 
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeByUuid(UUID uuid) {
        for (Employee employee : employeeList) {
            if (employee.getUuid().equals(uuid)) {
                return employee;
            }
        }
        return null; 
    }

    public Employee createEmployee(EmployeeCreator employeeCreator) {
        Employee newEmployee = new EmployeeCreator();
        newEmployee.setUuid(UUID.randomUUID());
        newEmployee.setFirstName(employeeCreator.getFirstName());
        newEmployee.setLastName(employeeCreator.getLastName());
        newEmployee.setSalary(employeeCreator.getSalary());
        newEmployee.setAge(employeeCreator.getAge());
        newEmployee.setJobTitle(employeeCreator.getJobTitle());
        newEmployee.setEmail(employeeCreator.getEmail());
        newEmployee.setContractHireDate(employeeCreator.getContractHireDate());
        employeeList.add(newEmployee);
        return newEmployee;
    }
}
