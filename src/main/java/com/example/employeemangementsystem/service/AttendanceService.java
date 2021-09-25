package com.example.employeemangementsystem.service;

import com.example.employeemangementsystem.Model.Attendance;
import com.example.employeemangementsystem.Model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AttendanceService {
    void markAttendance(Employee employee);
    List<Attendance> viewAttendanceList(LocalDate startDate, LocalDate endDate, Employee employee);
}