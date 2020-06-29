package com.demo.hospitalManagement.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hospitalManagement.dao.DoctorDao;
import com.demo.hospitalManagement.dao.HospitalDao;
import com.demo.hospitalManagement.dto.DoctorDto;
import com.demo.hospitalManagement.dto.DoctorResponseDto;
import com.demo.hospitalManagement.model.Doctor;
import com.demo.hospitalManagement.model.Hospital;
import com.demo.hospitalManagement.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorDao doctorDao;
	@Autowired
	HospitalDao hospitalDao;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DoctorResponseDto> getDoctorsByDepartmentName(String departmentName) {
		List<DoctorResponseDto> responseList = new ArrayList<DoctorResponseDto>();
		String status = "available";
		Optional<List<Doctor>> doctorsOptional = doctorDao.getDoctorsByDepartmentNameContainingAndStatus(departmentName,
				status);
		if (doctorsOptional.isPresent())
			return doctorsOptional.get().stream().map(doctor -> getDoctorResponseDto(doctor))
					.collect(Collectors.toList());
		else {
			return responseList;
		}
	}

	private DoctorResponseDto getDoctorResponseDto(Doctor doctor) {
		DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
		BeanUtils.copyProperties(doctor, doctorResponseDto);
		Optional<Hospital> hospital = hospitalDao.findByHospitalId(doctor.getHospitalId());
		doctorResponseDto.setHospitalName(hospital.get().getHospitalName());
		return doctorResponseDto;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DoctorDto> getAllDoctorsByHospitalId(Long hospitalId) {
		Optional<List<Doctor>> doctors = doctorDao.findAllByHospitalId(hospitalId);
		List<DoctorDto> doctorDtoList = new ArrayList<>();
		if (doctors.isPresent()) {
			return doctors.get().stream().map(doctor -> getDoctorDto(doctor)).collect(Collectors.toList());
		}
		return doctorDtoList;
	}

	private DoctorDto getDoctorDto(Doctor doctor) {
		DoctorDto doctorDto = new DoctorDto();
		BeanUtils.copyProperties(doctor, doctorDto);
		return doctorDto;

	}

		
}
	
	

