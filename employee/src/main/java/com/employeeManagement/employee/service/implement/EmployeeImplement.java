package com.employeeManagement.employee.service.implement;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.employeeManagement.employee.entity.Employee;
import com.employeeManagement.employee.repository.EmployeeRepository;
import com.employeeManagement.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImplement implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeImplement(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByID(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return  employee.get();
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee emp = employeeRepository.findById(id).get();
        emp.setEmpName(employee.getEmpName());
        emp.setEmpGender(employee.getEmpGender());
        emp.setEmpSalary(employee.getEmpSalary());
        emp.setEmpAddress(employee.getEmpAddress());
        employeeRepository.save(emp);
        return emp;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id);
        employeeRepository.deleteById(id);
    }


}
