package com.demo.hospitalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hospitalManagement.dto.AppointmentRequestDto;
import com.demo.hospitalManagement.dto.AppointmentResponseDto;
import com.demo.hospitalManagement.exception.ResourceNotFoundException;
import com.demo.hospitalManagement.service.AppointmentService;

@RestController
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;

	@PostMapping("/appointments/{userId}")
	public ResponseEntity<AppointmentResponseDto> bookAnAppointment(
			@RequestBody AppointmentRequestDto appointmentRequestDto, @PathVariable("userId") Long userId) {
		AppointmentResponseDto appointmentResponseDto = appointmentService.bookAnAppointment(appointmentRequestDto,
				userId);
		if (appointmentResponseDto.getMessage().equalsIgnoreCase("DoctorName and Doctor qualification doesnot match"))
			throw new ResourceNotFoundException("Please verify doctor details", HttpStatus.NOT_FOUND);
		if (appointmentResponseDto.getMessage().equalsIgnoreCase("Please verify hospital details"))
			throw new ResourceNotFoundException("Please verify hospital details", HttpStatus.NOT_FOUND);
		if (appointmentResponseDto.getMessage().equalsIgnoreCase("User details are incorrect"))
			throw new ResourceNotFoundException("User details are incorrect", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<AppointmentResponseDto>(appointmentResponseDto, HttpStatus.OK);

	}

}
