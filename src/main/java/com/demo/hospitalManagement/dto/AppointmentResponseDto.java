package com.demo.hospitalManagement.dto;

import java.time.LocalDateTime;

public class AppointmentResponseDto {
	
	public AppointmentResponseDto() {
		super();
	}
	public AppointmentResponseDto(String message) {
		super();
		this.message = message;
	}
	private String doctorName;
	private String patientName;
	private LocalDateTime appointmentTime;
	private String hospitalName;
	private String message;
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
	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
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
	

}
