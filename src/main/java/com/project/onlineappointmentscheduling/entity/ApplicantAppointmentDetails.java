package com.project.onlineappointmentscheduling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ApplicantAppointmentDetails")
public class ApplicantAppointmentDetails {
    @Id
    private String appointmentId;
    private String applicantEmail;
    private String appointmentDetails;
    private int appointmentType;

}
