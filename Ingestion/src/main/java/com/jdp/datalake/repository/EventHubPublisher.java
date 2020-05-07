package com.jdp.datalake.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;

@EnableBinding(Source.class)
public class EventHubPublisher<T> {
	   
	private T t;
		public T get(){
			return this.t;
		}
		
		public void set(T t1){
			this.t=t1;
		}

	@Autowired
	private Source source;
	public void pushEvent(T event) {
		   this.source.output().send(new GenericMessage<T> (event));
	}

}
