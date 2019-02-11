package com.tokyoprogrammer.aqitracer.model;

import lombok.Data;

@Data
public class DataJSON {
	private int idx;
	private int aqi;
	private CityJSON city;
	private TimeJSON time;
	private DetailJSON iaqi;

	@Override
	public String toString() {
		return "AQIndexJSON [idx=" + idx + ", aqi=" + aqi + ", city=" + city + ", time=" + time + "]";
	}
}
