package com.bs.beans;

public class ErrorInfo {
	private String exceptionMessage;
	private String className;
	private String methodName;
	private String fileName;
	private Integer lineNUmber;

	public ErrorInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getLineNUmber() {
		return lineNUmber;
	}

	public void setLineNUmber(Integer lineNUmber) {
		this.lineNUmber = lineNUmber;
	}

	@Override
	public String toString() {
		return "ErrorInfo [exceptionMessage=" + exceptionMessage + ", className=" + className + ", methodName="
				+ methodName + ", fileName=" + fileName + ", lineNUmber=" + lineNUmber + "]";
	}


	
}
