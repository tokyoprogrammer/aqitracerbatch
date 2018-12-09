package com.tokyoprogrammer.aqitracer.processor;

import com.tokyoprogrammer.aqitracer.model.AQIResultDB;
import com.tokyoprogrammer.aqitracer.model.DataJSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class PersonItemProcessor implements ItemProcessor<DataJSON, AQIResultDB> {

	@Override
	public AQIResultDB process(final DataJSON item) {

		final AQIResultDB transformed =
				new AQIResultDB(item.getIdx(), item.getAqi(), item.getCity().getName(),
						String.valueOf(item.getTime().getV()), item.getIaqi());

		log.info("Converting (" + item + ") into (" + transformed + ")");

		return transformed;
	}
}
