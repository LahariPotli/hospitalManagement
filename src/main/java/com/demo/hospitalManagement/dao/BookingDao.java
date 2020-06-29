package com.demo.hospitalManagement.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.hospitalManagement.model.Booking;

/**
 * 
 * @author Grandhe Suma
 *
 */
@Repository
public interface BookingDao extends CrudRepository<Booking, Long> {

	/**
	 * This method is used to verify the availability of booking slot
	 * 
	 * @param appointmentDate
	 * @param localTime
	 * @param doctorId
	 * @return Booking
	 */
	Optional<Booking> findByAppointmentDateAndAppointmentTimeAndDoctorId(LocalDate appointmentDate, LocalTime localTime,
			Long doctorId);
}
