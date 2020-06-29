package com.demo.hospitalManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.hospitalManagement.model.Doctor;

/**
 * @author Suma,Lahari
 *
 */
@Repository
public interface DoctorDao extends CrudRepository<Doctor, Long> {

	/**
	 * This method is used to get Doctor details by doctorName,departmentName and
	 * hospitalId
	 * 
	 * @param doctorName
	 * @param departmentName
	 * @param hospitalId
	 * @return doctor
	 */
	Optional<Doctor> findByDoctorNameAndDepartmentNameAndHospitalId(String doctorName, String departmentName,
			Long hospitalId);

	/**
	 * This method is used to get doctors by departmentName
	 * 
	 * @param departmentName
	 * @return list of doctors
	 */
	@Query(value = "select * from doctor d where d.department_name like %:departmentName% and d.status = ", nativeQuery = true)
	Optional<List<Doctor>> getDoctorsByDepartmentName(@Param("departmentName") String departmentName);

	/**
	 * This method is used to get doctors by departmentName and status
	 * 
	 * @param departmentName
	 * @param status
	 * @return list of doctors
	 */
	Optional<List<Doctor>> getDoctorsByDepartmentNameContainingAndStatus(String departmentName, String status);

	/**
	 * This method is used to get list of doctors byhospitalId
	 * 
	 * @param hospitalId
	 * @return List of doctors
	 */
	Optional<List<Doctor>> findAllByHospitalId(Long hospitalId);

	/**
	 * This method is used to get available doctors by
	 * doctorName,departmentName,hospitalId and status
	 * 
	 * @param doctorName
	 * @param departmentName
	 * @param hospitalId
	 * @param status
	 * @return Doctor
	 */
	Optional<Doctor> findByDoctorNameAndDepartmentNameAndHospitalIdAndStatus(String doctorName, String departmentName,
			Long hospitalId, String status);

	/**
	 * This method is used to get available doctor by doctorId
	 * 
	 * @param doctorId
	 * @param status
	 * @return Doctor
	 */
	Optional<Doctor> findByDoctorIdAndStatus(Long doctorId, String status);

}
