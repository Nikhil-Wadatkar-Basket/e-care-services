package com.bs.mapper;

public class MyInfo {
	private String name;
	private String city;

	public MyInfo() {
		// TODO Auto-generated constructor stub
	}

	public MyInfo(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "MyInfo [name=" + name + ", city=" + city + "]";
	}

}
