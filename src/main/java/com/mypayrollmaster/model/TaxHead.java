package com.mypayrollmaster.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name = "tax_heads")
public class TaxHead {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tax_heads_pkey")
	private Long id;
	
	private String taxName;
	private String taxType;
	private String taxDetails;
	
	private Integer orderLevel1;
	private Integer orderLevel2;
	private Integer orderLevel3;
	private Integer orderLevel4;
	
	private String taxActive;
	
	@ManyToOne
	private TaxType typeOfTax;
	@Column(name = "attr1")
	private String attribute1;
	
	
	@Column(name = "attr2")
	private String attribute2;
	
	
	@Column(name = "attr3")
	private String attribute3;

	@OneToMany
	@JoinColumn(name = "tax_heads_fkey")
	private Set<TaxHeadDetails> taxHeadDetails;
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTaxName() {
		return taxName;
	}


	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}


	public String getTaxType() {
		return taxType;
	}


	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}


	public String getTaxDetails() {
		return taxDetails;
	}


	public void setTaxDetails(String taxDetails) {
		this.taxDetails = taxDetails;
	}


	public Integer getOrderLevel1() {
		return orderLevel1;
	}


	public void setOrderLevel1(Integer orderLevel1) {
		this.orderLevel1 = orderLevel1;
	}


	public Integer getOrderLevel2() {
		return orderLevel2;
	}


	public void setOrderLevel2(Integer orderLevel2) {
		this.orderLevel2 = orderLevel2;
	}


	public Integer getOrderLevel3() {
		return orderLevel3;
	}


	public void setOrderLevel3(Integer orderLevel3) {
		this.orderLevel3 = orderLevel3;
	}


	public Integer getOrderLevel4() {
		return orderLevel4;
	}


	public void setOrderLevel4(Integer orderLevel4) {
		this.orderLevel4 = orderLevel4;
	}


	public String getTaxActive() {
		return taxActive;
	}


	public void setTaxActive(String taxActive) {
		this.taxActive = taxActive;
	}


	public String getAttribute1() {
		return attribute1;
	}


	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}


	public String getAttribute2() {
		return attribute2;
	}


	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}


	public String getAttribute3() {
		return attribute3;
	}


	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}


	public TaxType getTypeOfTax() {
		return typeOfTax;
	}


	public void setTypeOfTax(TaxType typeOfTax) {
		this.typeOfTax = typeOfTax;
	}


	public Set<TaxHeadDetails> getTaxHeadDetails() {
		return taxHeadDetails;
	}


	public void setTaxHeadDetails(Set<TaxHeadDetails> taxHeadDetails) {
		this.taxHeadDetails = taxHeadDetails;
	}
	 
	
}
