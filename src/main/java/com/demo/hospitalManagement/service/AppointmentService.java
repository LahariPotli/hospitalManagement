package com.demo.hospitalManagement.service;

import com.demo.hospitalManagement.dto.AppointmentRequestDto;
import com.demo.hospitalManagement.dto.AppointmentResponseDto;

/**
 * @author Suma
 *
 */
public interface AppointmentService {
	
	/**
	 * This method is used to book an appointment
	 * @param appointmentRequestDto
	 * @param userId
	 * @return appointmentResponseDto
	 */
	public AppointmentResponseDto bookAnAppointment(AppointmentRequestDto appointmentRequestDto,Long userId);
	

}
