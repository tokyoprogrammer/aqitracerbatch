package com.tokyoprogrammer.aqitracer.model;

import lombok.Data;

@Data
public class TimeJSON {
	private String s;
	private String tz;
	private Long v;

	@Override
	public String toString() {
		return "AQIndexTimeJSON [stime=" + s + ", tz=" + tz + ", vtime=" + v + "]";
	}
}
