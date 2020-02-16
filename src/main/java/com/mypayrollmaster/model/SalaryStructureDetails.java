package com.mypayrollmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salary_structure_details")
public class SalaryStructureDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "structure_det_id")
	private Long id;
	
	@ManyToOne
	private SalaryStructure salaryStructure;
	

	@Column(name = "structure_det_operator") 
	private String structureDetOperator; 
	@Column(name = "structure_det_value") 
	private Double structureDetValue ;
	@Column(name = "structure_det_depends") 
	private Double structureDetDepends; 
	@Column(name = "structure_formula") 
	private String structureFormula ;
	@Column(name = "structure_derived_perc") 
	private Double structureDerivedPercentage;
	@Column(name = "structure_det_calequation")  
	private String structureDetailCalEquation;
	
	@ManyToOne
	@JoinColumn(name = "salary_head_item_fkey")
	private SalaryHeadItems salaryHeadItem;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SalaryStructure getSalaryStructure() {
		return salaryStructure;
	}
	public void setSalaryStructure(SalaryStructure salaryStructure) {
		this.salaryStructure = salaryStructure;
	}
	public String getStructureDetOperator() {
		return structureDetOperator;
	}
	public void setStructureDetOperator(String structureDetOperator) {
		this.structureDetOperator = structureDetOperator;
	}
	public Double getStructureDetValue() {
		return structureDetValue;
	}
	public void setStructureDetValue(Double structureDetValue) {
		this.structureDetValue = structureDetValue;
	}
	public Double getStructureDetDepends() {
		return structureDetDepends;
	}
	public void setStructureDetDepends(Double structureDetDepends) {
		this.structureDetDepends = structureDetDepends;
	}
	public String getStructureFormula() {
		return structureFormula;
	}
	public void setStructureFormula(String structureFormula) {
		this.structureFormula = structureFormula;
	}
	public Double getStructureDerivedPercentage() {
		return structureDerivedPercentage;
	}
	public void setStructureDerivedPercentage(Double structureDerivedPercentage) {
		this.structureDerivedPercentage = structureDerivedPercentage;
	}
	public String getStructureDetailCalEquation() {
		return structureDetailCalEquation;
	}
	public void setStructureDetailCalEquation(String structureDetailCalEquation) {
		this.structureDetailCalEquation = structureDetailCalEquation;
	} 
	
	
}
