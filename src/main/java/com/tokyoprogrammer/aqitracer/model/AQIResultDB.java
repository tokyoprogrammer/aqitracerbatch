package com.tokyoprogrammer.aqitracer.model;

// A Model that will be used for storage 
public class AQIResultDB {
	private int uid;
	private int aqi;
	private String cityName;
	private String vtime;
	private DetailJSON detail;

	public AQIResultDB() {
	}

	public AQIResultDB(int uid, int aqi, String cityName, String vtime, DetailJSON detail) {
		this.uid = uid;
		this.aqi = aqi;
		this.cityName = cityName;
		this.vtime = vtime;
		this.detail = detail;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getVtime() {
		return vtime;
	}

	public void setVtime(String vtime) {
		this.vtime = vtime;
	}

	@Override
	public String toString() {
		return "AQIndexDB [uid=" + uid + ", aqi=" + aqi + ", cityName=" + cityName + ", vtime=" + vtime + "]";
	}

	public DetailJSON getDetail() {
		return detail;
	}

	public void setDetail(DetailJSON detail) {
		this.detail = detail;
	}

}
