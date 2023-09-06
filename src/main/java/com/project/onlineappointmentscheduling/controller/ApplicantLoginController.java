package com.project.onlineappointmentscheduling.controller;

import com.project.onlineappointmentscheduling.dto.ApplicantLoginDTO;
import com.project.onlineappointmentscheduling.dto.ResponseDTO;
import com.project.onlineappointmentscheduling.service.ApplicantLoginService;
import com.project.onlineappointmentscheduling.util.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "oas/Appl")

public class ApplicantLoginController {

    @Autowired
    private ApplicantLoginService applicantLoginService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping("/userLoginVerify/{Email}/{Password}")
    public ResponseEntity userLoginVerify(@PathVariable String Email, @PathVariable String Password){
        try {
            List<ApplicantLoginDTO> applicantLoginDTOList =
                    applicantLoginService.userLoginVerify(Email,Password);

            if (applicantLoginDTOList.isEmpty() || applicantLoginDTOList == null) {
                responseDTO.setCode(ResponseList.RSP_NOT_AUTHORISED);
                responseDTO.setMessage("LOGIN-FALL 456");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.FORBIDDEN);
            } else if (applicantLoginDTOList.size() == 1) {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("LOGIN-PASS");
                responseDTO.setContent(applicantLoginDTOList);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(ResponseList.RSP_NOT_AUTHORISED);
                responseDTO.setMessage("LOGIN-FALL");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.FORBIDDEN);
            }

        } catch (Exception ex) {
            responseDTO.setCode(ResponseList.RSP_NOT_AUTHORISED);
            responseDTO.setMessage("LOGIN-FALL");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.FORBIDDEN);
        }
    }

}
