package com.project.onlineappointmentscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApplicantLoginDTO {
    private String applicantEmail;
    private String applicantPassword;
}
