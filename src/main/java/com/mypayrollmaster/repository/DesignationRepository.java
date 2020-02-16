package com.mypayrollmaster.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mypayrollmaster.model.Department;
import com.mypayrollmaster.model.Designation;
@Repository
public interface DesignationRepository extends PagingAndSortingRepository<Designation, Long> {

	public Page<Designation> findAllByStatus(Integer status,Pageable page);
	@Modifying
	@Query("delete from Designation where id in ?1")
	public void deleteAllByIds(List<Long> ids);
	
	boolean existsByDesignationCode(String deptCode);
	boolean existsByDesignationName(String deptName);
}
