package com.demo.hospitalManagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.hospitalManagement.model.Patient;
@Repository
public interface PatientDao extends CrudRepository<Patient, Long>{

}
