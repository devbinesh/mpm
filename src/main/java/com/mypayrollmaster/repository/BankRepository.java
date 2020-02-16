package com.mypayrollmaster.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mypayrollmaster.model.Bank; 
@Repository
public interface BankRepository extends PagingAndSortingRepository<Bank, Long> {

	public Page<Bank> findAllByStatus(Integer status,Pageable page);
	@Modifying
	@Query("delete from Bank where id in ?1")
	public void deleteAllByIds(List<Long> ids);
	 
}
