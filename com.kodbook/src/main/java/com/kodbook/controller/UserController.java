package com.kodbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodbook.entities.Post;
import com.kodbook.entities.User;
import com.kodbook.services.PostService;
import com.kodbook.services.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;
	@Autowired
	PostService postService;
	@PostMapping("/signUp")
	public String addUser(@ModelAttribute User user) {
		//user exists?
		String username = user.getUsername();
		String email = user.getEmail();
		boolean status = service.userExists(username, email);
		if(status == false) {
			service.addUser(user);
		}
		return "index";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username,
			@RequestParam String password,
			Model model)	{
		boolean status = service.validateUser(username, password);
		if(status == true) {
			List<Post> allPosts = postService.fetchAllPosts();
			model.addAttribute("allPosts", allPosts);
			return "home";
		}
		else {
			return "index";
		}
	}
}