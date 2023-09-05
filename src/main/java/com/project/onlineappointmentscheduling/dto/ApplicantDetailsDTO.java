package com.project.onlineappointmentscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApplicantDetailsDTO {
    private String applicantEmail;
    private String applicantName;
    private String applicantNIC;
    private String applicantTp;
}
