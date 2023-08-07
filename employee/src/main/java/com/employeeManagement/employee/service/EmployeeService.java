package com.employeeManagement.employee.service;

import com.employeeManagement.employee.EmployeeApplication;
import com.employeeManagement.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getEmployee();
    Employee getEmployeeByID(long id);
    Employee updateEmployee(Employee employee,long id);
    void deleteEmployee(long id);
}
