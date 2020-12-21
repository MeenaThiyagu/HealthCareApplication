package com.pharmaceutical.app.HealthcareApplication.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.pharmaceutical.app.HealthcareApplication.dto.*;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,StepBuilderFactory stepBuilderFactory,
			ItemReader<Drug> itemReader, ItemProcessor<Drug,Drug> itemProcessor,
			ItemWriter<Drug> itemWriter) {
		Step step=//null;
				stepBuilderFactory.get("ETL-Load")
				.<Drug,Drug>chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)//give chunk object as <Drug,Drug>->Processor can detect i/p and o/p
				.writer(itemWriter)
				.build();
		
		
		Job build=jobBuilderFactory.get("ETL-load")
		.incrementer(new RunIdIncrementer())//run IDs -batch runs incremented everytime in a sequence
		.start(step)//if multiple steps, flow(step).next(step)
		.build();
		return build;
	}
	
	@Bean
	public FlatFileItemReader<Drug> fileItemReader(@Value("${inputFile}") Resource resource) {
		FlatFileItemReader<Drug> flatFileItemReader=new FlatFileItemReader<>();
		//setting basic configs
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);//as 1st line is header
        flatFileItemReader.setLineMapper(lineMapper());//denotes the data to be mapped to a POJO class
        return flatFileItemReader;
	}

	@Bean
	public LineMapper<Drug> lineMapper() {
		  DefaultLineMapper<Drug> defaultLineMapper = new DefaultLineMapper<>();
		  //Adding tonkenizer to the line mapper
	        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
	        lineTokenizer.setDelimiter(",");
	        lineTokenizer.setStrict(false);//no.of tokens in lines need not match with no.of tokens defined
	        lineTokenizer.setNames(new String[] {"name","manufacturer","marketingStatus","expiryAt","availableAt"});
	        
	        //Matching every columns in excel to class attributes using BeanWrapperFieldSetMapper
	        BeanWrapperFieldSetMapper<Drug> fieldSetMapper=new BeanWrapperFieldSetMapper<Drug>();
	        fieldSetMapper.setTargetType(Drug.class);
	        
	        //adding the above lineTokenizer to defaultLineMapper
	        defaultLineMapper.setLineTokenizer(lineTokenizer);
	        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
	        
	        return defaultLineMapper;
	}
	
	
}
