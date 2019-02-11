package com.tokyoprogrammer.aqitracer.model;

import lombok.Data;

import java.util.Arrays;

@Data
public class CityJSON {
	private String name;
	private String url;
	private Double[] geo;

	@Override
	public String toString() {
		return "AQIndexStationJSON [name=" + name + ", url=" + url + ", geo=" + Arrays.toString(geo) + "]";
	}
}
