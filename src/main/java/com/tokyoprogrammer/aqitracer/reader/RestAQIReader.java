package com.tokyoprogrammer.aqitracer.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tokyoprogrammer.aqitracer.model.DataJSON;
import com.tokyoprogrammer.aqitracer.model.RestResultJSON;

public class RestAQIReader implements ItemReader<DataJSON> {
	private final List<String> apiUrl;
	private final RestTemplate restTemplate;
	private List<DataJSON> data; 
	private int index = 0;
	
	public RestAQIReader(List<String> apiUrl, RestTemplate restTemplate) {
		this.apiUrl = apiUrl;
		this.restTemplate = restTemplate;
		this.data = null; 
	}
	
	private boolean isEmpty() {
		return (data == null || data.isEmpty());
	}
	
	// Read every API Result from multiple urls
	private void prepareResponsesList() {
		data = new ArrayList<>();
		for(String url : apiUrl) {
			ResponseEntity<RestResultJSON> response = restTemplate.getForEntity(url, RestResultJSON.class);
			data.add(response.getBody().getData());
		}
	}

	@Override
	public DataJSON read() throws Exception {
		if(isEmpty()) {
			prepareResponsesList();
		}
		if(index < data.size()) return data.get(index++);
		return null;
	}
}
