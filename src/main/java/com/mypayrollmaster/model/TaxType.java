package com.mypayrollmaster.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "tax_type")
public class TaxType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tax_type_pkey")
	private Long id;
	
	private String taxType;
	@Column(name = "tax_desc")
	private String taxDescription;
	private Integer taxStatus;
	private String taxOccurance;
	private String taxOperator;
	
	@OneToMany
	@JoinColumn(name = "tax_type_fkey")
	private Set<TaxHead> taxHeads;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaxType() {
		return taxType;
	}
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}
	public String getTaxDescription() {
		return taxDescription;
	}
	public void setTaxDescription(String taxDescription) {
		this.taxDescription = taxDescription;
	}
	public Integer getTaxStatus() {
		return taxStatus;
	}
	public void setTaxStatus(Integer taxStatus) {
		this.taxStatus = taxStatus;
	}
	public String getTaxOccurance() {
		return taxOccurance;
	}
	public void setTaxOccurance(String taxOccurance) {
		this.taxOccurance = taxOccurance;
	}
	public String getTaxOperator() {
		return taxOperator;
	}
	public void setTaxOperator(String taxOperator) {
		this.taxOperator = taxOperator;
	}
	public Set<TaxHead> getTaxHeads() {
		return taxHeads;
	}
	public void setTaxHeads(Set<TaxHead> taxHeads) {
		this.taxHeads = taxHeads;
	}
	
}
