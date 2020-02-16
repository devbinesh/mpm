package com.mypayrollmaster.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

@Entity
@Table(name = "holidays")
public class Holiday {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "HOLIDAYID")
	private Long id;
	
	@ManyToOne
	private HolidayGroup holidayGroup;
	
	@Column(name = "HOLIDAYNAME")
	private String holidayName;
	
	@Column(name = "HOLIDAYDATE")
	@Temporal(TemporalType.DATE)
	private Date holidayDate;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "HOLIDAYTYPE")
	private String holidayType;
	
	private Integer status;
	
	private String background;
	
	private String border;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HolidayGroup getHolidayGroup() {
		return holidayGroup;
	}

	public void setHolidayGroup(HolidayGroup holidayGroup) {
		this.holidayGroup = holidayGroup;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHolidayType() {
		return holidayType;
	}

	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}
	
	
}
