package com.poc.test.eventhub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Header;

import com.microsoft.azure.spring.integration.core.AzureHeaders;
import com.microsoft.azure.spring.integration.core.api.Checkpointer;
@EnableBinding(Sink.class)
public class EventhubSink {
	 private static final Logger LOGGER = LoggerFactory.getLogger(Sink.class);

	   @StreamListener(Sink.INPUT)
	   public void handleMessage(String message) {
	      LOGGER.info("New message received in event hub: '{}'", message);    
	   }
}
