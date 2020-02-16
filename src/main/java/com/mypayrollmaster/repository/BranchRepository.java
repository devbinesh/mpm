package com.mypayrollmaster.repository;
 
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mypayrollmaster.dto.BranchDto;
import com.mypayrollmaster.model.Branch; 
@Repository 
public interface BranchRepository extends PagingAndSortingRepository<Branch, Long>{
	
	@Query("SELECT new com.mypayrollmaster.dto.BranchDto(b.id,b.branchCode,b.branchName,b.address,b.city,b.state,b.pincode,fy.startMonth,fy.endMonth,ly.startMonth,ly.endMonth)  FROM Branch b  LEFT JOIN FinancialYear fy ON b.branchCode = fy.branchCode AND fy.vattr1 = 0 AND fy.isCurrentFinyear='Y'  AND fy.yearStatus='OPEN' AND fy.status=1 LEFT JOIN FinancialYear ly ON b.branchCode = ly.branchCode AND ly.vattr1 = 1 AND ly.isCurrentFinyear='Y'  AND ly.yearStatus='OPEN' AND ly.status=1 WHERE b.status = ?1 ")
	Page<BranchDto> findAllByStatus(Integer status,Pageable pageable);
	
	//@Query("SELECT new com.mypayrollmaster.dto.BranchDto(b.id,b.branchCode,b.branchName,b.address,b.city,b.state,b.pincode,fy.startMonth,fy.endMonth,ly.startMonth,ly.endMonth)  FROM Branch b  LEFT JOIN FinancialYear fy ON b.branchCode = fy.branchCode AND fy.vattr1 = 0 AND fy.isCurrentFinyear='Y'  AND fy.yearStatus='OPEN' AND fy.status=1 LEFT JOIN FinancialYear ly ON b.branchCode = ly.branchCode AND ly.vattr1 = 1 AND ly.isCurrentFinyear='Y'  AND ly.yearStatus='OPEN' AND ly.status=1 WHERE b.id = ?1 ")
	//BranchDto findById(Long id);
}
