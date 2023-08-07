package com.employeeManagement.employee.controller;
import com.employeeManagement.employee.entity.Employee;
import com.employeeManagement.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/post")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>((Employee)employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmpByID (@PathVariable("id") long id){
        return new ResponseEntity<>(employeeService.getEmployeeByID(id),HttpStatus.OK);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Employee> updateStudentByID (@PathVariable("id") long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmp (@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Student Deleted",HttpStatus.OK);
    }
}
