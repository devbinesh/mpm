package com.mypayrollmaster.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tax_salary_components")
public class TaxSalaryComponent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tax_salary_components_pkey")
	private Long id;
	@Column(name = "tax_salary_components_name")
	private String taxSalaryComponentsName;
	
	/*@ManyToOne
	@JoinColumn(name = "salary_head_item_Fkey")
	private SalaryHeadItems salaryHeadItem;
	*/
	@Column(name = "salary_head_item_Fkey")
	private Long salaryHeadItemFKey;
	
	@Column(name = "upper_limit")
	private Double upperLimit;
	@Column(name = "fin_year")
	private String financialYear;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private Date creationDate;
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "modification_date")
	private Date modificationDate;
	
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaxSalaryComponentsName() {
		return taxSalaryComponentsName;
	}

	public void setTaxSalaryComponentsName(String taxSalaryComponentsName) {
		this.taxSalaryComponentsName = taxSalaryComponentsName;
	}

	/*public SalaryHeadItems getSalaryHeadItem() {
		return salaryHeadItem;
	}

	public void setSalaryHeadItem(SalaryHeadItems salaryHeadItem) {
		this.salaryHeadItem = salaryHeadItem;
	}*/

	public Long getSalaryHeadItemFKey() {
		return salaryHeadItemFKey;
	}

	public void setSalaryHeadItemFKey(Long salaryHeadItemFKey) {
		this.salaryHeadItemFKey = salaryHeadItemFKey;
	}

	public Double getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(Double upperLimit) {
		this.upperLimit = upperLimit;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
	
}
