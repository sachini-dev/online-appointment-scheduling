package com.project.onlineappointmentscheduling.controller;

import com.project.onlineappointmentscheduling.dto.ApplicantDetailsDTO;
import com.project.onlineappointmentscheduling.dto.ResponseDTO;
import com.project.onlineappointmentscheduling.service.ApplicantDetailsService;
import com.project.onlineappointmentscheduling.util.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "oas/Appl")

public class ApplicantDetailsController {

    @Autowired
    private ApplicantDetailsService applicantDetailsService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/saveAppl")
    public ResponseEntity saveApplicantDetails
            (@RequestBody ApplicantDetailsDTO applicantDetailsDTO){
        try {
            String response =
                    applicantDetailsService.saveApplicantDetails(applicantDetailsDTO);
            if (response.equals("00")){
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Applicant Save Successfully!!");
                responseDTO.setContent(applicantDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if(response.equals("06")) {
                responseDTO.setCode(ResponseList.RSP_DUPLICATED);
                responseDTO.setMessage("Applicant Already Registered!!");
                responseDTO.setContent(applicantDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_ACCEPTABLE);

            } else {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("Applicant Save Error!!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception ex) {
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database Error!!!");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/saveAppl2")
    public ResponseEntity saveApplicantDetails2
            (@RequestBody ApplicantDetailsDTO applicantDetailsDTO){
        try {
            String response =
                    applicantDetailsService.saveApplicantDetails2(applicantDetailsDTO);
            if (response.equals("00")){
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Applicant Save Successfully!!");
                responseDTO.setContent(applicantDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if(response.equals("06")) {
                responseDTO.setCode(ResponseList.RSP_DUPLICATED);
                responseDTO.setMessage("Applicant Already Registered!!");
                responseDTO.setContent(applicantDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_ACCEPTABLE);

            } else {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("Applicant Save Error!!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception ex) {
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database Error!!!");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
