package com.mypayrollmaster.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device_attandance")
public class DeviceAttendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String companyCode;
	private String branchCode;
	private Integer deviceLogId;
	private Date downloadDate;
	private Integer deviceId;

	private String deviceUserId;

	private String empId;

	private Date logDate;
	private String direction;
	private String attDirection;
	private String workCode;
	private String status;
	
	
	private String c1;
	private String c2;
	private String c3;
	private String c4;
	private String c5;
	private String c6;
	private String c7; 
}
