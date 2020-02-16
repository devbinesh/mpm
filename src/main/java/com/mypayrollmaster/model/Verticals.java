package com.mypayrollmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class Verticals {

	@Column(name = "vert_code")
	private String verticalCode;
	@Column(name = "vertical_name")
	private String verticalName;
	
	private Integer status;
}
