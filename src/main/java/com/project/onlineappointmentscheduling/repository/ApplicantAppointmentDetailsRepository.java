package com.project.onlineappointmentscheduling.repository;

import com.project.onlineappointmentscheduling.dto.ApplicantAppointmentsAllDTO;
import com.project.onlineappointmentscheduling.entity.ApplicantAppointmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicantAppointmentDetailsRepository extends JpaRepository<ApplicantAppointmentDetails, String> {

    @Query(value = "SELECT `aad`.`appointment_id`,`aad`.`appointment_type`,`ad`.`applicant_name`,`ad`.`applicantnic`,`ad`.`applicant_tp`,`aad`.`appointment_details` FROM `applicant_appointment_details` `aad`,`applicant_details` `ad` WHERE `aad`.`applicant_email`=`ad`.`applicant_email`; ",nativeQuery = true)
    public List<ApplicantAppointmentsAllDTO> viewAllAppointment();
}
