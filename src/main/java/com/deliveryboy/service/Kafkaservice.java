package com.deliveryboy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Kafkaservice {
  
	/// template<key, value>   as a string
	@Autowired
	private KafkaTemplate<String, String>  template;
	
	private Logger log= LoggerFactory.getLogger(Kafkaservice.class);
	
	public boolean updateLocation(String location) {
		this.template.send("location-update",location);
	  this.log.info("message produced");
		
		return true;
	}
}
