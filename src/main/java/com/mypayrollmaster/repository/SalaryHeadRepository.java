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
import com.mypayrollmaster.model.TaxSalaryComponent; 
@Repository
public interface SalaryHeadRepository extends PagingAndSortingRepository<SalaryHead, Long> {

	Page<SalaryHead> findAllByStatus(Integer status,Pageable pageable);
	@Modifying
	@Query("UPDATE  SalaryHead SET status = 0 WHERE id IN ?1")
	public void deleteAllByIds(List<Long> ids);
	@Query("select case when count(c)> 0 then true else false end from SalaryHead c where  headDesc = ?1 AND status = 1 AND id = ?2 ")
	public boolean existByNameNotEqualsIdAndStatusEquals(String name,Long id );
}
