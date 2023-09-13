package org.example.sergey.patseev.qwiqqer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
public class UserController {

	@GetMapping
	public String sayHello(){
		return "templates/hello";
	}
}
