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
@Table(name = "ApplicantDetails")
public class ApplicantDetails {
    @Id
    private String applicantEmail;
    private String applicantName;
    private String applicantNIC;
    private String applicantTp;

}
