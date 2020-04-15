package com.example.easylogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.easylogin.model.dao.UserRepository;
import com.example.easylogin.model.entity.User;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepos;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/login")
	public String login(
			@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			Model m) {
		String message = "Welcome!";
		
		List<User> users = userRepos.findByUserNameAndPassword(userName,password);
		if(users.size() > 0) {
			User user = users.get(0);
			message += user.getfullName();
		}else{
			message += "guest";
		}
		m.addAttribute("message",message);
		
		return "login";
	}
	public String showUsers() {		
		List<User> users = userRepos.findAll();
		
		User user = users.get(0);
		
		String info = user.getUserName()+ " "+ user.getPassword();
		
		return info;
		
	}

}

