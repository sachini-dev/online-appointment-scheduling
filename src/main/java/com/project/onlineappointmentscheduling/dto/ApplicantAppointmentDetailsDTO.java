package com.project.onlineappointmentscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApplicantAppointmentDetailsDTO {
    private String appointmentId;
    private String applicantEmail;
    private String appointmentDetails;
    private int appointmentType;
}
