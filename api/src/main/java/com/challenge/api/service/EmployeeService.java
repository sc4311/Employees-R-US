package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    /**
     * Retrieves all employees.
     *
     * @return a list of all employees
     */
    List<Employee> getAllEmployees();

    /**
     * Retrieves an employee by their UUID.
     *
     * @param uuid the UUID of the employee to retrieve
     * @return the employee with the specified UUID, or null if not found
     */
    Employee getEmployeeByUuid(UUID uuid);

    /**
     * Creates a new employee.
     *
     * @param employee the employee data to create
     * @return the newly created employee
     */
    Employee createEmployee(Employee employee);
}
