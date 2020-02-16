package com.mypayrollmaster.commons;

import java.util.ArrayList;
import java.util.List;
public class ValidationErrorResponse {
	private List<Error> errors = new ArrayList<>();

	public List<Error> getErrors() {
		return errors;
	}
	
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
}
