package com;

import org.springframework.boot.SpringApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("nickname", "rhdrl");
		return "templates-test1";
	}
}