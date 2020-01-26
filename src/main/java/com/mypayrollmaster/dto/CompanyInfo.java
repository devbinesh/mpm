package com.mypayrollmaster.dto;

import org.springframework.web.multipart.MultipartFile;

public class CompanyInfo {
	 
	 
	private String businessName;
	 
	private String businessNature;
	 
	private String businessType;
	private String address;
	private String city;
	private String pincode;
	private String state;
	private String fax;
	private String phone;
	private String email;
	//private String website;
	private String logo;
	//private String subdomain; 
	
	private String cinNo;
	private String panNo;
	private String serviceTax;
	private String tanNo;
	private String pfNo;
	private String empStatInsNo;
	private String ptNoCo;
	private String ptNoDir;

	private String ptNoEmp; 
	MultipartFile logoFile;
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessNature() {
		return businessNature;
	}
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
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
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCinNo() {
		return cinNo;
	}
	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(String serviceTax) {
		this.serviceTax = serviceTax;
	}
	public String getTanNo() {
		return tanNo;
	}
	public void setTanNo(String tanNo) {
		this.tanNo = tanNo;
	}
	public String getPfNo() {
		return pfNo;
	}
	public void setPfNo(String pfNo) {
		this.pfNo = pfNo;
	}
	public String getEmpStatInsNo() {
		return empStatInsNo;
	}
	public void setEmpStatInsNo(String empStatInsNo) {
		this.empStatInsNo = empStatInsNo;
	}
	@Override
	public String toString() {
		return "CompanyInfo [businessName=" + businessName + ", businessNature=" + businessNature + ", businessType="
				+ businessType + ", address=" + address + ", city=" + city + ", pincode=" + pincode + ", state=" + state
				+ ", fax=" + fax + ", phone=" + phone + ", email=" + email + ", cinNo=" + cinNo + ", panNo=" + panNo
				+ ", serviceTax=" + serviceTax + ", tanNo=" + tanNo + ", pfNo=" + pfNo + ", empStatInsNo="
				+ empStatInsNo + ", ptNoCo=" + ptNoCo + ", ptNoDir=" + ptNoDir + ", ptNoEmp=" + ptNoEmp + "]";
	}
	public String getPtNoCo() {
		return ptNoCo;
	}
	public void setPtNoCo(String ptNoCo) {
		this.ptNoCo = ptNoCo;
	}
	public String getPtNoDir() {
		return ptNoDir;
	}
	public void setPtNoDir(String ptNoDir) {
		this.ptNoDir = ptNoDir;
	}
	 
	public String getPtNoEmp() {
		return ptNoEmp;
	}
	public void setPtNoEmp(String ptNoEmp) {
		this.ptNoEmp = ptNoEmp;
	}
	public MultipartFile getLogoFile() {
		return logoFile;
	}
	public void setLogoFile(MultipartFile logoFile) {
		this.logoFile = logoFile;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
 
	
	
}
