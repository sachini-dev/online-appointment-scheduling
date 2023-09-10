package com.project.onlineappointmentscheduling.controller;

import com.project.onlineappointmentscheduling.dto.ApplicantAppointmentDetailsDTO;
import com.project.onlineappointmentscheduling.dto.ApplicantAppointmentsAllDTO;
import com.project.onlineappointmentscheduling.dto.EmployeeDetailsDTO;
import com.project.onlineappointmentscheduling.dto.ResponseDTO;
import com.project.onlineappointmentscheduling.service.ApplicantAppointmentDetailsService;
import com.project.onlineappointmentscheduling.util.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "oas/App")

public class ApplicantAppointmentDetailsController {

    @Autowired
    private ApplicantAppointmentDetailsService applicantAppointmentDetailsService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/saveApp")
    public ResponseEntity saveAppointmentDetails
            (@RequestBody ApplicantAppointmentDetailsDTO applicantAppointmentDetailsDTO){
        try {
            String response =
                    applicantAppointmentDetailsService.saveAppointmentDetails(applicantAppointmentDetailsDTO);
            if (response.equals("00")){
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Appointment Save Successfully!!");
                responseDTO.setContent(applicantAppointmentDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if(response.equals("06")) {
                responseDTO.setCode(ResponseList.RSP_DUPLICATED);
                responseDTO.setMessage("Appointment Already Registered!!");
                responseDTO.setContent(applicantAppointmentDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_ACCEPTABLE);

            } else {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("Appointment Save Error!!!");
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

    @PostMapping(value = "/updateApp")
    public ResponseEntity updateAppointmentDetails
            (@RequestBody ApplicantAppointmentDetailsDTO applicantAppointmentDetailsDTO){
        try {
            String response =
                    applicantAppointmentDetailsService.updateAppointmentDetails(applicantAppointmentDetailsDTO);
            if (response.equals("00")){
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Appointment Update Successfully!!");
                responseDTO.setContent(applicantAppointmentDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if(response.equals("01")) {
                responseDTO.setCode(ResponseList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Appointment ID Not Found!!");
                responseDTO.setContent(applicantAppointmentDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_ACCEPTABLE);

            } else {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("Appointment Update Error!!!");
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

    @PostMapping(value = "/getAllApp")
    public ResponseEntity getAllAppointmentDetails(){
        try {
            List<ApplicantAppointmentsAllDTO> applicantAppointmentsAllDTOList =
                    applicantAppointmentDetailsService.getAllAppointments();
            if (applicantAppointmentsAllDTOList.isEmpty() || applicantAppointmentsAllDTOList == null) {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("All Appointment Data View Not Found!!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("All Appointment Data View Successfully!!");
                responseDTO.setContent(applicantAppointmentsAllDTOList);
                System.out.println(applicantAppointmentsAllDTOList);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }

        }catch (Exception ex){
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database Error!!!");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(value = "/getAppById/{id}")
    public ResponseEntity getAllAppointmentDetails(@PathVariable String id){
        try {
            List<ApplicantAppointmentsAllDTO> applicantAppointmentsAllDTOList =
                    applicantAppointmentDetailsService.getAppointmentById(id);
            if (applicantAppointmentsAllDTOList.isEmpty() || applicantAppointmentsAllDTOList == null) {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("All Appointment Data View Not Found!!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("All Appointment Data View Successfully!!");
                responseDTO.setContent(applicantAppointmentsAllDTOList);
                System.out.println(applicantAppointmentsAllDTOList);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }

        }catch (Exception ex){
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database Error!!!");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(value = "/getAppByType/{type}")
    public ResponseEntity getAppointmentByType(@PathVariable int type){
        try {
            List<ApplicantAppointmentsAllDTO> applicantAppointmentsAllDTOList =
                    applicantAppointmentDetailsService.getAppointmentByType(type);
            if (applicantAppointmentsAllDTOList.isEmpty() || applicantAppointmentsAllDTOList == null) {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("All Appointment Data View Not Found!!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("All Appointment Data View Successfully!!");
                responseDTO.setContent(applicantAppointmentsAllDTOList);
                System.out.println(applicantAppointmentsAllDTOList);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }

        }catch (Exception ex){
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database Error!!!");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(value = "/getAppByTypeEmail/{type}/{email}")
    public ResponseEntity getAppointmentByTypeEmail(@PathVariable int type, @PathVariable String email){
        try {
            List<ApplicantAppointmentsAllDTO> applicantAppointmentsAllDTOList =
                    applicantAppointmentDetailsService.getAppointmentByTypeEmail(type,email);
            if (applicantAppointmentsAllDTOList.isEmpty() || applicantAppointmentsAllDTOList == null) {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("All Appointment Data View Not Found!!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("All Appointment Data View Successfully!!");
                responseDTO.setContent(applicantAppointmentsAllDTOList);
                System.out.println(applicantAppointmentsAllDTOList);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }

        }catch (Exception ex){
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database Error!!!");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(value = "/getAppByEmail/{email}")
    public ResponseEntity getAppointmentByTypeEmail(@PathVariable String email){
        try {
            List<ApplicantAppointmentsAllDTO> applicantAppointmentsAllDTOList =
                    applicantAppointmentDetailsService.getAppointmentByEmail(email);
            if (applicantAppointmentsAllDTOList.isEmpty() || applicantAppointmentsAllDTOList == null) {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("All Appointment Data View Not Found!!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("All Appointment Data View Successfully!!");
                responseDTO.setContent(applicantAppointmentsAllDTOList);
                System.out.println(applicantAppointmentsAllDTOList);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }

        }catch (Exception ex){
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database Error!!!");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
