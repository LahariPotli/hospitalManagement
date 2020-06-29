package com.demo.hospitalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hospitalManagement.dto.HospitalDto;
import com.demo.hospitalManagement.dto.HospitalRequestDto;
import com.demo.hospitalManagement.dto.HospitalResponseDto;
import com.demo.hospitalManagement.exception.ResourceNotFoundException;
import com.demo.hospitalManagement.service.HospitalService;

@RestController
public class HospitalController {
	@Autowired
	HospitalService hospitalService;

	@GetMapping("/hospitals/location")
	public ResponseEntity<List<HospitalResponseDto>> getHospitalsByLocation(@RequestParam("location") String location) {
		List<HospitalResponseDto> hospitalList = hospitalService.getHospitalsByLocation(location);
		if (hospitalList.isEmpty())
			throw new ResourceNotFoundException("No hospitals nearBy", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<HospitalResponseDto>>(hospitalList, HttpStatus.OK);
	}

	@PostMapping("/hospitals")
	public ResponseEntity<List<HospitalDto>> getHospitalsByDepartment(
			@RequestBody HospitalRequestDto hospitalRequestDto) {
		List<HospitalDto> hospitalList = hospitalService
				.getHospitalsByDepartment(hospitalRequestDto.getDepartmentName());
		if (hospitalList.isEmpty())
			throw new ResourceNotFoundException("No hospitals available", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<HospitalDto>>(hospitalList, HttpStatus.OK);
	}

}
