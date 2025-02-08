package com.challenge.api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;
    private Employee mockEmployee;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl();
        mockEmployee = mock(Employee.class);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        assertNotNull(employees);
        assertTrue(employees.isEmpty());
    }

    @Test
    void testGetEmployeeByUuid() {
        UUID uuid = UUID.randomUUID();
        when(mockEmployee.getUuid()).thenReturn(uuid);
        employeeService.createEmployee(mockEmployee);

        Employee foundEmployee = employeeService.getEmployeeByUuid(uuid);
        assertNotNull(foundEmployee);
        assertEquals(uuid, foundEmployee.getUuid());
    }

    @Test
    void testCreateEmployee() {
        when(mockEmployee.getUuid()).thenReturn(UUID.randomUUID());
        Employee createdEmployee = employeeService.createEmployee(mockEmployee);

        assertNotNull(createdEmployee);
        assertNotNull(createdEmployee.getUuid());
        assertEquals(1, employeeService.getAllEmployees().size());
    }
}
