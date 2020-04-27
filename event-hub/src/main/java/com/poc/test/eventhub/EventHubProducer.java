package com.poc.test.eventhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
public class EventHubProducer {

	
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
			return "message sent to event hub for backend processing";
		}
	   
	   @GetMapping("/sender")
	   public String sendForm() {
	     return "<html><body>" +
	       "<H3>Please enter the payload to send to kafaka producer </H3>"+
	       "<form action=\"/registeremp\" method=\"post\">" +
	       "<textarea \" name=\"text\" rows=\"8\" cols=\"50\"></textarea>" +
	       "<input type=\"submit\">" +
	       "</form></body></html>";
	     }
}
