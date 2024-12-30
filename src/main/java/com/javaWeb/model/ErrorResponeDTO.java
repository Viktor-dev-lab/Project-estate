package com.javaWeb.model;

import java.util.List;

public class ErrorResponeDTO {
	String Error;
	List<String> details;
	
	public String getError() {
		return Error;
	}
	public void setError(String error) {
		Error = error;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
}
