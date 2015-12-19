package ro.fabio.controller;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.fabio.entity.Licitatie;
import ro.fabio.service.LicitatieService;

@Controller
public class ConsumerTopicController implements MessageListener{

	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	LicitatieService licitatieService;
	
	@Autowired
	@Qualifier("topica_licitatie")
	Destination topica_licitatie;
	
	

	@Override
	public void onMessage(Message licenta) {
		System.out.println("in topic consumer........");
		// TODO Auto-generated method stub
	if(licenta instanceof ActiveMQObjectMessage){
		try {
			Licitatie lic = ((Licitatie)((ActiveMQObjectMessage)licenta).getObject());
			System.out.println("------------topica"+lic.getDescription());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
		
	}
}
