package com.demo.hospitalManagement.service;

import java.util.List;

import com.demo.hospitalManagement.dto.DoctorDto;
import com.demo.hospitalManagement.dto.DoctorResponseDto;

/**
 * @author Haritha,Suma
 *
 */
public interface DoctorService {

	/**
	 * Haritha
	 * This method is used to get the list of doctor details by departmentName
	 * @param departmentName
	 * @return list of DoctorResponseDto
	 */
	public List<DoctorResponseDto> getDoctorsByDepartmentName(String departmentName);

	/**
	 * @author Suma
	 * This method is used to get the list of DoctorDto details by hospitalId 
	 * @param hospitalId
	 * @return list of DoctorDto
	 */
	public List<DoctorDto> getAllDoctorsByHospitalId(Long hospitalId);

}
