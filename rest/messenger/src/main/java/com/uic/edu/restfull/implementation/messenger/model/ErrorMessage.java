package com.uic.edu.restfull.implementation.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMessage;
	private String documentation;
	private int errorCode;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public ErrorMessage() {
	}

	public ErrorMessage(String errorMessage, String documentation, int errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.documentation = documentation;
		this.errorCode = errorCode;
	}

}
