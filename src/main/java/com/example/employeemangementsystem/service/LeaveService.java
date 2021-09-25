package com.example.employeemangementsystem.service;

import com.example.employeemangementsystem.Model.Leave;
import org.springframework.stereotype.Service;

@Service
public interface LeaveService {
    void RequestForLeave(Leave leave);
    Leave displayLeaveStatus(int id);
}
