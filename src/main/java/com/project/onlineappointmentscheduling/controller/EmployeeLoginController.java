package com.project.onlineappointmentscheduling.controller;

import com.project.onlineappointmentscheduling.dto.EmployeeLoginDTO;
import com.project.onlineappointmentscheduling.dto.ResponseDTO;
import com.project.onlineappointmentscheduling.service.EmployeeLoginService;
import com.project.onlineappointmentscheduling.util.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "oas/Emp")

public class EmployeeLoginController {

    @Autowired
    private EmployeeLoginService employeeLoginService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping("/userLoginVerify/{empEmail}/{empPassword}")
    public ResponseEntity userLoginVerify(@PathVariable String empEmail, @PathVariable String empPassword){
        try {
            List<EmployeeLoginDTO> employeeLoginDTOList =
                    employeeLoginService.userLoginVerify(empEmail,empPassword);

            if (employeeLoginDTOList.isEmpty() || employeeLoginDTOList == null) {
                responseDTO.setCode(ResponseList.RSP_NOT_AUTHORISED);
                responseDTO.setMessage("LOGIN-FALL");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.FORBIDDEN);
            } else if (employeeLoginDTOList.size() == 1) {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("LOGIN-PASS");
                responseDTO.setContent(employeeLoginDTOList);
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

    @PostMapping("/checkEmpByEmail/{email}")
    public ResponseEntity checkEmployeeByEmail(@PathVariable String email){
        try {
            List<EmployeeLoginDTO> employeeLoginDTOList =
                    employeeLoginService.checkEmployeeByEmail(email);
            if (employeeLoginDTOList.isEmpty() || employeeLoginDTOList == null) {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("Employee-Not-Found");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Employee-Found");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }
        } catch (Exception ex) {
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database-Error");
            //System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/saveEmpLogin")
    public ResponseEntity saveEmpLogin(@RequestBody EmployeeLoginDTO employeeLoginDTO){
        try {
            String response = employeeLoginService.saveEmpLogin(employeeLoginDTO);
            if (response.equals("00")){
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Employee Login Save Successfully!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if(response.equals("06")) {
                responseDTO.setCode(ResponseList.RSP_DUPLICATED);
                responseDTO.setMessage("Employee Login Already Registered!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_ACCEPTABLE);

            } else {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("Employee Login Save Error!!!");
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
