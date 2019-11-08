package com.drmodi.j2e.jms;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless //define stateless ejb beans
@LocalBean //define as local beans
public class MyMessageProducer {
	
	//JNDI Name
	@Resource(mappedName = "java:/queue/myQueue") 
	Queue myQueue;
	
	@Inject
	JMSContext jmsContext;
	
	public void sendMessage(String message) {
		jmsContext.createProducer().send(myQueue, message);
	}

}
