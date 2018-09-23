package com.example.omer.bootiful.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {


  @GetMapping("/hello")
  public String hello() {
    return "Merhaba";
  }

  @GetMapping("/authHello")
  public String authHello() {
    return "Merhaba auth";
  }
}
