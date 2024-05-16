package com.example.taskifyapi.controller;

import com.example.taskifyapi.service.security.AuthFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "demo")
public class demoController {
  AuthFacade facade;
  //    @GetMapping()
  //    String username(@PathVariable String ov){
  //        return ov + " debila";
  //    }
}
