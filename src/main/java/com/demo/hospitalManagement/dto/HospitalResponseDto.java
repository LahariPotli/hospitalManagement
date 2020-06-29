package com.demo.hospitalManagement.dto;

public class HospitalResponseDto {

	private Long hospitalId;
    private String hospitalName;
    private String address;
    private String location;
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}