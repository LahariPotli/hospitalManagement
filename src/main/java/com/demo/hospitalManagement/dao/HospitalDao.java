package com.demo.hospitalManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.hospitalManagement.model.Hospital;

/**
 * @author Lahari,Haritha
 *
 */
@Repository
public interface HospitalDao extends CrudRepository<Hospital, Long> {

	/**
	 * This method is used to find Hospital by hospitalName
	 * @param hospitalName
	 * @return hospital
	 */
	Optional<Hospital> findByHospitalName(String hospitalName);

	/**
	 * This method is used to get hospitals by location
	 * 
	 * @param location
	 * @return list of hospitals
	 */
	@Query(value = "select * from hospital h where h.location like %:location%", nativeQuery = true)
	Optional<List<Hospital>> getHospitalsByLocation(@Param("location") String location);

	/**
	 * This method is used to find hospital by hospitalId
	 * 
	 * @param hospitalId
	 * @return hospital
	 */
	Optional<Hospital> findByHospitalId(Long hospitalId);
}