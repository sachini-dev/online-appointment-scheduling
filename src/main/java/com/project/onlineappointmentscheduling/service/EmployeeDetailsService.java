package com.project.onlineappointmentscheduling.service;

import com.project.onlineappointmentscheduling.dto.EmployeeDetailsDTO;
import com.project.onlineappointmentscheduling.entity.EmployeeDetails;
import com.project.onlineappointmentscheduling.repository.EmployeeDetailsRepository;
import com.project.onlineappointmentscheduling.util.ResponseList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeDetailsService {

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployeeDetails(EmployeeDetailsDTO employeeDetailsDTO){
        if (employeeDetailsRepository.existsById(employeeDetailsDTO.getEmpEmail())){
            return ResponseList.RSP_DUPLICATED;
        } else {
            employeeDetailsRepository.save(modelMapper.map(employeeDetailsDTO, EmployeeDetails.class));
            return ResponseList.RSP_SUCCESS;
        }
    }
    public String updateEmployeeDetails(EmployeeDetailsDTO employeeDetailsDTO){
        if (employeeDetailsRepository.existsById(employeeDetailsDTO.getEmpEmail())){
            employeeDetailsRepository.save(modelMapper.map(employeeDetailsDTO, EmployeeDetails.class));
            return ResponseList.RSP_SUCCESS;
        } else {
            return ResponseList.RSP_NO_DATA_FOUND;
        }
    }
    public List<EmployeeDetailsDTO> getAllEmployees(){
        List<EmployeeDetails> employeeDetailsList = employeeDetailsRepository.findAll();
        return modelMapper.map(employeeDetailsList,new TypeToken<ArrayList<EmployeeDetailsDTO>>(){
        }.getType());
    }
    public List<EmployeeDetailsDTO> getAllEmployeeWithoutAdmin(){
        List<EmployeeDetails> employeeDetailsList = employeeDetailsRepository.getAllEmployeeWithoutAdmin();
        return modelMapper.map(employeeDetailsList,new TypeToken<ArrayList<EmployeeDetailsDTO>>(){
        }.getType());
    }
    public List<EmployeeDetailsDTO> getEmployeeDetailsByNIC(String nic){
        List<EmployeeDetails> employeeDetailsList = employeeDetailsRepository.getEmployeeDetailsByNIC(nic);
        return modelMapper.map(employeeDetailsList,new TypeToken<ArrayList<EmployeeDetailsDTO>>(){
        }.getType());
    }
    public EmployeeDetailsDTO viewEmployeeDetails(String empEmpEmail){
        if (employeeDetailsRepository.existsById(empEmpEmail)){
            EmployeeDetails employeeDetails = employeeDetailsRepository.findById(empEmpEmail).orElse(null);
            return modelMapper.map(employeeDetails, EmployeeDetailsDTO.class);
        } else {
            return null;
        }
    }
    public String deleteEmployeeByEmail(String empEmpEmail){
        if (employeeDetailsRepository.existsById(empEmpEmail)){
            employeeDetailsRepository.deleteById(empEmpEmail);
            return ResponseList.RSP_SUCCESS;
        } else {
            return ResponseList.RSP_NO_DATA_FOUND;
        }
    }
    public String checkEmpExistsByEmail(String email){
        if (employeeDetailsRepository.existsById(email)){
            return ResponseList.RSP_SUCCESS;
        } else {
            return ResponseList.RSP_NO_DATA_FOUND;
        }
    }
}
