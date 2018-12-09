package com.tokyoprogrammer.aqitracer.model;

import lombok.Data;

import java.util.Map;

@Data
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
}
