package com.demo.hospitalManagement.service;

import java.util.List;

import com.demo.hospitalManagement.dto.HospitalDto;
import com.demo.hospitalManagement.dto.HospitalResponseDto;

public interface HospitalService {

	/**
	 * @author Lahari
	 * This method is used to get the list of hospital details by location 
	 * @param location
	 * @return list of HospitalResponseDto
	 */
	public List<HospitalResponseDto> getHospitalsByLocation(String location);

	/**
	 * @author Suma
	 * This method is used to get the list of hospitalDto by departmentName
	 * @param departmentName
	 * @return list of HospitalDto
	 */
	public List<HospitalDto> getHospitalsByDepartment(String departmentName);
}
