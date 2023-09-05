package com.project.onlineappointmentscheduling.controller;

import com.project.onlineappointmentscheduling.dto.EmployeeDetailsDTO;
import com.project.onlineappointmentscheduling.dto.ResponseDTO;
import com.project.onlineappointmentscheduling.service.EmployeeDetailsService;
import com.project.onlineappointmentscheduling.util.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "oas/Emp")

public class EmployeeDetailsController {

    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/saveEmp")
    public ResponseEntity saveEmployeeDetails(@RequestBody EmployeeDetailsDTO employeeDetailsDTO){
        try {
            String response = employeeDetailsService.saveEmployeeDetails(employeeDetailsDTO);
            if (response.equals("00")){
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Employee Save Successfully!!");
                responseDTO.setContent(employeeDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if(response.equals("06")) {
                responseDTO.setCode(ResponseList.RSP_DUPLICATED);
                responseDTO.setMessage("Employee Already Registered!!");
                responseDTO.setContent(employeeDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_ACCEPTABLE);

            } else {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("Employee Save Error!!!");
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

    @PutMapping(value = "/updateEmp")
    public ResponseEntity updateEmployeeDetails(@RequestBody EmployeeDetailsDTO employeeDetailsDTO){
        try {
            String response = employeeDetailsService.updateEmployeeDetails(employeeDetailsDTO);
            if (response.equals("00")){
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Employee Update Successfully!!");
                responseDTO.setContent(employeeDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if(response.equals("01")) {
                responseDTO.setCode(ResponseList.RSP_DUPLICATED);
                responseDTO.setMessage("Employee doesn't exist!!");
                responseDTO.setContent(employeeDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);

            } else {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("Employee Update Error!!!");
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

    @PostMapping(value = "/getAllEmp")
    public ResponseEntity getAllEmployees(){
        try {
            List<EmployeeDetailsDTO> employeeDetailsDTOList = employeeDetailsService.getAllEmployees();
            if (employeeDetailsDTOList.isEmpty() || employeeDetailsDTOList == null) {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("All Employee Data View Not Found!!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("All Employee Data View Successfully!!");
                responseDTO.setContent(employeeDetailsDTOList);
                //System.out.println("DR - "+employeeDetailsDTOList);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }

        }catch (Exception ex){
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database Error!!!");
            //System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(value = "/getAllEmpWA")
    public ResponseEntity getAllEmployeeWithoutAdmin(){
        try {
            List<EmployeeDetailsDTO> employeeDetailsDTOList = employeeDetailsService.getAllEmployeeWithoutAdmin();
            if (employeeDetailsDTOList.isEmpty() || employeeDetailsDTOList == null) {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("All Employee Data View Without Admin Not Found!!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("All Employee Data View Without Admin Successfully!!");
                responseDTO.setContent(employeeDetailsDTOList);
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

    @PostMapping("/getEmpByNIC/{empNIC}")
    public ResponseEntity getEmployeeDetailsByNIC(@PathVariable String empNIC){
        try {
            List<EmployeeDetailsDTO> employeeDetailsDTOList =
                    employeeDetailsService.getEmployeeDetailsByNIC(empNIC);

            if (employeeDetailsDTOList.isEmpty() || employeeDetailsDTOList == null) {
                responseDTO.setCode(ResponseList.RSP_FAIL);
                responseDTO.setMessage("Employee Data By NIC View Not Found!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Employee Data By NIC View Successfully!!");
                responseDTO.setContent(employeeDetailsDTOList);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }

        } catch (Exception ex) {
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database Error!!!");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/viewEmpByEmail/{empEmail}")
    public ResponseEntity viewEmployeeDetails(@PathVariable String empEmail){
        try {
            EmployeeDetailsDTO employeeDetailsDTO =
                    employeeDetailsService.viewEmployeeDetails(empEmail);
            if (employeeDetailsDTO != null) {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Employee Data By Email View Successfully!!");
                responseDTO.setContent(employeeDetailsDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(ResponseList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Employee Data By Email View Not Found!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database Error!!!");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEmp/{empEmail}")
    public ResponseEntity deleteEmployee(@PathVariable String empEmail){
        try {
            String response = employeeDetailsService.deleteEmployeeByEmail(empEmail);
            if (response.equals("00")) {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Employee Delete Successfully!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(ResponseList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Employee doesn't exist!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("Database Error!!!");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/empByEmail/{email}")
    public ResponseEntity checkEmpExistsByEmail(@PathVariable String email) {
        try {
            String response = employeeDetailsService.checkEmpExistsByEmail(email);
            if (response.equals("00")) {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Employee Found!!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(ResponseList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Employee doesn't exist!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            responseDTO.setCode(ResponseList.RSP_ERROR);
            responseDTO.setMessage("System Error!!!");
            System.out.println(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/empType/{email}")
    public ResponseEntity checkEmpType(@PathVariable String email) {
        try {
            EmployeeDetailsDTO employeeDetailsDTO =
                    employeeDetailsService.viewEmployeeDetails(email);
            if (employeeDetailsDTO != null) {
                responseDTO.setCode(ResponseList.RSP_SUCCESS);
                responseDTO.setMessage("Employee Data By Email View Successfully!!");
                responseDTO.setContent(employeeDetailsDTO.getEmpType());
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(ResponseList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Employee Data By Email View Not Found!!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
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
