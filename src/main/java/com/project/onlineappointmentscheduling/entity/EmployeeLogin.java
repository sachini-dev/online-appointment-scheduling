package com.project.onlineappointmentscheduling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "EmployeeLogin")
public class EmployeeLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recId;
    private String empEmail;
    private String empPassword;
    private int empType;

}
