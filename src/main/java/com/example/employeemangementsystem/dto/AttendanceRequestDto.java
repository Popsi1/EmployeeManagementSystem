package com.example.employeemangementsystem.dto;

import lombok.Data;

@Data
public class AttendanceRequestDto {
    private String startDate;
    private String endDate;
    private int employeeId;
}
