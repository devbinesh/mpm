package com.mypayrollmaster.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "fin_year")
public class FinancialYear {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Fin_year_seq")
	private Long id;
	
	@Column(name = "company_code")
	private String companyCode;
	@Column(name = "branch_code")
	private String branchCode;
	@Column(name = "fin_year")
	private Integer finYear;
	@Temporal(TemporalType.DATE)
	@Column(name = "start_month")
	private Date startMonth;
	@Temporal(TemporalType.DATE)
	@Column(name = "end_month")
	private Date endMonth;
	@Column(name = "Year_status")
	private String yearStatus;
	@Column(name = "is_current_finyear")
	private String  isCurrentFinyear;
	 
	private Integer vattr1 ;
	private Integer vattr2 = 0;
	private Integer vattr3 = 0;
	private Integer status = 0;

	
	
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
	public Integer getFinYear() {
		return finYear;
	}
	public void setFinYear(Integer finYear) {
		this.finYear = finYear;
	}
	public Date getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(Date startMonth) {
		this.startMonth = startMonth;
	}
	public Date getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(Date endMonth) {
		this.endMonth = endMonth;
	}
	public String getYearStatus() {
		return yearStatus;
	}
	public void setYearStatus(String yearStatus) {
		this.yearStatus = yearStatus;
	}
	public String getIsCurrentFinyear() {
		return isCurrentFinyear;
	}
	public void setIsCurrentFinyear(String isCurrentFinyear) {
		this.isCurrentFinyear = isCurrentFinyear;
	}
	public Integer getVattr1() {
		return vattr1;
	}
	public void setVattr1(Integer vattr1) {
		this.vattr1 = vattr1;
	}
	public Integer getVattr2() {
		return vattr2;
	}
	public void setVattr2(Integer vattr2) {
		this.vattr2 = vattr2;
	}
	public Integer getVattr3() {
		return vattr3;
	}
	public void setVattr3(Integer vattr3) {
		this.vattr3 = vattr3;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
}
