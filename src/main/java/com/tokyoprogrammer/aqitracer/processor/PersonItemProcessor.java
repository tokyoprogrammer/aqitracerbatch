package com.tokyoprogrammer.aqitracer.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import com.tokyoprogrammer.aqitracer.model.AQIResultDB;
import com.tokyoprogrammer.aqitracer.model.DataJSON;

public class PersonItemProcessor implements ItemProcessor<DataJSON, AQIResultDB> {

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
	
	@Override
	public AQIResultDB process(final DataJSON item) throws Exception {

		final AQIResultDB transformed = new AQIResultDB(item.getIdx(), item.getAqi(), item.getCity().getName(),
				String.valueOf(item.getTime().getV()), item.getIaqi());

		log.info("Converting (" + item + ") into (" + transformed + ")");

		return transformed;
	}

}
