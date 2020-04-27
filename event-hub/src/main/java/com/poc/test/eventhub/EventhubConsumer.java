package com.poc.test.eventhub;
import java.io.File;
import java.io.IOException;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.JsonNode;
@EnableBinding(Sink.class)
public class EventhubConsumer {
	 private static final Logger LOGGER = LoggerFactory.getLogger(Sink.class);

	   @StreamListener(Sink.INPUT)
	   public void handleMessage(String message) {
		   LOGGER.info("New message received in event hub: '{}'", message);
		   try {
			validateMessage(message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ProcessingException e) {
			e.printStackTrace();
		}
	         
	   }
	   
	   
	   private void validateMessage(String payload) throws IOException, ProcessingException
	   {
		   File schemaFile= ResourceUtils.getFile("classpath:employee.json");
		   JsonSchema schema =ValidationUtils.getSchemaNode(schemaFile);
		   JsonNode node = ValidationUtils.getJsonNode(payload);
		    if (ValidationUtils.isJsonValid(schema,node)){
		    	System.out.println("Valid!");
		    	LOGGER.info("message is valid and do further processing"); 
		    }else{
		    	LOGGER.info("message is not valid and do further correction of data"); 
		    }
	   }
}
