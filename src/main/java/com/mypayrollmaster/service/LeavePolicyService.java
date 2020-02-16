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
import com.mypayrollmaster.model.LeavePolicy;
import com.mypayrollmaster.model.LeavePolicyGroup;
import com.mypayrollmaster.repository.BankRepository;
import com.mypayrollmaster.repository.DepartmentRepository;
import com.mypayrollmaster.repository.LeavePolicyGroupRepository;
import com.mypayrollmaster.repository.LeavePolicyRepository;

@Service
public class LeavePolicyService {
	@Autowired
	LeavePolicyRepository leavePolicyRepo;
	@Autowired
	LeavePolicyGroupRepository leavePolicyGrpRepo;
	
	public  Optional<LeavePolicy> get(Long id) {
		return leavePolicyRepo.findById(id);
	}
	
	public void save(LeavePolicy leavePolciy)  {
	 
		 
		if(leavePolciy.getId() == null || leavePolciy.getId() == 0) {
			leavePolciy.setStatus(1);
		}
		leavePolicyRepo.save(leavePolciy);
		  
	}
	@Transactional
	public void delete(List<Long> dept) {
		leavePolicyRepo.deleteAllByIds(dept);
	}
	public ListResponse<LeavePolicy> list(Pageable  page) {
		Page<LeavePolicy> listOfLP = leavePolicyRepo.findAll(page);
		//listOfBr.stream().
		ListResponse<LeavePolicy> list = new ListResponse<>();
		list.setTotalCount(listOfLP.getTotalElements());
		list.setData(listOfLP);
		return list;
		
	}
	
	public ListResponse<LeavePolicyGroup> listLeavePolicyGroup(Pageable  page) {
		Page<LeavePolicyGroup> listOfLPG = leavePolicyGrpRepo.findAll(page);
		 
		ListResponse<LeavePolicyGroup> list = new ListResponse<>();
		list.setTotalCount(listOfLPG.getTotalElements());
		list.setData(listOfLPG);
		return list;
		
	}
	public  Optional<LeavePolicyGroup> getLeavePolicyGroup(Long id) {
		return leavePolicyGrpRepo.findById(id);
	}
	
	public void deleteLeavePolicyGroup(List<Long> dept) {
		leavePolicyGrpRepo.deleteAllByIds(dept);
	}
	public void saveLeavePolicyGroup(LeavePolicyGroup leavePolciyGrp)  {
		 
		 
		if(leavePolciyGrp.getId() == null || leavePolciyGrp.getId() == 0) {
			leavePolciyGrp.setStatus(1);
		}
		leavePolicyGrpRepo.save(leavePolciyGrp);
		  
	}
}
