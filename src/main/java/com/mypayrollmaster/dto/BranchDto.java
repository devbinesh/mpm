package com.mypayrollmaster.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.mypayrollmaster.utils.DateUtils;
 
public class BranchDto {
	private Long id;
	 
	private String branchCode;
	@NotBlank(message = "Branch Name is required")
	private String branchName;
	private String address;
	@NotBlank(message = "City is required")
	private String city;
	@NotBlank(message = "State is required")
	private String state;
	@NotBlank(message = "Pincode is required")
	private String pincode; 
	private Double latitude;
	private Double longitude;
	@NotBlank(message = "Financial Year Start is required")
	private String financialYearStart;
	@NotBlank(message = "Financial Year End is required")
	private String financialYearEnd;
	@NotBlank(message = "Leave Year Start is required")
	private String leaveYearStart;
	@NotBlank(message = "Leave Year Start is required")
	private String leaveYearEnd;
	public BranchDto() {
		super();
	}
	public BranchDto(Long id, String branchCode, String branchName, String address, String city, String state,
			String pincode, Date financialYearStart, Date financialYearEnd, Date leaveYearStart, Date leaveYearEnd) {
		super();
		this.id = id;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.financialYearStart = DateUtils.convertDateToString(financialYearStart) ;
		this.financialYearEnd   = DateUtils.convertDateToString(financialYearEnd) ;
		this.leaveYearStart     = DateUtils.convertDateToString(leaveYearStart) ;
		this.leaveYearEnd       = DateUtils.convertDateToString(leaveYearEnd) ;
	}
	public BranchDto(Long id, String branchCode, String branchName, String address, String city, String state,
			String pincode, String financialYearStart, String financialYearEnd, String leaveYearStart, String leaveYearEnd) {
		super();
		this.id = id;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.financialYearStart =  financialYearStart  ;
		this.financialYearEnd   =  financialYearEnd  ;
		this.leaveYearStart     =  leaveYearStart  ;
		this.leaveYearEnd       =  leaveYearEnd ;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getFinancialYearStart() {
		return financialYearStart;
	}
	public void setFinancialYearStart(String financialYearStart) {
		this.financialYearStart = financialYearStart;
	}
	public String getFinancialYearEnd() {
		return financialYearEnd;
	}
	public void setFinancialYearEnd(String financialYearEnd) {
		this.financialYearEnd = financialYearEnd;
	}
	public String getLeaveYearStart() {
		return leaveYearStart;
	}
	public void setLeaveYearStart(String leaveYearStart) {
		this.leaveYearStart = leaveYearStart;
	}
	public String getLeaveYearEnd() {
		return leaveYearEnd;
	}
	public void setLeaveYearEnd(String leaveYearEnd) {
		this.leaveYearEnd = leaveYearEnd;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
	
}
