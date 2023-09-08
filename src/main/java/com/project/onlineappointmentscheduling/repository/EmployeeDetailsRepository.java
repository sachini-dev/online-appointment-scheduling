package com.project.onlineappointmentscheduling.repository;

import com.project.onlineappointmentscheduling.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, String> {
    @Query(value = "SELECT * FROM `employee_details` WHERE `empnic` =?1",nativeQuery = true)
    public List<EmployeeDetails> getEmployeeDetailsByNIC(String nic);

    @Query(value = "SELECT * FROM `employee_details` WHERE NOT `emp_type`= '1'",nativeQuery = true)
    public List<EmployeeDetails> getAllEmployeeWithoutAdmin();

}
