package com.balu.amq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class Sender {
	@Autowired
	private ApplicationContext ctx;
	
	//@SendTo("TestQ.queue")
	//public String sendMessage() throws JMSException {
	//	String response  = "Hello World Sender.sendMessage";
	//	return response;
	//}
	
	public void sendToQ(String name) {
		JmsTemplate jms = ctx.getBean(JmsTemplate.class);
		jms.convertAndSend("TestQ.queue", "test message"+name);
	}
	
	 @JmsListener(destination = "${destination.queue}")
	  public void receive(String message) {
		 System.err.println("....Read from Q1 - Value" + message);
	 }
	 
	 @JmsListener(destination = "${destination.queue}")
	  public void receive1(String message) {
		 System.err.println("....Read from Q2 - Value" + message);
	 }
}
