package com.demo.hospitalManagement.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hospitalManagement.dao.BookingDao;
import com.demo.hospitalManagement.dao.DoctorDao;
import com.demo.hospitalManagement.dao.HospitalDao;
import com.demo.hospitalManagement.dao.PatientDao;
import com.demo.hospitalManagement.dao.UserDao;
import com.demo.hospitalManagement.dto.BookingRequestDto;
import com.demo.hospitalManagement.dto.BookingResponseDto;
import com.demo.hospitalManagement.model.Booking;
import com.demo.hospitalManagement.model.Doctor;
import com.demo.hospitalManagement.model.Hospital;
import com.demo.hospitalManagement.model.Patient;
import com.demo.hospitalManagement.model.User;
import com.demo.hospitalManagement.service.BookingService;
import com.demo.hospitalManagement.service.DoctorService;

/**
 * @author Grandhe Suma
 *
 */
@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	UserDao userDao;
	@Autowired
	HospitalDao hospitalDao;
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	PatientDao patientDao;
	@Autowired
	BookingDao bookingDao;
	@Autowired
	DoctorService doctorService;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BookingResponseDto bookAnAppointment(BookingRequestDto bookingRequestDto, Long userId) {
		Booking booking = new Booking();
		Patient patient = new Patient();

		Optional<User> user = userDao.findByUserId(userId);
		if (!user.isPresent()) 
			return new BookingResponseDto("User details are incorrect");
					String status = "available";
					Optional<Doctor> doctor = doctorDao.findByDoctorIdAndStatus(
							bookingRequestDto.getDoctorId(), status);
					if (!doctor.isPresent()) 
						return new BookingResponseDto("DoctorName and Doctor qualification doesnot match");
						Optional<Booking> bookingOptional = bookingDao
								.findByAppointmentDateAndAppointmentTimeAndDoctorId(
										LocalDate.parse(bookingRequestDto.getAppointmentDate()),
										LocalTime.parse(bookingRequestDto.getAppointmentTime()),
										doctor.get().getDoctorId());
						if (bookingOptional.isPresent()) 
							return new BookingResponseDto("Requested slot is busy"); 
						Optional<Hospital> hospital = hospitalDao.findByHospitalId(doctor.get().getHospitalId());	
							patient.setPatientName(bookingRequestDto.getPatientName());
							patient.setAge(bookingRequestDto.getAge());
							patient.setGender(bookingRequestDto.getGender());
							patient.setUserId(userId);
							patientDao.save(patient);
							booking.setUserId(patient.getUserId());
							LocalDate date = LocalDate.parse(bookingRequestDto.getAppointmentDate());
							System.out.println(date);
							booking.setAppointmentDate(date);
							LocalTime time = LocalTime.parse(bookingRequestDto.getAppointmentTime());
							System.out.println(time);
							booking.setAppointmentTime(time);
							booking.setDoctorId(doctor.get().getDoctorId());
							booking.setHospitalId(doctor.get().getHospitalId());
							booking.setPatientId(patient.getPatientId());
							bookingDao.save(booking);
							BookingResponseDto bookingResponseDto = new BookingResponseDto();
							bookingResponseDto.setDoctorName(doctor.get().getDoctorName());
							bookingResponseDto.setHospitalName(hospital.get().getHospitalName());
							bookingResponseDto.setAppointmentTime(booking.getAppointmentTime());
							bookingResponseDto.setPatientName(patient.getPatientName());
							bookingResponseDto.setAppointmentDate(date);
							bookingResponseDto.setAppointmentTime(time);
							BeanUtils.copyProperties(booking, bookingResponseDto);
							bookingResponseDto.setMessage("Your appointment is confirmed ");
							return bookingResponseDto;
						
	}
	
	
	
	
	
}

	
	