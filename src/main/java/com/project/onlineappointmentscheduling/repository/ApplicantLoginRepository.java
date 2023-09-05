package com.project.onlineappointmentscheduling.repository;

import com.project.onlineappointmentscheduling.entity.ApplicantLogin;
import com.project.onlineappointmentscheduling.entity.EmployeeLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicantLoginRepository extends JpaRepository<ApplicantLogin, String> {

    @Query(value = "SELECT * FROM `applicant_login` WHERE `applicant_email`=?1 AND `applicant_password`=?2",nativeQuery = true)
    public List<ApplicantLogin> userLoginVerify(String email, String password);
}
