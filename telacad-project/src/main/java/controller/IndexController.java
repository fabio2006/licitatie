package ro.fabio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import ro.fabio.entity.Licitatie;
import ro.fabio.service.LicitatieService;

@Controller
public class IndexController {

	@Autowired
	private LicitatieService licitatieService;

	@RequestMapping("/")
	public String doHomePage(Model model) {

		model.addAttribute("licitatii",licitatieService.findAll());
		return "listaLicitatii";
	}
	@RequestMapping("/index")
	public String doIndexPage(Model model) {

		model.addAttribute("licitatii",licitatieService.findAll());
		return "index";
	}

	
	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
		throw new RuntimeException("Only JPG images are accepted");
		}
		}

}
