package ro.fabio.controller;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.fabio.entity.Licitatie;
import ro.fabio.service.LicitatieService;

@Controller
public class QueueController {

	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	LicitatieService licitatieService;
	
	@Autowired
	@Qualifier("coada_licitatie")
	Destination coada_licitatie;
	
	@Autowired
	@Qualifier("topica_licitatie")
	Destination topica_licitatie;
	
	@RequestMapping("/queue/lic/{id}")
	public String insertInQueue(@PathVariable Integer id) {
		Licitatie lic = licitatieService.findOne(id);
		
		jmsTemplate.convertAndSend(coada_licitatie, lic);
		return "redirect:/index.html";
	}
	@RequestMapping("/topica/lic/{id}")
	public String insertInTopic(@PathVariable Integer id) {
		Licitatie lic = licitatieService.findOne(id);
		
		jmsTemplate.convertAndSend(topica_licitatie, lic);
		return "redirect:/index.html";
	}
}
