package com.employeeManagement.employee.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Employee's Name")
    private String empName;

    @Column(name = "Employee's Gender")
    private String empGender;

    @Column(name = "Employee's Salary")
    private Double empSalary;

    @Column(name = "Employee's Address")
    private String empAddress;

}
