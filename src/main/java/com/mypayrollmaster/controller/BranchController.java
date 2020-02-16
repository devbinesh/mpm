package com.mypayrollmaster.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mypayrollmaster.dto.BranchDto;
import com.mypayrollmaster.dto.ListResponse;
import com.mypayrollmaster.dto.Response;
import com.mypayrollmaster.model.Branch;
import com.mypayrollmaster.model.FinancialYear;
import com.mypayrollmaster.model.AccountUser;
import com.mypayrollmaster.repository.BranchRepository;
import com.mypayrollmaster.repository.FinancialYearRepository;
import com.mypayrollmaster.security.AccountUserDetails; 
import com.mypayrollmaster.utils.AuthUtils;
import com.mypayrollmaster.utils.DateUtils;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

	@Autowired
	BranchRepository brRepo;
	@Autowired
	FinancialYearRepository fyRepo;

	Logger log = LoggerFactory.getLogger(getClass());
	 
	 
	@GetMapping("/list")
	public ResponseEntity<ListResponse<BranchDto>> list( @RequestParam(required = false,defaultValue = "0") Integer pageNo,
            @RequestParam(required = false,defaultValue = "100") Integer pageSize,
            @RequestParam(required = false, defaultValue = "branchName") String sortBy) {
		
		   Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			 
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		Page<BranchDto>  listOfBr = brRepo.findAllByStatus(1,paging);
	 
		 
		ListResponse<BranchDto> list = new ListResponse<>();
		list.setTotalCount(listOfBr.getTotalElements());
		list.setData(listOfBr);
	
	 	 
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/load/{id}")
	public ResponseEntity<Branch> load(@PathVariable Long id) {
	   Optional<Branch> optBranch =	brRepo.findById(id);
	   if(optBranch.isPresent()) {
		   return new ResponseEntity<Branch>(optBranch.get(), HttpStatus.OK);
	   }else {
		   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   }
	}
	@PostMapping
	public ResponseEntity<String> save(@Valid BranchDto branch,Authentication auth){

		 
		
		 AccountUserDetails user = (AccountUserDetails)auth.getPrincipal();
		 Optional<Branch> optBranch =	brRepo.findById(branch.getId());
		 Branch branchToSave = optBranch.orElseGet(()->{
			 Branch newBranch = new Branch();
			 BeanUtils.copyProperties(branch, newBranch);
			 newBranch.setStatus(1);
			 newBranch.setDeleted(0);
			 return newBranch;
		 });
		
		 if(!optBranch.isPresent()) {
		   String branchCode = 	branch.getBranchName().substring(0, Math.min(branch.getBranchName().length(), 3))+System.currentTimeMillis();
		   branchToSave.setBranchCode(branchCode);
		   branchToSave.setCompanyCode(user.getTenant());
		   
		}
		
		 
		 try {
				Calendar calendarForFinYear = Calendar.getInstance();
				calendarForFinYear.setTime(DateUtils.convertStringToDate(branch.getFinancialYearStart()) );
				
				Calendar calendarForLeave = Calendar.getInstance();
				calendarForLeave.setTime(DateUtils.convertStringToDate(branch.getLeaveYearStart())  );
				
			 
						
						//fyRepo.findByisCurrentFinyearAndBranchCode(isCurrentFinyear, branchCode)
						Optional<FinancialYear> finYearOpt = fyRepo.findByBranchCode(branch.getBranchCode(), 1);
						Optional<FinancialYear> leaveYearOpt = fyRepo.findByBranchCode(branch.getBranchCode(), 0);
						
						FinancialYear finYear = finYearOpt.orElseGet(()->{
							FinancialYear newFinYear = new FinancialYear();
							newFinYear.setBranchCode(branchToSave.getBranchCode());
							newFinYear.setCompanyCode(user.getTenant());
							newFinYear.setIsCurrentFinyear("Y");
							newFinYear.setStatus(1);
							newFinYear.setVattr1(1);
							newFinYear.setYearStatus("OPEN");
							return newFinYear;
							
						});
						
						finYear.setFinYear(calendarForLeave.get(Calendar.YEAR));
						finYear.setStartMonth(DateUtils.convertStringToDate(branch.getFinancialYearStart()));
						finYear.setEndMonth(DateUtils.convertStringToDate(branch.getFinancialYearEnd()));
						
						fyRepo.save(finYear);
						
						
						FinancialYear leaveYear = finYearOpt.orElseGet(()->{
							FinancialYear newLeaveYear = new FinancialYear();
							newLeaveYear.setBranchCode(branchToSave.getBranchCode());
							newLeaveYear.setCompanyCode(user.getTenant());
							newLeaveYear.setVattr1(0);
							newLeaveYear.setIsCurrentFinyear("Y");
							newLeaveYear.setStatus(1);
							newLeaveYear.setYearStatus("OPEN");
							return newLeaveYear;
							
						});
						
						leaveYear.setFinYear(calendarForLeave.get(Calendar.YEAR));
						leaveYear.setStartMonth(DateUtils.convertStringToDate(branch.getLeaveYearStart()));
						leaveYear.setEndMonth(DateUtils.convertStringToDate(branch.getLeaveYearEnd()));
						
						fyRepo.save(leaveYear);
						
						
						
						//brRepo.save(persistedBranch);
				 
		   }
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return ResponseEntity.ok("Saved Successfully");
	}
	
	@DeleteMapping
	public ResponseEntity<Response> delete(@RequestParam("id") Long branchId){
		brRepo.deleteById(branchId);
		return ResponseEntity.ok(Response.build().setMessage("Deleted Successfully").setSuccess(true));
	}
}
