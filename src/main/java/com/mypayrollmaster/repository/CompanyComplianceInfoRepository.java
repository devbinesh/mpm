package com.mypayrollmaster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mypayrollmaster.model.CompanyContactInfo;
import com.mypayrollmaster.model.ComplianceInfo;

@Repository
public interface CompanyComplianceInfoRepository extends CrudRepository<ComplianceInfo, Long> {

	 
}
