package com.jdp.datalake.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import java.io.File;
import java.io.IOException;


import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.google.gson.Gson;
import com.jdp.datalake.entity.IngestionRecord;
import com.jdp.datalake.entity.ProductCuratedStoreRequest;
import com.jdp.datalake.entity.ProductRequest;
import com.jdp.datalake.entity.TrackStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.util.ResourceUtils;

@EnableBinding(Sink.class)
public class DataProcessor {
	
	
	@Autowired
	private IngestionRepository repo;
	@Autowired
	private ElasticSearchRepo crepo;
	 private static final Logger LOGGER = LoggerFactory.getLogger(Sink.class);
	 @StreamListener(Sink.INPUT)
	   public void handleMessage(String message) {
		   LOGGER.info("New message received in event hub: '{}'", message);
		   try {
			 Gson gson = new Gson(); 
			 ProductRequest productrequest =gson.fromJson(message,ProductRequest.class);
			 
			 validateMessage(productrequest);
			// EnrichMessage(request);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ProcessingException e) {
			e.printStackTrace();
		}
	         
	   }

	 
	 private void validateMessage(ProductRequest productrequest) throws IOException, ProcessingException
	   {
//		   File schemaFile= ResourceUtils.getFile("classpath:employee.json");
//		   JsonSchema schema =ValidationUtils.getSchemaNode(schemaFile);
//		   JsonNode node = ValidationUtils.getJsonNode(payload);
//		    if (ValidationUtils.isJsonValid(schema,node)){
//		    	System.out.println("Valid!");
//		    	//call to repo for updating status
//		    	LOGGER.info("message is valid and do further processing"); 
//		    }else{
//		    	//call to repo for updating status
//		    	LOGGER.info("message is not valid and do further correction of data"); 
//		    }
		    IngestionRecord record =new IngestionRecord();
		    record.setId(productrequest.getId());
			record.setEntity(productrequest.getClass().getName());
			record.setStatus(TrackStatus.VALIDATED.toString());
			record.setSupplier(productrequest.getSuppliername());
			repo.save(record);
			ProductCuratedStoreRequest request =new ProductCuratedStoreRequest();
			
			request.setCategory(productrequest.getCategory());
			request.setId(productrequest.getId());
			request.setIngestionid(productrequest.getId());
			request.setName(productrequest.getName());
			request.setSuppliername(productrequest.getSuppliername());
			crepo.save(request);
	   }
	 
	 private void EnrichMessage(ProductRequest payload) throws IOException, ProcessingException
	   {
		 Gson gson = new Gson(); 
//		 crepo.save(request);
	   }
}
