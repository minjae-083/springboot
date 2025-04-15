package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

  @GetMapping("test1")
  public String hello(Model model) {
    model.addAttribute("data1", "this is data");
    return "templates-test2";
  }
}