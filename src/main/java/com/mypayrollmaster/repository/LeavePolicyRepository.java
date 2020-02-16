package com.mypayrollmaster.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mypayrollmaster.model.Bank;
import com.mypayrollmaster.model.LeavePolicy;
import com.mypayrollmaster.model.LeavePolicyGroup; 
@Repository
public interface LeavePolicyRepository extends PagingAndSortingRepository<LeavePolicy, Long> {


	Page<LeavePolicy> findAllByStatus(Integer status,Pageable pageable);
	
	@Modifying
	@Query("UPDATE  LeavePolicy SET status = 0 WHERE id IN ?1")
	public void deleteAllByIds(List<Long> ids);
	 
}
