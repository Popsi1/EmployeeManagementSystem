package com.example.employeemangementsystem.repository;

import com.example.employeemangementsystem.Model.Leave;
import com.example.employeemangementsystem.Model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {
    Optional<Leave> findLeaveByEmployee_Id(Integer integer);
    List<Leave> findLeavesByStatus(Status status);

}
