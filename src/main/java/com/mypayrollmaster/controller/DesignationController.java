package com.mypayrollmaster.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mypayrollmaster.dto.BranchDto;
import com.mypayrollmaster.dto.ListResponse;
import com.mypayrollmaster.dto.Response;
import com.mypayrollmaster.model.Branch;
import com.mypayrollmaster.model.Department;
import com.mypayrollmaster.model.Designation;
import com.mypayrollmaster.repository.DepartmentRepository;
import com.mypayrollmaster.service.DepartmentService;
import com.mypayrollmaster.service.DesignationService;

@RestController
@RequestMapping("/api/designation")
public class DesignationController {
 
	@Autowired
	DesignationService service;
	
	@GetMapping("/list")
	public ResponseEntity<ListResponse<Designation>> list( @RequestParam(required = false,defaultValue = "0") Integer pageNo,
            @RequestParam(required = false,defaultValue = "100") Integer pageSize,
            @RequestParam(required = false, defaultValue = "designationName") String sortBy) {
		
		   Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			 
	  
	 	 
		return ResponseEntity.ok(service.list(paging));
	}
	@GetMapping("/load/{id}")
	public ResponseEntity<Designation> load(@PathVariable Long id) {
		Optional<Designation> department = service.get(id);
		 
		return ResponseEntity.ok(department.orElse(new Designation()));
	}
	@PostMapping
	public ResponseEntity<Response> save(@Valid Designation department,Authentication auth){

		Response resp = Response.build();
		try {
			service.save(department);
			resp.setMessage("Saved successfully");
			resp.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setSuccess(true);
			 
			// TODO Auto-generated catch block
			
		}
		
		return  ResponseEntity.ok(resp);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> delete(@MatrixVariable(name = "id",pathVar = "id") List<Long> branchId){

		Response resp = Response.build();
		service.delete(branchId);
		resp.setMessage("Deleted successfully");
		resp.setSuccess(true);
		return  ResponseEntity.ok(resp);
	}
	
}
