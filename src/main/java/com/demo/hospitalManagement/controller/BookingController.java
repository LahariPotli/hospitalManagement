package com.demo.hospitalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hospitalManagement.dto.BookingRequestDto;
import com.demo.hospitalManagement.dto.BookingResponseDto;
import com.demo.hospitalManagement.exception.ResourceNotFoundException;
import com.demo.hospitalManagement.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	BookingService bookingService;

	@PostMapping("/bookings/{userId}")
	public ResponseEntity<BookingResponseDto> bookAnAppointment(@RequestBody BookingRequestDto bookingRequestDto,
			@PathVariable("userId") Long userId) {
		BookingResponseDto bookingResponseDto = bookingService.bookAnAppointment(bookingRequestDto, userId);
		if (bookingResponseDto.getMessage().equalsIgnoreCase("DoctorName and Doctor qualification doesnot match"))
			throw new ResourceNotFoundException("Please verify doctor details", HttpStatus.NOT_FOUND);
		if (bookingResponseDto.getMessage().equalsIgnoreCase("Please verify hospital details"))
			throw new ResourceNotFoundException("Please verify hospital details", HttpStatus.NOT_FOUND);
		if (bookingResponseDto.getMessage().equalsIgnoreCase("User details are incorrect"))
			throw new ResourceNotFoundException("User details are incorrect", HttpStatus.NOT_FOUND);
		if (bookingResponseDto.getMessage().equalsIgnoreCase("Requested slot is busy"))
			throw new ResourceNotFoundException("Doctor is unavailable at this slot", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<BookingResponseDto>(bookingResponseDto, HttpStatus.OK);

	}

}