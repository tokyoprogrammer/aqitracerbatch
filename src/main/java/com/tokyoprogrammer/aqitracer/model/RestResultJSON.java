package com.tokyoprogrammer.aqitracer.model;

public class RestResultJSON {
	private DataJSON data;
	private String status;

	public DataJSON getData() {
		return data;
	}

	public void setData(DataJSON data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
