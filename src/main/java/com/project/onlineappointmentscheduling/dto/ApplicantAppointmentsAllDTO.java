package com.project.onlineappointmentscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApplicantAppointmentsAllDTO {
    private String appointmentId;
    private int appointmentType;
    private String applicantName;
    private String applicantNIC;
    private String applicantTp;
    private String appointmentDetails;

}
