package com.demo.hospitalManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Generates table with doctorId,doctorName,experience,departmentName,
 * hospitalId,status.timings and patientsToBeAttended
 * @author 91970
 *
 */
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long doctorId;
	private String doctorName;
	private int experience;
	private String departmentName;
	private Long hospitalId;
	private String status;
	private String timings;
	private int patientsToBeAttended;
	public int getPatientsToBeAttended() {
		return patientsToBeAttended;
	}
	public void setPatientsToBeAttended(int patientsToBeAttended) {
		this.patientsToBeAttended = patientsToBeAttended;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}


}
