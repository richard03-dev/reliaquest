package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeCreator;
import com.challenge.api.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        Employee employee = mock(Employee.class);
        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(employee));

        mockMvc.perform(get("/api/v1/employee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists());
    }

    @Test
    public void testGetEmployeeByUuid() throws Exception {
        UUID uuid = UUID.randomUUID();
        Employee employee = mock(Employee.class);
        when(employeeService.getEmployeeByUuid(uuid)).thenReturn(employee);

        mockMvc.perform(get("/api/v1/employee/{uuid}", uuid))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uuid").exists());
    }

    @Test
    public void testCreateEmployee() throws Exception {
        EmployeeCreator creator = new EmployeeCreator("John", "Doe", 50000, 30, "Software Engineer", "john.doe@example.com", null, null);
        Employee createdEmployee = new EmployeeCreator();
        createdEmployee.setUuid(UUID.randomUUID());
        
        when(employeeService.createEmployee(any(EmployeeCreator.class))).thenReturn(createdEmployee);

        mockMvc.perform(post("/api/v1/employee")
                        .contentType("application/json")
                        .content("{ \"firstName\": \"John\", \"lastName\": \"Doe\", \"salary\": 50000, \"age\": 30, \"jobTitle\": \"Software Engineer\", \"email\": \"john.doe@example.com\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uuid").exists());
    }

    @Test
    public void testGetEmployeeByUuidNotFound() throws Exception {
        UUID nonExistentUuid = UUID.randomUUID();
        when(employeeService.getEmployeeByUuid(nonExistentUuid)).thenReturn(null);

        mockMvc.perform(get("/api/v1/employee/{uuid}", nonExistentUuid))
                .andExpect(status().isNotFound());
    }
}
