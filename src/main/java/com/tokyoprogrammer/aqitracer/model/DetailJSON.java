package com.tokyoprogrammer.aqitracer.model;

import java.util.Map;

public class DetailJSON {
	private Map<String, Integer> co;
	private Map<String, Integer> h;
	private Map<String, Double> no2;
	private Map<String, Double> o3;
	private Map<String, Double> p;
	private Map<String, Integer> pm10;
	private Map<String, Integer> pm25;
	private Map<String, Integer> r;
	private Map<String, Double> so2;
	private Map<String, Double> t;
	private Map<String, Double> w;
	private Map<String, Double> wd;

	public Map<String, Integer> getCo() {
		return co;
	}

	public void setCo(Map<String, Integer> co) {
		this.co = co;
	}

	public Map<String, Integer> getH() {
		return h;
	}

	public void setH(Map<String, Integer> h) {
		this.h = h;
	}

	public Map<String, Double> getNo2() {
		return no2;
	}

	public void setNo2(Map<String, Double> no2) {
		this.no2 = no2;
	}

	public Map<String, Double> getO3() {
		return o3;
	}

	public void setO3(Map<String, Double> o3) {
		this.o3 = o3;
	}

	public Map<String, Double> getP() {
		return p;
	}

	public void setP(Map<String, Double> p) {
		this.p = p;
	}

	public Map<String, Integer> getPm10() {
		return pm10;
	}

	public void setPm10(Map<String, Integer> pm10) {
		this.pm10 = pm10;
	}

	public Map<String, Integer> getPm25() {
		return pm25;
	}

	public void setPm25(Map<String, Integer> pm25) {
		this.pm25 = pm25;
	}

	public Map<String, Integer> getR() {
		return r;
	}

	public void setR(Map<String, Integer> r) {
		this.r = r;
	}

	public Map<String, Double> getSo2() {
		return so2;
	}

	public void setSo2(Map<String, Double> so2) {
		this.so2 = so2;
	}

	public Map<String, Double> getT() {
		return t;
	}

	public void setT(Map<String, Double> t) {
		this.t = t;
	}

	public Map<String, Double> getW() {
		return w;
	}

	public void setW(Map<String, Double> w) {
		this.w = w;
	}

	public Map<String, Double> getWd() {
		return wd;
	}

	public void setWd(Map<String, Double> wd) {
		this.wd = wd;
	}
}
