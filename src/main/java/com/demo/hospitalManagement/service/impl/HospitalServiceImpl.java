package com.demo.hospitalManagement.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hospitalManagement.dao.DoctorDao;
import com.demo.hospitalManagement.dao.HospitalDao;
import com.demo.hospitalManagement.dto.HospitalDto;
import com.demo.hospitalManagement.dto.HospitalResponseDto;
import com.demo.hospitalManagement.model.Doctor;
import com.demo.hospitalManagement.model.Hospital;
import com.demo.hospitalManagement.service.HospitalService;
@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
    HospitalDao hospitalDao;
	@Autowired
	DoctorDao doctorDao;
	/**
	 * {@inheritDoc}
	 */
    @Override
    public List<HospitalResponseDto> getHospitalsByLocation(String location) {
        List<HospitalResponseDto> responseList = new ArrayList<HospitalResponseDto>();
        Optional<List<Hospital>> hospitalsOptional = hospitalDao.getHospitalsByLocation(location);
        if (hospitalsOptional.isPresent())
            return hospitalsOptional.get().stream().map(hospital -> getHospitalResponseDto(hospital))
                    .collect(Collectors.toList());
        else {
        return responseList;
        }
    }
    private HospitalResponseDto getHospitalResponseDto(Hospital hospital)
    {
        HospitalResponseDto hospitalResponseDto = new HospitalResponseDto();
        BeanUtils.copyProperties(hospital, hospitalResponseDto);
        
       
        return hospitalResponseDto;
    }
    /**
	 * {@inheritDoc}
	 */
	@Override
	public List<HospitalDto> getHospitalsByDepartment(String departmentName) {
		List<HospitalDto> hospitalList = new ArrayList<HospitalDto>();
		String status = "available";
		Optional<List<Doctor>> doctorList = doctorDao.getDoctorsByDepartmentNameContainingAndStatus(departmentName,status);
		if(doctorList.isPresent())
		{
		List<Long> hospitalIdList = doctorList.get().stream().map(doctor->getHospitalId(doctor)).collect(Collectors.toList());
	
		hospitalList = HospitalServiceImpl.getUniqueIdList(hospitalIdList).stream().map(id->getHospital(id)).collect(Collectors.toList());
		return hospitalList;
		}
		else return hospitalList;
		 
	}
    
	private Long getHospitalId( Doctor doctor)
	{
		Long id = doctor.getHospitalId() ;
		return id;
	}
	
	private HospitalDto getHospital(Long id)
	{
		Optional<Hospital> hospital = hospitalDao.findByHospitalId(id);
			HospitalDto hospitalDto = new HospitalDto();
			BeanUtils.copyProperties(hospital.get(), hospitalDto);
			return hospitalDto;
		}
	
	private static List<Long> getUniqueIdList(List<Long> hospitalIdList)
	{
		Set<Long> idSet = new HashSet<Long>(hospitalIdList);
		List<Long> idList = new ArrayList<>();
		for(Long i : idSet)
		idList.add(i);
		return idList;
	}
	}
	
