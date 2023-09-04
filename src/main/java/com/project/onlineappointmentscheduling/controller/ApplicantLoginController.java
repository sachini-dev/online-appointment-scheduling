package com.project.onlineappointmentscheduling.controller;

import com.project.onlineappointmentscheduling.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "oas/Appl")

public class ApplicantLoginController {


    @Autowired
    private ResponseDTO responseDTO;

}
