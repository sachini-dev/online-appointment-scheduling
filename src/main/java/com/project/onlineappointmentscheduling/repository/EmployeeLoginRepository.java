package com.project.onlineappointmentscheduling.repository;

import com.project.onlineappointmentscheduling.entity.EmployeeLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeLoginRepository extends JpaRepository<EmployeeLogin, Integer> {

    @Query(value = "SELECT * FROM `employee_login` WHERE `emp_email`=?1 AND `emp_password`=?2",nativeQuery = true)
    public List<EmployeeLogin> userLoginVerify(String email, String password);

    @Query(value = "SELECT * FROM `employee_login` WHERE `emp_email`=?1",nativeQuery = true)
    public List<EmployeeLogin> checkEmployeeByEmail(String email);

}
