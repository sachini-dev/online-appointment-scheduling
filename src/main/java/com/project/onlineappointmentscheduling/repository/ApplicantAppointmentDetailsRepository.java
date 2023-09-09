package com.project.onlineappointmentscheduling.repository;

import com.project.onlineappointmentscheduling.dto.ApplicantAppointmentsAllDTO;
import com.project.onlineappointmentscheduling.entity.ApplicantAppointmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicantAppointmentDetailsRepository extends JpaRepository<ApplicantAppointmentDetails, String> {

    @Query(value = "SELECT " +
            "new com.project.onlineappointmentscheduling.dto.ApplicantAppointmentsAllDTO" +
            "(aad.appointmentId,aad.appointmentType,ad.applicantName,ad.applicantNIC,ad.applicantTp," +
            "aad.applicantEmail,aad.appointmentDetails) " +
            "FROM ApplicantAppointmentDetails AS aad INNER JOIN ApplicantDetails AS ad " +
            "ON aad.applicantEmail = ad.applicantEmail")
    public List<ApplicantAppointmentsAllDTO> viewAllAppointment();

    @Query(value = "SELECT " +
            "new com.project.onlineappointmentscheduling.dto.ApplicantAppointmentsAllDTO" +
            "(aad.appointmentId,aad.appointmentType,ad.applicantName,ad.applicantNIC,ad.applicantTp," +
            "aad.applicantEmail,aad.appointmentDetails) " +
            "FROM ApplicantAppointmentDetails AS aad INNER JOIN ApplicantDetails AS ad " +
            "ON aad.applicantEmail = ad.applicantEmail WHERE aad.appointmentId=?1")
    public List<ApplicantAppointmentsAllDTO> getAppointmentById(String appointmentId);

    @Query(value = "SELECT " +
            "new com.project.onlineappointmentscheduling.dto.ApplicantAppointmentsAllDTO" +
            "(aad.appointmentId,aad.appointmentType,ad.applicantName,ad.applicantNIC,ad.applicantTp," +
            "aad.applicantEmail,aad.appointmentDetails) " +
            "FROM ApplicantAppointmentDetails AS aad INNER JOIN ApplicantDetails AS ad " +
            "ON aad.applicantEmail = ad.applicantEmail WHERE aad.appointmentType=?1")
    public List<ApplicantAppointmentsAllDTO> getAppointmentByType(int appointmentType);
}
