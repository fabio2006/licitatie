package ro.fabio.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import ro.fabio.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	

	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String name = principal.getName();
//		model.addAttribute("user", userService.findOneWithBlogs(name));
		return "account";
	}
	
	
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddBlog(Model model, BindingResult result,
			Principal principal) {
		if (result.hasErrors()) {
			return account(model, principal);
		}
		String name = principal.getName();
		
		return "redirect:/account.html";
	}
	

	
	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
		throw new RuntimeException("Only JPG images are accepted");
		}
		}

}
