package com.demo.hospitalManagement.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingResponseDto {

	public BookingResponseDto() {
		super();
	}
	public BookingResponseDto(String message) {
		super();
		this.message = message;
	}
	private String doctorName;
	private String patientName;
	private LocalDate appointmentDate;
	private String hospitalName;
	private String message;
	private LocalTime appointmentTime;
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
}
