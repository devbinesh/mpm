package com.mypayrollmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "compliance")
public class ComplianceInfo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cin_no" )
	private String cinNo;
	
	@Column(name = "pan_no" )
	private String panNo;
	
	@Column(name = "service_tax" )
	private String serviceTax;
	
	@Column(name = "tan_no" )
	private String tanNo;
	
	@Column(name = "pf_no" )
	private String pfNo;
	
	@Column(name = "emp_state_ins_no" )
	private String empStatInsNo;
	
	@Column(name = "pt_no_co" )
	private String ptNoCo;
	
	@Column(name = "pt_no_dir" )
	private String ptNoDir;
	
	@Column(name = "pt_no_emp" )
	private String ptNoEmp;
	
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
}
