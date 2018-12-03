package com.tokyoprogrammer.aqitracer.model;

public class DataJSON {
	private int idx;
	private int aqi;
	private CityJSON city;
	private TimeJSON time;
	private DetailJSON iaqi;

	public DataJSON() {
	}

	public DataJSON(int idx, int aqi, CityJSON city, TimeJSON time, DetailJSON iaqi) {
		this.idx = idx;
		this.aqi = aqi;
		this.city = city;
		this.time = time;
		this.iaqi = iaqi;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
	}

	public CityJSON getCity() {
		return city;
	}

	public void setCity(CityJSON city) {
		this.city = city;
	}

	public TimeJSON getTime() {
		return time;
	}

	public void setTime(TimeJSON time) {
		this.time = time;
	}

	public DetailJSON getIaqi() {
		return iaqi;
	}

	public void setIaqi(DetailJSON iaqi) {
		this.iaqi = iaqi;
	}

	@Override
	public String toString() {
		return "AQIndexJSON [idx=" + idx + ", aqi=" + aqi + ", city=" + city + ", time=" + time + "]";
	}

}
