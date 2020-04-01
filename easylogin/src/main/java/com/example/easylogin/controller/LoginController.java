package com.example.easylogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.easylogin.model.dao.UserRepository;
import com.example.easylogin.model.entity.User;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepos;
	
	@RequestMapping("/")
	@ResponseBody
	public String showUsers() {		
		List<User> users = userRepos.findAll();
		
		User user = users.get(0);
		
		String info = user.getUserName()+ " "+ user.getPassword();
		
		return info;
		
	}

}

