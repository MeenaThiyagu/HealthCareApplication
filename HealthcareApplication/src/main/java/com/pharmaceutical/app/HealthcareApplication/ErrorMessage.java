package com.pharmaceutical.app.HealthcareApplication;

public class ErrorMessage {
	private String errorMessage;
	private int errorId;
	private String documentation;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorId() {
		return errorId;
	}
	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	public ErrorMessage(String errorMessage, int errorId, String documentation) {
		super();
		this.errorMessage = errorMessage;
		this.errorId = errorId;
		this.documentation = documentation;
	}
}
