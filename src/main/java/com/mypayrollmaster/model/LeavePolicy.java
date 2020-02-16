package com.mypayrollmaster.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

@Entity
@Table(name = "leavepolicy")
public class LeavePolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LEAVEPOLICYID")
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	private LeavePolicyGroup leavePolicyGroup;
	
	@ManyToOne
	@JoinColumn(name = "salary_head_item_fkey")
	private SalaryHeadItems salaryHead;
	 
	private Double allotedLeaveFortheYear;
	private Double allotedLeaveFortheMonth;
	
	@Column(name = "CARRY_FORWARD_LIMIT")
	private Double carryForwardLimit;
	
	@Column(name = "APPLICABLE_TO")
	private String applicableTo;
	
	@Column(name = "ALLOW_NEGETIVE")
	private String allowNegative;
	
	@Column(name = "IS_SANDWICH")
	private String isSandwich;
	
	private String isLeaveEncash;
	private Double leaveEncashLimit;
	
	private String isAutoCredit;
	
	@Column(name = "REMARKS")
	private String remarks;
	
	private Integer  leaveCncashmentComponent;
	
	private String leavePolicyType;
	
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LeavePolicyGroup getLeavePolicyGroup() {
		return leavePolicyGroup;
	}

	public void setLeavePolicyGroup(LeavePolicyGroup leavePolicyGroup) {
		this.leavePolicyGroup = leavePolicyGroup;
	}

	public SalaryHeadItems getSalaryHead() {
		return salaryHead;
	}

	public void setSalaryHead(SalaryHeadItems salaryHead) {
		this.salaryHead = salaryHead;
	}

	public Double getAllotedLeaveFortheYear() {
		return allotedLeaveFortheYear;
	}

	public void setAllotedLeaveFortheYear(Double allotedLeaveFortheYear) {
		this.allotedLeaveFortheYear = allotedLeaveFortheYear;
	}

	public Double getAllotedLeaveFortheMonth() {
		return allotedLeaveFortheMonth;
	}

	public void setAllotedLeaveFortheMonth(Double allotedLeaveFortheMonth) {
		this.allotedLeaveFortheMonth = allotedLeaveFortheMonth;
	}

	public Double getCarryForwardLimit() {
		return carryForwardLimit;
	}

	public void setCarryForwardLimit(Double carryForwardLimit) {
		this.carryForwardLimit = carryForwardLimit;
	}

	public String getApplicableTo() {
		return applicableTo;
	}

	public void setApplicableTo(String applicableTo) {
		this.applicableTo = applicableTo;
	}

	public String getAllowNegative() {
		return allowNegative;
	}

	public void setAllowNegative(String allowNegative) {
		this.allowNegative = allowNegative;
	}

	public String getIsSandwich() {
		return isSandwich;
	}

	public void setIsSandwich(String isSandwich) {
		this.isSandwich = isSandwich;
	}

	public String getIsLeaveEncash() {
		return isLeaveEncash;
	}

	public void setIsLeaveEncash(String isLeaveEncash) {
		this.isLeaveEncash = isLeaveEncash;
	}

	public Double getLeaveEncashLimit() {
		return leaveEncashLimit;
	}

	public void setLeaveEncashLimit(Double leaveEncashLimit) {
		this.leaveEncashLimit = leaveEncashLimit;
	}

	public String getIsAutoCredit() {
		return isAutoCredit;
	}

	public void setIsAutoCredit(String isAutoCredit) {
		this.isAutoCredit = isAutoCredit;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getLeaveCncashmentComponent() {
		return leaveCncashmentComponent;
	}

	public void setLeaveCncashmentComponent(Integer leaveCncashmentComponent) {
		this.leaveCncashmentComponent = leaveCncashmentComponent;
	}

	public String getLeavePolicyType() {
		return leavePolicyType;
	}

	public void setLeavePolicyType(String leavePolicyType) {
		this.leavePolicyType = leavePolicyType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	 
}
