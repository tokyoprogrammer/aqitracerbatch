package com.tokyoprogrammer.aqitracer.model;

public class TimeJSON {
	private String s;
	private String tz;
	private Long v;
	
	public TimeJSON() {
	}
	
	public TimeJSON(String s, String tz, Long v) {
		this.s = s;
		this.tz = tz;
		this.v = v;
	}

	public String getS() {
		return s;
	}

	public void setS(String stime) {
		this.s = stime;
	}

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public Long getV() {
		return v;
	}

	public void setV(Long vtime) {
		this.v = vtime;
	}

	@Override
	public String toString() {
		return "AQIndexTimeJSON [stime=" + s + ", tz=" + tz + ", vtime=" + v + "]";
	}
	
}
