package com.mypayrollmaster.dto;

import java.util.Date;
 
public class SalaryHeadItemDto {

	private Long id;
	
	 
	private String item;
	 
	private String itemType;
	 
	private String itemValue;
	
	 
	private String occurance;
	
	 
	private Date startFrom;
	
	private String comments;
	private String value;
	 
	private String isShowSalSlip;
	
	 
	private String itemPart;
	
	private Integer status;
	
 
	private Integer salaryHeadItemOrder1;
	
	private Long headPKey;
	
	private boolean isTaxSalaryComponent;

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

	public Long getHeadPKey() {
		return headPKey;
	}

	public void setHeadPKey(Long headPKey) {
		this.headPKey = headPKey;
	}

	public boolean isTaxSalaryComponent() {
		return isTaxSalaryComponent;
	}

	public void setTaxSalaryComponent(boolean isTaxSalaryComponent) {
		this.isTaxSalaryComponent = isTaxSalaryComponent;
	}
	
	
 
}
