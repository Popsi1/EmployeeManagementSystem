package com.example.employeemangementsystem.Model;


import com.example.employeemangementsystem.Model.enums.AttendanceStatus;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;
    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalTime localTime;
    @DateTimeFormat(pattern = "yyyy:mm:dd")
    private LocalDate localDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Employee employee;
}

