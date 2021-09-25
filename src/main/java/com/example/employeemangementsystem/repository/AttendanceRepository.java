package com.example.employeemangementsystem.repository;

import com.example.employeemangementsystem.Model.Attendance;
import com.example.employeemangementsystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {

    List<Attendance> findAttendancesByLocalDateBetweenAndEmployee(LocalDate startDate, LocalDate endDate, Employee employee);

    Optional<Attendance> findAttendanceByEmployee_IdAndLocalDate(int id, LocalDate localDate);
}
