package com.tokyoprogrammer.aqitracer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// A Model that will be used for storage
@Data
@AllArgsConstructor
public class AQIResultDB {
	private int uid;
	private int aqi;
	private String cityName;
	private String vtime;
	private DetailJSON detail;

	@Override
	public String toString() {
		return "AQIndexDB [uid=" + uid + ", aqi=" + aqi + ", cityName=" + cityName + ", vtime=" + vtime + "]";
	}
}
