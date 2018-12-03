package com.tokyoprogrammer.aqitracer.model;

import java.util.Arrays;

public class CityJSON {
	private String name;
	private String url;
	private Double[] geo;

	public CityJSON() {
	}
	
	public CityJSON(String name, String url, Double[] geo) {
		this.name = name;
		this.url = url;
		this.geo = Arrays.copyOf(geo, geo.length);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double[] getGeo() {
		return geo;
	}

	public void setGeo(Double[] geo) {
		this.geo = geo;
	}

	@Override
	public String toString() {
		return "AQIndexStationJSON [name=" + name + ", url=" + url + ", geo=" + Arrays.toString(geo) + "]";
	}

}
