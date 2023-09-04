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
@Table(name = "EmployeeDetails")
public class EmployeeDetails {
    @Id
    private String empEmail;
    private String empNIC;
    private String empName;
    private String empAddress;
    private int empType;

}
