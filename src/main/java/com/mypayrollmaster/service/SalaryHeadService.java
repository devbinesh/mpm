package com.mypayrollmaster.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mypayrollmaster.dto.ListResponse;
import com.mypayrollmaster.dto.Response;
import com.mypayrollmaster.dto.SalaryHeadItemDto;
import com.mypayrollmaster.exception.DataSaveException;
import com.mypayrollmaster.model.Bank;
import com.mypayrollmaster.model.Department;
import com.mypayrollmaster.model.LeavePolicy;
import com.mypayrollmaster.model.LeavePolicyGroup;
import com.mypayrollmaster.model.SalaryHead;
import com.mypayrollmaster.model.SalaryHeadItems;
import com.mypayrollmaster.model.TaxSalaryComponent;
import com.mypayrollmaster.repository.BankRepository;
import com.mypayrollmaster.repository.DepartmentRepository;
import com.mypayrollmaster.repository.LeavePolicyGroupRepository;
import com.mypayrollmaster.repository.LeavePolicyRepository;
import com.mypayrollmaster.repository.SalaryHeadItemRepository;
import com.mypayrollmaster.repository.SalaryHeadRepository;

@Service
public class SalaryHeadService {
	@Autowired
	SalaryHeadRepository shRepo;
	@Autowired
	SalaryHeadItemRepository shItemRepo;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	public  Optional<SalaryHead> getSalaryHead(Long id) {
		return shRepo.findById(id);
	}
	
	public void save(SalaryHead salaryHead) throws DataSaveException  {
	 
		 if(!shRepo.existByNameNotEqualsIdAndStatusEquals("Heads for Monthly Earnings",salaryHead.getId())) {
			 if(salaryHead.getId() == null || salaryHead.getId() == 0) {
			 
				 salaryHead.setStatus(1);
				 salaryHead.setSalaryHeadOrder1(1);
			 }
		   shRepo.save(salaryHead);
	 
		 }else {
			throw new DataSaveException("Salary Head Exists");
		 }
	}
	@Transactional
	public void delete(List<Long> dept) {
		shRepo.deleteAllByIds(dept);
	}
	public ListResponse<SalaryHead> list(Pageable  page) {
		Page<SalaryHead> listOfLP = shRepo.findAllByStatus(1, page);
		//listOfBr.stream().
		ListResponse<SalaryHead> list = new ListResponse<>();
		list.setTotalCount(listOfLP.getTotalElements());
		list.setData(listOfLP);
		return list;
		
	}
	
	public ListResponse<SalaryHeadItems> salaryHeadItemList(Long salaryHead,Pageable  page) {

		Page<SalaryHeadItems> listOfLP = shItemRepo.findAllBySalaryHeadId(salaryHead,page);
		
		 
		logger.info( " --- "+shRepo.existByNameNotEqualsIdAndStatusEquals("Heads for Monthly Earnings", 1L));
		List<TaxSalaryComponent> taxSalComp =  shItemRepo.getTaxSalaryComponents();
		
		 
		listOfLP.forEach(shi->{
			
			boolean isFound = taxSalComp.stream().anyMatch(
					tsc->{
						final Long shiID = shi.getId();
						return	shiID.equals(tsc.getSalaryHeadItemFKey() );
					} );
			shi.setTaxSalaryComponent(isFound);
			 
		});
		
		//listOfBr.stream().
		ListResponse<SalaryHeadItems> list = new ListResponse<>();
		list.setTotalCount(listOfLP.getTotalElements());
		list.setData(listOfLP);
		return list;
		
	}
	
	 @Transactional
	public void selectItems(List<SalaryHeadItems> salaryHeadItems) {
			shItemRepo.saveAll(salaryHeadItems);
	}	 
	public void deleteItems(List<Long> items) {
		shItemRepo.deleteAllByIds(items);
	}
}
