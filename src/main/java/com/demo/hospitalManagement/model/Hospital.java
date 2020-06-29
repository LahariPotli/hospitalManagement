package com.demo.hospitalManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Generates hospital with hospitalId,hospitalName,
 * location,hospitalType,address and contactNumber
 * @author 91970
 *
 */
@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long hospitalId;
	private String hospitalName;
	private String location;
	private String hospitalType;
	private String address;
	private Long contactNumber;
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHospitalType() {
		return hospitalType;
	}
	public void setHospitalType(String hospitalType) {
		this.hospitalType = hospitalType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	

}
