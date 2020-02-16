package com.mypayrollmaster.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mypayrollmaster.dto.ListResponse;
import com.mypayrollmaster.dto.Response;
import com.mypayrollmaster.model.Department;
import com.mypayrollmaster.model.Designation;
import com.mypayrollmaster.repository.DepartmentRepository;
import com.mypayrollmaster.repository.DesignationRepository;

@Service
public class DesignationService {
	@Autowired
	DesignationRepository desRepo;
	
	public  Optional<Designation> get(Long id) {
		return desRepo.findById(id);
	}
	public void save(Designation des) throws Exception {
	 
		if(desRepo.existsByDesignationCode(des.getDesignationCode()) ) {
			throw new Exception("Designation Code is already existing");
		 
		}else if(desRepo.existsByDesignationName(des.getDesignationName()))
		{
			throw new Exception("Designation Name is already existing");
			 
			
		}
		if(des.getId() == null || des.getId() == 0) {
			des.setStatus(1);
		}
		desRepo.save(des);
		  
	}
	@Transactional
	public void delete(List<Long> dept) {
		desRepo.deleteAllByIds(dept);
	}
	public ListResponse<Designation> list(Pageable  page) {
		Page<Designation> listOfBr = desRepo.findAllByStatus(1, page);
		ListResponse<Designation> list = new ListResponse<>();
		list.setTotalCount(listOfBr.getTotalElements());
		list.setData(listOfBr);
		return list;
		
	}
}
