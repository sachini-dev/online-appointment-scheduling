package com.project.onlineappointmentscheduling.service;

import com.project.onlineappointmentscheduling.dto.ApplicantDetailsDTO;
import com.project.onlineappointmentscheduling.dto.ApplicantLoginDTO;
import com.project.onlineappointmentscheduling.entity.ApplicantDetails;
import com.project.onlineappointmentscheduling.entity.ApplicantLogin;
import com.project.onlineappointmentscheduling.repository.ApplicantLoginRepository;
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
public class ApplicantLoginService {

    @Autowired
    private ApplicantLoginRepository applicantLoginRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ApplicantLoginDTO> userLoginVerify(String email, String password){
        List<ApplicantLogin> applicantLoginList = applicantLoginRepository.userLoginVerify(email,password);
        return modelMapper.map(applicantLoginList,new TypeToken<ArrayList<ApplicantLoginDTO>>(){
        }.getType());
    }

    public String saveApplicantLogin(ApplicantLoginDTO applicantLoginDTO){
        if (applicantLoginRepository.existsById(applicantLoginDTO.getApplicantEmail())){
            return ResponseList.RSP_DUPLICATED;
        } else {
            applicantLoginRepository.save(modelMapper.map
                    (applicantLoginDTO, ApplicantLogin.class));
            return ResponseList.RSP_SUCCESS;
        }
    }

}
