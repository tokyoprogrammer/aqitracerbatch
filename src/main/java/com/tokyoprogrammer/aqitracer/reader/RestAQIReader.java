package com.tokyoprogrammer.aqitracer.reader;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.tokyoprogrammer.aqitracer.model.DataJSON;
import com.tokyoprogrammer.aqitracer.model.RestResultJSON;

@Slf4j
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
		return CollectionUtils.isEmpty(data);
	}

	// Read every API Result from multiple urls
	private void prepareResponsesList() {
		data = new ArrayList<>();
		for(String url : apiUrl) {
			ResponseEntity<RestResultJSON> response = restTemplate.getForEntity(url, RestResultJSON.class);
			try {
				data.add(response.getBody().getData());
			} catch (NullPointerException e) {
			    log.warn("Response has empty body data");
			}
		}
	}

	@Override
	public DataJSON read() {
		if(isEmpty()) {
			prepareResponsesList();
		}
		if(index < data.size()) return data.get(index++);
		return null;
	}
}
