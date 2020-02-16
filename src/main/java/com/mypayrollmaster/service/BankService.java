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
import com.mypayrollmaster.model.Bank;
import com.mypayrollmaster.model.Department;
import com.mypayrollmaster.repository.BankRepository;
import com.mypayrollmaster.repository.DepartmentRepository;

@Service
public class BankService {
	@Autowired
	BankRepository bankRepo;
	
	public  Optional<Bank> get(Long id) {
		return bankRepo.findById(id);
	}
	public void save(Bank bank)  {
	 
		 
		if(bank.getId() == null || bank.getId() == 0) {
			bank.setStatus(1);
		}
		bankRepo.save(bank);
		  
	}
	@Transactional
	public void delete(List<Long> dept) {
		bankRepo.deleteAllByIds(dept);
	}
	public ListResponse<Bank> list(Pageable  page) {
		Page<Bank> listOfBr = bankRepo.findAllByStatus(1, page);
		ListResponse<Bank> list = new ListResponse<>();
		list.setTotalCount(listOfBr.getTotalElements());
		list.setData(listOfBr);
		return list;
		
	}
}
