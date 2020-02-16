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
import com.mypayrollmaster.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository depRepo;
	
	public  Optional<Department> get(Long id) {
		return depRepo.findById(id);
	}
	public void save(Department dept) throws Exception {
	 
		if(depRepo.existsByDepartmentCode(dept.getDepartmentCode()) ) {
			throw new Exception("Department Code is already existing");
		 
		}else if(depRepo.existsByDepartmentName(dept.getDepartmentName()))
		{
			throw new Exception("Department Name is already existing");
			 
			
		}
		if(dept.getId() == null || dept.getId() == 0) {
			dept.setStatus(1);
		}
		depRepo.save(dept);
		  
	}
	@Transactional
	public void delete(List<Long> dept) {
		depRepo.deleteAllByIds(dept);
	}
	public ListResponse<Department> list(Pageable  page) {
		Page<Department> listOfBr = depRepo.findAllByStatus(1, page);
		ListResponse<Department> list = new ListResponse<>();
		list.setTotalCount(listOfBr.getTotalElements());
		list.setData(listOfBr);
		return list;
		
	}
}
