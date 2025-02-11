package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService;
    
    @BeforeEach
    public void setup() {
        employeeService = new EmployeeService();  // Initialize the service
    }

    @Test
    public void testCreateEmployee() {
        EmployeeCreator creator = new EmployeeCreator("John", "Doe", 50000, 30, "Software Engineer", "john.doe@example.com", Instant.now(), Instant.now());
        
        Employee employee = employeeService.createEmployee(creator);
        
        assertNotNull(employee.getUuid());  // Ensure the employee has a UUID
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals(50000, employee.getSalary());
    }

    @Test
    public void testGetAllEmployees() {
        EmployeeCreator creator1 = new EmployeeCreator("John", "Doe", 50000, 30, "Software Engineer", "john.doe@example.com", Instant.now(), Instant.now());
        employeeService.createEmployee(creator1);
        
        EmployeeCreator creator2 = new EmployeeCreator("Jane", "Doe", 60000, 28, "Product Manager", "jane.doe@example.com", Instant.now(), Instant.now());
        employeeService.createEmployee(creator2);
        
        List<Employee> employees = employeeService.getAllEmployees();
        
        assertEquals(2, employees.size());  // We created two employees
    }

    @Test
    public void testGetEmployeeByUuid() {
        EmployeeCreator creator = new EmployeeCreator("John", "Doe", 50000, 30, "Software Engineer", "john.doe@example.com", Instant.now(), Instant.now());
        Employee createdEmployee = employeeService.createEmployee(creator);
        UUID uuid = createdEmployee.getUuid();

        Employee employee = employeeService.getEmployeeByUuid(uuid);
        
        assertNotNull(employee);
        assertEquals(uuid, employee.getUuid());  // Ensure the UUID matches
    }

    @Test
    public void testGetEmployeeByUuidNotFound() {
        UUID nonExistentUuid = UUID.randomUUID();
        Employee employee = employeeService.getEmployeeByUuid(nonExistentUuid);
        
        assertNull(employee);  // Should return null as the employee does not exist
    }
}
