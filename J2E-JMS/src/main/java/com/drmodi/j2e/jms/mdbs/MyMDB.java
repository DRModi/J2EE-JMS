package com.drmodi.j2e.jms.mdbs;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name="MyMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/myQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class MyMDB implements MessageListener{

	private static Logger LOGGER = Logger.getLogger(MyMDB.class.toString());
	
	public void onMessage(Message message) {
		if(message instanceof TextMessage) {
			try {
				String text = ((TextMessage) message).getText();
				LOGGER.info("*******  Received Message at Logger : " +text);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
