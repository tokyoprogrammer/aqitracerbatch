package com.tokyoprogrammer.aqitracer.configure;

import com.mongodb.MongoClientURI;
import com.tokyoprogrammer.aqitracer.listener.JobCompletionNotificationListener;
import com.tokyoprogrammer.aqitracer.model.AQIResultDB;
import com.tokyoprogrammer.aqitracer.model.DataJSON;
import com.tokyoprogrammer.aqitracer.processor.PersonItemProcessor;
import com.tokyoprogrammer.aqitracer.reader.RestAQIReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class BatchConfiguration {

    @Resource
    public JobBuilderFactory jobBuilderFactory;

    @Resource
    public StepBuilderFactory stepBuilderFactory;

    @Resource
    private Environment env;

    @Value("batch.baseUrl")
    private static String BASE_URL;

    @Value("batch.tokenUrl")
    private static String TOKEN_URL;

    // The IDS_LIST comes from the result of the URL below.
    // TODO The list should be dynamically generated using the API below.
    // http://api.waqi.info/search/?token=80860687b4b6c03df2a8c5e1b9a895275abc368d&keyword=Seoul
    private static final String IDS_LIST[] = { "5508", "4487", "1690", "1673", "1679", "4498" };

    @Bean
    public ItemReader<DataJSON> restStudentReader(RestTemplate restTemplate) {
        List<String> urls = new ArrayList<>();
        // make request url list using the IDS_LIST
        for (String id : IDS_LIST) {
            String url = BASE_URL + id + TOKEN_URL;
            urls.add(url);
        }

        return new RestAQIReader(urls, restTemplate);
    }

    @Bean
    public ItemProcessor<DataJSON, AQIResultDB> processor() {
        return new PersonItemProcessor();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        MongoClientURI uri = new MongoClientURI(env.getProperty("spring.data.mongodb.uri"));
        return new SimpleMongoDbFactory(uri);
    }

    @Resource
    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }

    @Bean
    public ItemWriter<AQIResultDB> writer(DataSource dataSource) {
        MongoItemWriter<AQIResultDB> writer = new MongoItemWriter<>();
        try {
            writer.setTemplate(mongoTemplate());
        } catch (Exception e) {
            log.error(e.toString());
        }
        writer.setCollection("aqihourly");
        return writer;
    }

    @Bean
    public Job importAQIJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importAQIJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
                .end().build();
    }

    @Bean
    public Step step1(ItemWriter<AQIResultDB> writer) {
        return stepBuilderFactory.get("step1").<DataJSON, AQIResultDB>chunk(10)
                .reader(restStudentReader(restTemplate())).processor(processor()).writer(writer).build();
    }
}
