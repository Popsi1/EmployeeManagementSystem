package com.example.employeemangementsystem.service.impl;

import com.example.employeemangementsystem.Model.Leave;
import com.example.employeemangementsystem.repository.LeaveRepository;
import com.example.employeemangementsystem.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveImpl implements LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public void RequestForLeave(Leave leave) {
        leaveRepository.save(leave);
    }

    @Override
    public Leave displayLeaveStatus(int id) {
        System.out.println(id);
        return leaveRepository.findLeaveByEmployee_Id(id).get();
    }
}
