package com.mypayrollmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "tax_heads_details")
public class TaxHeadDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tax_heads_details_pkey")
	private Long id;
	
	private String taxHeadsDetails;
	private String taxHeadsDetails1;
	private String taxHeadsDetails2;
	private Integer status;
	@Column(name="fieldtype")
	private Integer fieldType;
	private Integer active;
	
	@ManyToOne
	private TaxHead taxHead;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaxHeadsDetails() {
		return taxHeadsDetails;
	}

	public void setTaxHeadsDetails(String taxHeadsDetails) {
		this.taxHeadsDetails = taxHeadsDetails;
	}

	public String getTaxHeadsDetails1() {
		return taxHeadsDetails1;
	}

	public void setTaxHeadsDetails1(String taxHeadsDetails1) {
		this.taxHeadsDetails1 = taxHeadsDetails1;
	}

	public String getTaxHeadsDetails2() {
		return taxHeadsDetails2;
	}

	public void setTaxHeadsDetails2(String taxHeadsDetails2) {
		this.taxHeadsDetails2 = taxHeadsDetails2;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getFieldType() {
		return fieldType;
	}

	public void setFieldType(Integer fieldType) {
		this.fieldType = fieldType;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public TaxHead getTaxHead() {
		return taxHead;
	}

	public void setTaxHead(TaxHead taxHead) {
		this.taxHead = taxHead;
	}
	
	
}
