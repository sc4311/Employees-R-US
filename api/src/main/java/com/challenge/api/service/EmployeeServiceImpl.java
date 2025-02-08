package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Service;

/**
 * Implementation of the EmployeeService interface.
 * Manages Employee entities using an in-memory list.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new CopyOnWriteArrayList<>();

    /**
     * Retrieves all employees.
     *
     * @return a list of all employees
     */
    @Override
    public List<Employee> getAllEmployees() {
        return new CopyOnWriteArrayList<>(employees);
    }

    /**
     * Retrieves an employee by their UUID.
     *
     * @param uuid the UUID of the employee to retrieve
     * @return the employee with the specified UUID, or null if not found
     */
    @Override
    public Employee getEmployeeByUuid(UUID uuid) {
        return employees.stream()
                .filter(employee -> employee.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    /**
     * Creates a new employee.
     *
     * @param employee the employee data to create
     * @return the newly created employee
     */
    @Override
    public Employee createEmployee(Employee employee) {
        employee.setUuid(UUID.randomUUID());
        employees.add(employee);
        return employee;
    }
}
