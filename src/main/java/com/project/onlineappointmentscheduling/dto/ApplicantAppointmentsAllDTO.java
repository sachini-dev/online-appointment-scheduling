package com.project.onlineappointmentscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ApplicantAppointmentsAllDTO {
    private String appointmentId;
    private int appointmentType;
    private String applicantName;
    private String applicantNIC;
    private String applicantTp;
    private String applicantEmail;
    private String appointmentDetails;

    public ApplicantAppointmentsAllDTO(String appointmentId, int appointmentType, String applicantName, String applicantNIC, String applicantTp, String applicantEmail, String appointmentDetails) {
        this.appointmentId = appointmentId;
        this.appointmentType = appointmentType;
        this.applicantName = applicantName;
        this.applicantNIC = applicantNIC;
        this.applicantTp = applicantTp;
        this.applicantEmail = applicantEmail;
        this.appointmentDetails = appointmentDetails;
    }
}
