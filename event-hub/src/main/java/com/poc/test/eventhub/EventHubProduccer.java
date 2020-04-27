package com.poc.test.eventhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
public class EventHubProduccer {

	
	 @Autowired
	   private Source source;
	   @PostMapping("/register")
	   public String register(@RequestBody Employee employee) {
		   this.source.output().send(new GenericMessage<>(employee));
			return "Employee info sent to event hub for registeration";
		}
	   @PostMapping("/registeremp")
	   public String register(@RequestBody String message) {
		   this.source.output().send(new GenericMessage<>(message));
			return "Employee info sent to event hub for registeration";
		}
	   
	   @GetMapping("/sender")
	   public String sendForm() {
	     return "<html><body>" +
	       "<form action=\"/registeremp\" method=\"post\">" +
	       "<input type=\"text\" name=\"text\">" +
	       "<input type=\"submit\">" +
	       "</form></body><html>";
	     }
}
