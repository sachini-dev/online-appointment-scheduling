package com.project.onlineappointmentscheduling.service;

import com.project.onlineappointmentscheduling.dto.EmployeeLoginDTO;
import com.project.onlineappointmentscheduling.entity.EmployeeLogin;
import com.project.onlineappointmentscheduling.repository.EmployeeLoginRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeLoginService {

    @Autowired
    private EmployeeLoginRepository employeeLoginRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<EmployeeLoginDTO> userLoginVerify(String email,String password){
        List<EmployeeLogin> employeeLoginList = employeeLoginRepository.userLoginVerify(email,password);
        return modelMapper.map(employeeLoginList,new TypeToken<ArrayList<EmployeeLoginDTO>>(){
        }.getType());
    }

    public List<EmployeeLoginDTO> checkEmployeeByEmail(String EmpEmail){
        List<EmployeeLogin> employeeLoginList = employeeLoginRepository.checkEmployeeByEmail(EmpEmail);
        return modelMapper.map(employeeLoginList,new TypeToken<ArrayList<EmployeeLoginDTO>>(){
        }.getType());
    }
}
