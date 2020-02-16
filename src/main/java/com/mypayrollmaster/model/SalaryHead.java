package com.mypayrollmaster.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "salary_heads")
public class SalaryHead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "head_pkey")
	private Long id;
	
	@Column(name = "head_desc")
	private String headDesc;
	
	private Integer status;
	
	@Column(name = "head_operator")
	private String headOperator;
	
	@Column(name = "head_occurance")
	private String headOccurance;
	
	@Column(name = "salary_head_order1")
	private Integer salaryHeadOrder1;
	
	@OneToMany
	@JoinColumn(name = "head_fkey")
	@Where(clause = "status = 1")
	@JsonIgnore
	Set<SalaryHeadItems> salaryHeadItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeadDesc() {
		return headDesc;
	}

	public void setHeadDesc(String headDesc) {
		this.headDesc = headDesc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getHeadOperator() {
		return headOperator;
	}

	public void setHeadOperator(String headOperator) {
		this.headOperator = headOperator;
	}

	public String getHeadOccurance() {
		return headOccurance;
	}

	public void setHeadOccurance(String headOccurance) {
		this.headOccurance = headOccurance;
	}

	public Integer getSalaryHeadOrder1() {
		return salaryHeadOrder1;
	}

	public void setSalaryHeadOrder1(Integer salaryHeadOrder1) {
		this.salaryHeadOrder1 = salaryHeadOrder1;
	}

	public Set<SalaryHeadItems> getSalaryHeadItems() {
		return salaryHeadItems;
	}

	public void setSalaryHeadItems(Set<SalaryHeadItems> salaryHeadItems) {
		this.salaryHeadItems = salaryHeadItems;
	}
	
	
	
}
