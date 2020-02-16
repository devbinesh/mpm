package com.mypayrollmaster.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
 
import com.mypayrollmaster.model.LeavePolicyGroup;
import com.mypayrollmaster.model.SalaryHead;
import com.mypayrollmaster.model.SalaryHeadItems;
import com.mypayrollmaster.model.TaxSalaryComponent; 
@Repository
public interface SalaryHeadItemRepository extends PagingAndSortingRepository<SalaryHeadItems, Long> {
	// @Query(value = "SELECT shi  FROM SalaryHeadItems shi WHERE status = 1 AND head_fkey = ?1 ")
	Page<SalaryHeadItems> findAllBySalaryHeadId(Long shFkey,Pageable pageable);
	@Modifying
	@Query("UPDATE  SalaryHeadItems SET value = 'N' WHERE id IN ?1")
	public void deleteAllByIds(List<Long> ids);
	 
	@Query(value = "SELECT tsc  FROM TaxSalaryComponent tsc WHERE status = 1 ")
	public List<TaxSalaryComponent> getTaxSalaryComponents();
}
