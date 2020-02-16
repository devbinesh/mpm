package com.mypayrollmaster.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 

@Entity
@Table(name = "holiday_group")
public class HolidayGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "HOLIDAY_GROUP_ID")
	private Long id;
	
	@Column(name = "COMPANY_CODE")
	private String companyCode;
	@Column(name = "BRANCH_CODE")	
	private String branchCode;
	@Column(name = "HOLIDAY_GROUP_NAME")	
	private String holidayGroupName;
	private Integer status;
	
	@OneToMany
	@JoinColumn(name = "HOLIDAY_GROUP_ID")
	private Set<Holiday> holidays;
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
	public String getHolidayGroupName() {
		return holidayGroupName;
	}
	public void setHolidayGroupName(String holidayGroupName) {
		this.holidayGroupName = holidayGroupName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Set<Holiday> getHolidays() {
		return holidays;
	}
	public void setHolidays(Set<Holiday> holidays) {
		this.holidays = holidays;
	}
	
	
	 
}
