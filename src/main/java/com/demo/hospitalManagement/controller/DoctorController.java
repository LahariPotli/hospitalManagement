package com.demo.hospitalManagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hospitalManagement.dto.DoctorDto;
import com.demo.hospitalManagement.dto.DoctorResponseDto;
import com.demo.hospitalManagement.exception.ResourceNotFoundException;
import com.demo.hospitalManagement.service.DoctorService;

@RestController
public class DoctorController {
	@Autowired
	DoctorService doctorService;

	@GetMapping("/doctors/departmentName")
	public ResponseEntity<List<DoctorResponseDto>> getDoctorsByDepartmentName(
			@RequestParam("departmentName") String departmentName) {
		List<DoctorResponseDto> doctors = doctorService.getDoctorsByDepartmentName(departmentName);
		if (doctors.isEmpty())
			throw new ResourceNotFoundException("no doctors available at this moment", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<DoctorResponseDto>>(doctors, HttpStatus.OK);
	}

	@GetMapping("/hospitals/{hospitalId}/doctors")
	public ResponseEntity<List<DoctorDto>> getDoctorsByHospitalId(@PathVariable("hospitalId") Long hospitalId) {
		List<DoctorDto> doctors = doctorService.getAllDoctorsByHospitalId(hospitalId);
		if (doctors.isEmpty())
			throw new ResourceNotFoundException("no doctors available at this moment", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<DoctorDto>>(doctors, HttpStatus.OK);
	}

}
