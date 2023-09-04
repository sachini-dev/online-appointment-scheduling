package com.project.onlineappointmentscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDetailsDTO {
    private String empEmail;
    private String empNIC;
    private String empName;
    private String empAddress;
    private int empType;
}
