package com.mypayrollmaster.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "salary_head_items")
public class SalaryHeadItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salary_head_item_pkey")
	private Long id;
	
	@Column(name = "item")
	private String item;
	
	@Column(name = "item_type")
	private String itemType;
	@Column(name = "item_value")
	private String itemValue;
	
	 
	private String occurance;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_from")
	private Date startFrom;
	
	private String comments;
	private String value;
	
	@Column(name = "is_show_salslip")
	private String isShowSalSlip;
	
	@Column(name = "item_part")
	private String itemPart;
	
	private Integer status;
	
	@Column(name = "salary_head_item_order1")
	private Integer salaryHeadItemOrder1;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "head_fkey")
	@JsonIgnore
	private SalaryHead salaryHead;

	private transient boolean isTaxSalaryComponent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public String getOccurance() {
		return occurance;
	}

	public void setOccurance(String occurance) {
		this.occurance = occurance;
	}

	public Date getStartFrom() {
		return startFrom;
	}

	public void setStartFrom(Date startFrom) {
		this.startFrom = startFrom;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIsShowSalSlip() {
		return isShowSalSlip;
	}

	public void setIsShowSalSlip(String isShowSalSlip) {
		this.isShowSalSlip = isShowSalSlip;
	}

	public String getItemPart() {
		return itemPart;
	}

	public void setItemPart(String itemPart) {
		this.itemPart = itemPart;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSalaryHeadItemOrder1() {
		return salaryHeadItemOrder1;
	}

	public void setSalaryHeadItemOrder1(Integer salaryHeadItemOrder1) {
		this.salaryHeadItemOrder1 = salaryHeadItemOrder1;
	}

	public SalaryHead getSalaryHead() {
		return salaryHead;
	}

	public void setSalaryHead(SalaryHead salaryHead) {
		this.salaryHead = salaryHead;
	}

	public boolean isTaxSalaryComponent() {
		return isTaxSalaryComponent;
	}

	public void setTaxSalaryComponent(boolean isTaxSalaryComponent) {
		this.isTaxSalaryComponent = isTaxSalaryComponent;
	}
	
	
	
}
