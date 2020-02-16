package com.mypayrollmaster.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

@Entity
@Table(name = "leavepolicy_group")
public class LeavePolicyGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LEAVEPOLICY_GROUP_ID")
	private Long id;
	
	@Column(name = "COMPANY_CODE")
	private String companyCode;
	@Column(name = "BRANCH_CODE")	
	private String branchCode;
	@Column(name = "LEAVEPOLICY_GROUP_NAME")	
	private String leavePolicyGroupName;
	private Integer status;
	
	@OneToMany
	@JoinColumn(name = "LEAVEPOLICY_GROUP_ID")
	@JsonIgnore
	private Set<LeavePolicy> leavePolicies;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	 
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getLeavePolicyGroupName() {
		return leavePolicyGroupName;
	}
	public void setLeavePolicyGroupName(String leavePolicyGroupName) {
		this.leavePolicyGroupName = leavePolicyGroupName;
	}
	public Set<LeavePolicy> getLeavePolicies() {
		return leavePolicies;
	}
	public void setLeavePolicies(Set<LeavePolicy> leavePolicies) {
		this.leavePolicies = leavePolicies;
	}
	
	
	 
}
