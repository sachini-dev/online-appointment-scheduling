package com.project.onlineappointmentscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeLoginDTO {
    private int recId;
    private String empEmail;
    private String empPassword;
    private int empType;
}
