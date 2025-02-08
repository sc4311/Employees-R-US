package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * REST Controller for managing Employee entities.
 * Provides endpoints to create, retrieve, and list employees.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Constructs an EmployeeController with the specified EmployeeService.
     *
     * @param employeeService the service to manage employees
     */
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Retrieves all employees.
     *
     * @return a list of all employees
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * Retrieves an employee by their UUID.
     *
     * @param uuid the UUID of the employee to retrieve
     * @return the employee with the specified UUID
     * @throws ResponseStatusException if the UUID is invalid or the employee is not found
     */
    @GetMapping("/uuid={uuid}")
    public Employee getEmployeeByUuid(@PathVariable String uuid) {
        try {
            UUID validUuid = UUID.fromString(uuid);
            Employee employee = employeeService.getEmployeeByUuid(validUuid);
            if (employee == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
            }
            return employee;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid UUID format");
        }
    }

    /**
     * Creates a new employee.
     *
     * @param employee the employee data to create
     * @return the newly created employee
     * @throws ResponseStatusException if required fields are missing
     */
    @PostMapping
    public Employee createEmployee(@RequestBody EmployeeImpl employee) {
        if (employee.getFirstName() == null || employee.getLastName() == null || employee.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required fields");
        }
        return employeeService.createEmployee(employee);
    }
}
