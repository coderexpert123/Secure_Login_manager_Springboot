package com.smart.smartcontroller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.dao.Userrepositery;
import com.smart.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
	private Userrepositery userrepositery;
	
	
	@RequestMapping("/index")
	public String dashboard(Model model,Principal principal) {
		String usernameString=principal.getName();
	    User user=	userrepositery.getUserByUserName(usernameString);
		
		System.out.println("User Nma"+ usernameString);
		System.out.println("User"+user);
		model.addAttribute("user",user);
		return "normal/user_dashboard";
		
		
	}
}
