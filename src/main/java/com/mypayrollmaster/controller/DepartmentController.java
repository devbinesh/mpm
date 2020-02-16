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
import com.mypayrollmaster.repository.DepartmentRepository;
import com.mypayrollmaster.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
 
	@Autowired
	DepartmentService service;
	
	@GetMapping("/list")
	public ResponseEntity<ListResponse<Department>> list( @RequestParam(required = false,defaultValue = "0") Integer pageNo,
            @RequestParam(required = false,defaultValue = "100") Integer pageSize,
            @RequestParam(required = false, defaultValue = "departmentName") String sortBy) {
		
		   Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			 
	  
	 	 
		return ResponseEntity.ok(service.list(paging));
	}
	@GetMapping("/load/{id}")
	public ResponseEntity<Department> load(@PathVariable Long id) {
		Optional<Department> department = service.get(id);
		 
		return ResponseEntity.ok(department.orElse(new Department()));
	}
	@PostMapping
	public ResponseEntity<Response> save(@Valid Department department,Authentication auth){

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
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> delete(@MatrixVariable(name = "id",pathVar = "id") List<Long> branchId){

		Response resp = Response.build();
		service.delete(branchId);
		resp.setMessage("Deleted successfully");
		resp.setSuccess(true);
		return  ResponseEntity.ok(resp);
	}
	
}
