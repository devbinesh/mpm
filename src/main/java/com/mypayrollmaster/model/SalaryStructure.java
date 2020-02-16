package com.mypayrollmaster.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "salary_structure")
public class SalaryStructure {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "structure_id")
	private Long id;
	
	private String companyCode;
	private String structureName;
	@Column(name = "prorate_code")
	private String prorateCode;
	@Column(name = "prorate_desc")
	private String prorateDesc;
	@Column(name = "defined_structure_for")
	private String definedStructureFor;
	@Column(name = "structure_eg_amt")
	private Integer structureExampleAmount;
	@Column(name = "structure_created_date")
	private Integer structure_created_date;
	@Temporal(TemporalType.DATE)
	@Column(name = "startdate_effective")
	private Date   startdateEffective;
	@Temporal(TemporalType.DATE)
	@Column(name = "enddate_effective")
	private Date enddateEffective;
	@Column(name = "structure_active")
	private Integer structureActive;
	
	@OneToMany
	@JoinColumn(name = "structure_id")
	private Set<SalaryStructureDetails> details;
	
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
	public String getStructureName() {
		return structureName;
	}
	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}
	public String getProrateCode() {
		return prorateCode;
	}
	public void setProrateCode(String prorateCode) {
		this.prorateCode = prorateCode;
	}
	public String getProrateDesc() {
		return prorateDesc;
	}
	public void setProrateDesc(String prorateDesc) {
		this.prorateDesc = prorateDesc;
	}
	public String getDefinedStructureFor() {
		return definedStructureFor;
	}
	public void setDefinedStructureFor(String definedStructureFor) {
		this.definedStructureFor = definedStructureFor;
	}
	public Integer getStructureExampleAmount() {
		return structureExampleAmount;
	}
	public void setStructureExampleAmount(Integer structureExampleAmount) {
		this.structureExampleAmount = structureExampleAmount;
	}
	public Integer getStructure_created_date() {
		return structure_created_date;
	}
	public void setStructure_created_date(Integer structure_created_date) {
		this.structure_created_date = structure_created_date;
	}
	public Date getStartdateEffective() {
		return startdateEffective;
	}
	public void setStartdateEffective(Date startdateEffective) {
		this.startdateEffective = startdateEffective;
	}
	public Date getEnddateEffective() {
		return enddateEffective;
	}
	public void setEnddateEffective(Date enddateEffective) {
		this.enddateEffective = enddateEffective;
	}
	public Integer getStructureActive() {
		return structureActive;
	}
	public void setStructureActive(Integer structureActive) {
		this.structureActive = structureActive;
	}
	
	
	
}
