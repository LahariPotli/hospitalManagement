package com.demo.hospitalManagement.service;

import com.demo.hospitalManagement.dto.BookingRequestDto;
import com.demo.hospitalManagement.dto.BookingResponseDto;

/**
 * @author Suma
 *
 */
public interface BookingService {

	/**
	 * This method is used for an appointment
	 * 
	 * @param bookingRequestDto
	 * @param userId
	 * @return BookingResponseDto
	 */
	public BookingResponseDto bookAnAppointment(BookingRequestDto bookingRequestDto, Long userId);

}
