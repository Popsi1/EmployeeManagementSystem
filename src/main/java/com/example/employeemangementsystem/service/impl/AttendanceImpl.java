package com.example.employeemangementsystem.service.impl;

import com.example.employeemangementsystem.Model.Attendance;
import com.example.employeemangementsystem.Model.Employee;
import com.example.employeemangementsystem.Model.enums.AttendanceStatus;
import com.example.employeemangementsystem.repository.AttendanceRepository;
import com.example.employeemangementsystem.repository.EmployeeRepository;
import com.example.employeemangementsystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AttendanceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Attendance> viewAttendanceList(LocalDate startDate, LocalDate endDate, Employee employee) {
        return attendanceRepository.findAttendancesByLocalDateBetweenAndEmployee(startDate, endDate, employee);
    }

    @Override
    public void markAttendance(Employee employee) {
        LocalTime reportTime= LocalTime.parse("09:00:00.000");
        LocalTime closingTime= LocalTime.parse("11:00:00.000");
        LocalDate localDate= LocalDate.now();
        LocalTime localTime= LocalTime.now();
        System.out.println(employee.getId());
        //Optional<Attendance>attendance1 =attendanceRepository.findAttendanceByEmployee_IdAndLocalDate(employee.getId(),localDate);
        Attendance attendance= new Attendance();
        attendance.setEmployee(employee);

        if(localTime.isAfter(reportTime)&&localTime.isBefore(closingTime)){
            attendance.setAttendanceStatus(AttendanceStatus.LATE);
            attendance.setLocalDate(localDate);
            attendance.setLocalTime(localTime);
            attendanceRepository.save(attendance);
        }else if(localTime.isBefore(reportTime)){
            attendance.setAttendanceStatus(AttendanceStatus.PRESENT);
            attendance.setLocalDate(localDate);
            attendance.setLocalTime(localTime);
            attendanceRepository.save(attendance);
        }
        else{
            attendance.setAttendanceStatus(AttendanceStatus.ABSENT);
            attendance.setLocalDate(localDate);
            attendance.setLocalTime(localTime);
            attendanceRepository.save(attendance);
        }
    }



}
