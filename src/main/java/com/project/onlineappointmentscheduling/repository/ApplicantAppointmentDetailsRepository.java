package com.project.onlineappointmentscheduling.repository;

import com.project.onlineappointmentscheduling.entity.ApplicantAppointmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicantAppointmentDetailsRepository extends JpaRepository<ApplicantAppointmentDetails, String> {


}
