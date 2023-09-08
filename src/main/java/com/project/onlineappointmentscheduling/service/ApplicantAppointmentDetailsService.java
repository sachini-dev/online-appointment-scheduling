package com.project.onlineappointmentscheduling.service;

import com.project.onlineappointmentscheduling.dto.ApplicantAppointmentDetailsDTO;
import com.project.onlineappointmentscheduling.dto.ApplicantAppointmentsAllDTO;
import com.project.onlineappointmentscheduling.dto.EmployeeDetailsDTO;
import com.project.onlineappointmentscheduling.entity.ApplicantAppointmentDetails;
import com.project.onlineappointmentscheduling.repository.ApplicantAppointmentDetailsRepository;
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
public class ApplicantAppointmentDetailsService {

    @Autowired
    private ApplicantAppointmentDetailsRepository applicantAppointmentDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String saveAppointmentDetails(ApplicantAppointmentDetailsDTO applicantAppointmentDetailsDTO){
        if (applicantAppointmentDetailsRepository.existsById(applicantAppointmentDetailsDTO.getAppointmentId())){
            return ResponseList.RSP_DUPLICATED;
        } else {
            applicantAppointmentDetailsRepository.save(modelMapper.map
                    (applicantAppointmentDetailsDTO, ApplicantAppointmentDetails.class));
            return ResponseList.RSP_SUCCESS;
        }
    }

    public List<ApplicantAppointmentsAllDTO> getAllAppointments(){
        List<ApplicantAppointmentsAllDTO> applicantAppointmentsAllDTOList =
                applicantAppointmentDetailsRepository.viewAllAppointment();
        return modelMapper.map(applicantAppointmentsAllDTOList,
                new TypeToken<ArrayList<ApplicantAppointmentsAllDTO>>(){
        }.getType());
    }
}
