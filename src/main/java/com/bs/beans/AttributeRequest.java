package com.bs.beans;

public class AttributeRequest {
	private String createFlag;
	private String showFlag;
	private String deleteFlag;
	
	public AttributeRequest() {
		// TODO Auto-generated constructor stub
	}

	public AttributeRequest(String createFlag, String showFlag, String deleteFlag) {
		super();
		this.createFlag = createFlag;
		this.showFlag = showFlag;
		this.deleteFlag = deleteFlag;
	}

	public String getCreateFlag() {
		return createFlag;
	}

	public void setCreateFlag(String createFlag) {
		this.createFlag = createFlag;
	}

	public String getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "AttributeRequest [createFlag=" + createFlag + ", showFlag=" + showFlag + ", deleteFlag=" + deleteFlag
				+ "]";
	}
	

}
