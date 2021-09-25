package com.example.employeemangementsystem.Model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Employee_Data")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column
    private Double salary;
    @Column(nullable = false)
    private String role;
}



