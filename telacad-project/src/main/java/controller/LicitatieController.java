package ro.fabio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ro.fabio.entity.Licitatie;
import ro.fabio.service.LicitatieService;

@Controller
@RequestMapping("licitatie")
public class LicitatieController {

	@Autowired
	private LicitatieService licitatieService;

	
	
	@RequestMapping("/detalii")
	public String doIndexPage(Model model,@RequestParam int licitatie_id) {

		model.addAttribute("licitatie",licitatieService.findOne(licitatie_id));
		return "detalii_licitatie";
	}

	
	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
		throw new RuntimeException("Only JPG images are accepted");
		}
		}

}
