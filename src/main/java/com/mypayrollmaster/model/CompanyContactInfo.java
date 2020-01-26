package com.mypayrollmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "comp_contact_info")
public class CompanyContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @Column(name = "business_name")
	private String businessName;
	 @Column(name = "business_nature")
	private String businessNature;
	 @Column(name = "business_type")
	private String businessType;
	private String address;
	private String city;
	private String pincode;
	private String state;
	private String fax;
	private String phone;
	private String email;
	private String website;
	private String logo;
	private String subdomain;
	private Long logosize;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getSubdomain() {
		return subdomain;
	}
	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}
	public Long getLogosize() {
		return logosize;
	}
	public void setLogosize(Long logosize) {
		this.logosize = logosize;
	}
	@Override
	public String toString() {
		return "CompanyContactInfo [id=" + id + ", businessName=" + businessName + ", businessNature=" + businessNature
				+ ", businessType=" + businessType + ", address=" + address + ", city=" + city + ", pincode=" + pincode
				+ ", state=" + state + ", fax=" + fax + ", phone=" + phone + ", email=" + email + ", website=" + website
				+ ", logo=" + logo + ", subdomain=" + subdomain + ", logosize=" + logosize + "]";
	}
	
	
	
}
