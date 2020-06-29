package com.demo.hospitalManagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.hospitalManagement.model.Appointment;

@Repository
public interface AppointmentDao extends CrudRepository<Appointment, Long>{
	
	

}
