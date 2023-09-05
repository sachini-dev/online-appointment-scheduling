package com.project.onlineappointmentscheduling.service;

import com.project.onlineappointmentscheduling.dto.ApplicantLoginDTO;
import com.project.onlineappointmentscheduling.entity.ApplicantLogin;
import com.project.onlineappointmentscheduling.repository.ApplicantLoginRepository;
import com.project.onlineappointmentscheduling.util.ResponseList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ApplicantLoginService {

    @Autowired
    private ApplicantLoginRepository applicantLoginRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String saveApplicantDetails(ApplicantLoginDTO applicantLoginDTO){
        if (applicantLoginRepository.existsById(applicantLoginDTO.getApplicantEmail())){
            return ResponseList.RSP_DUPLICATED;
        } else {
            applicantLoginRepository.save(modelMapper.map(applicantLoginDTO, ApplicantLogin.class));
            return ResponseList.RSP_SUCCESS;
        }
    }

}
