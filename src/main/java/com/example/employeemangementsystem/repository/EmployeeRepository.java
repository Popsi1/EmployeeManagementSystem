package com.example.employeemangementsystem.repository;


import com.example.employeemangementsystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee>findEmployeeByEmailAndPassword(String email, String password);
    List<Employee> findEmployeesBy();

    @Override
    Optional<Employee> findById(Integer integer);
}
