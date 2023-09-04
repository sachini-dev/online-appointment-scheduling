package com.project.onlineappointmentscheduling.service;

import com.project.onlineappointmentscheduling.dto.ApplicantDetailsDTO;
import com.project.onlineappointmentscheduling.entity.ApplicantDetails;
import com.project.onlineappointmentscheduling.repository.ApplicantDetailsRepository;
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
public class ApplicantDetailsService {

    @Autowired
    private ApplicantDetailsRepository applicantDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String saveApplicantDetails(ApplicantDetailsDTO applicantDetailsDTO){
        if (applicantDetailsRepository.existsById(applicantDetailsDTO.getApplicantEmail())){
            return ResponseList.RSP_DUPLICATED;
        } else {
            applicantDetailsRepository.save(modelMapper.map
                    (applicantDetailsDTO, ApplicantDetails.class));
            return ResponseList.RSP_SUCCESS;
        }
    }

}
