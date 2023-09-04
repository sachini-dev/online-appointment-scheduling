package com.project.onlineappointmentscheduling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ApplicantLogin")
public class ApplicantLogin {
    @Id
    private String applicantEmail;
    private String applicantPassword;

}
