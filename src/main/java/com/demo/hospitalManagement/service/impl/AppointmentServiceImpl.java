package com.demo.hospitalManagement.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hospitalManagement.dao.AppointmentDao;
import com.demo.hospitalManagement.dao.DoctorDao;
import com.demo.hospitalManagement.dao.HospitalDao;
import com.demo.hospitalManagement.dao.PatientDao;
import com.demo.hospitalManagement.dao.UserDao;
import com.demo.hospitalManagement.dto.AppointmentRequestDto;
import com.demo.hospitalManagement.dto.AppointmentResponseDto;
import com.demo.hospitalManagement.model.Appointment;
import com.demo.hospitalManagement.model.Doctor;
import com.demo.hospitalManagement.model.Hospital;
import com.demo.hospitalManagement.model.Patient;
import com.demo.hospitalManagement.model.User;
import com.demo.hospitalManagement.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	HospitalDao hospitalDao;
	@Autowired
	PatientDao patientDao;
	@Autowired
	AppointmentDao appointmentDao;
	@Autowired
	UserDao userDao;

	@Override
	public AppointmentResponseDto bookAnAppointment(AppointmentRequestDto appointmentRequestDto, Long userId) {
		Appointment appointment = new Appointment();
		Patient patient = new Patient();
		Optional<User> user = userDao.findByUserId(userId);
		if (user.isPresent()) {
			Optional<Hospital> hospital = hospitalDao.findByHospitalName(appointmentRequestDto.getHospitalName());
			if (hospital.isPresent()) {
				Optional<Doctor> doctor = doctorDao.findByDoctorNameAndDepartmentNameAndHospitalId(
						appointmentRequestDto.getDoctorName(), appointmentRequestDto.getDepartmentName(),
						hospital.get().getHospitalId());
				if (doctor.isPresent()) {
					patient.setPatientName(appointmentRequestDto.getPatientName());
					patient.setAge(appointmentRequestDto.getAge());
					patient.setGender(appointmentRequestDto.getGender());
					patient.setUserId(userId);
					patientDao.save(patient);
					appointment.setUserId(patient.getUserId());
					appointment.setBookingTime(LocalDateTime.now());
					appointment.setDoctorId(doctor.get().getDoctorId());
					appointment.setHospitalId(doctor.get().getHospitalId());
					appointment.setPatientId(patient.getPatientId());
					appointmentDao.save(appointment);
					AppointmentResponseDto appointmentResponseDto = new AppointmentResponseDto();
					appointmentResponseDto.setDoctorName(doctor.get().getDoctorName());
					appointmentResponseDto.setHospitalName(hospital.get().getHospitalName());
					appointmentResponseDto.setAppointmentTime(LocalDateTime.now());
					appointmentResponseDto.setPatientName(patient.getPatientName());
					BeanUtils.copyProperties(appointment, appointmentResponseDto);
					appointmentResponseDto.setMessage("Your appointment is confirmed ");
					return appointmentResponseDto;

				} else
					return new AppointmentResponseDto("DoctorName and Doctor qualification doesnot match");
			} else
				return new AppointmentResponseDto("Please verify hospital details");
		} else
			return new AppointmentResponseDto("User details are incorrect");

	}

}
