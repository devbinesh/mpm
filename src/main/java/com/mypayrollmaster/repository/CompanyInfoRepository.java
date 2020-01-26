package com.mypayrollmaster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mypayrollmaster.model.CompanyContactInfo;

@Repository
public interface CompanyInfoRepository extends CrudRepository<CompanyContactInfo, Long> {

	 
}
