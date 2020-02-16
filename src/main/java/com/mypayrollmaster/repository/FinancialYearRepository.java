package com.mypayrollmaster.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mypayrollmaster.model.Branch;
import com.mypayrollmaster.model.FinancialYear; 
@Repository
public interface FinancialYearRepository extends CrudRepository<FinancialYear, Long>{
	Page<FinancialYear> findAllByStatus(Integer active,Pageable page);
	@Query("select fy from FinancialYear fy where fy.branchCode = :branchcode and fy.isCurrentFinyear = 'Y'  and fy.vattr1 = :vattr1 and fy.status = '1'")
	Optional<FinancialYear> findByBranchCode(@Param("branchcode") String branchcode, @Param("vattr1") Integer vattr1);
	FinancialYear findByIsCurrentFinyearAndBranchCode(String isCurrentFinyear,String branchCode);
}
