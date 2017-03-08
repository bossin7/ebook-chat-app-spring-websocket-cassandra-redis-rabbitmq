package br.com.jorgeacetozi.ebookChat.authentication.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.jorgeacetozi.ebookChat.authentication.domain.model.User;
import br.com.jorgeacetozi.ebookChat.authentication.domain.service.UserService;

@Controller
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/new-account")
	public String newAccount(Model model){
		model.addAttribute("user", new User());
		return "new-account";
	}

	@RequestMapping(path="/new-account", method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "new-account";
		}
		userService.createUser(user);
	    return "redirect:/";
	}
}